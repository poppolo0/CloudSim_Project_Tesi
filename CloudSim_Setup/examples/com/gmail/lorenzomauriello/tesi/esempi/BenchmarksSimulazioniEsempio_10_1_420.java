package com.gmail.lorenzomauriello.tesi.esempi;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.cloudbus.cloudsim.*;
import org.cloudbus.cloudsim.core.CloudSim;
import org.cloudbus.cloudsim.provisioners.BwProvisionerSimple;
import org.cloudbus.cloudsim.provisioners.PeProvisionerSimple;
import org.cloudbus.cloudsim.provisioners.RamProvisionerSimple;

/**
 * 
 * In questo esempio si vuole valutare un web provider che offre 3 servizi web (A,B,C) con 3 diversi 
 * utilizzi delle risorse. Assumiamo di avere a disposizione n VMs e utilizzare tutte e due gli algoritmi di provisioning.
 * 
 * SCENARIO --> 1000 utienti che fanno richieste pari a 1cl/s del servizio A , B su n VMs diverse... 
 * 				confrontaere il throughput al variare della VM.
 * 
 * In sostanza si vuole creare 1 datacenter con 2 host e per ogni host 3 VMs, ora simuliamo l'invio di 1000 cloudlet al secondo 
 * e vediamo come viene gestito il carico e come le Vms Sono in grado di gestirlo. Naturalmente per questioni di persormance 
 * le Vms saranno divise in 2 gruppi a diversa potenza così da valutare anche un risparmio energetico.
 * 
 */
public class BenchmarksSimulazioniEsempio_10_1_420 {
    /**
     * Number of Processor Elements (CPU Cores) of each Host.
     */
    private static final int HOST_PES_NUMBER = 6;

    /**
     * Number of Processor Elements (CPU Cores) of each VM and cloudlet.
     */
    private static final int VM_PES_NUMBER = 1;

    /**
     * Number of Cloudlets to create simultaneously.
     * Other cloudlets will be enqueued.
     */
    private static final int NUMBER_OF_CLOUDLETS = 10;

    private final List<Host> hostList;
    private final List<Vm> vmList;
    private final List<Cloudlet> cloudletList;
    private DatacenterBroker broker;
    private final Datacenter datacenter;


    /**
     * Starts the example execution, calling the class constructor\
     * to build and run the simulation.
     *
     * @param args command line parameters
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
    	double inizio = System.currentTimeMillis();
    	
        new BenchmarksSimulazioniEsempio_10_1_420();
        
        double fine = System.currentTimeMillis();
        double tempoEsecuzione =(fine-inizio)/1000;
        
        Log.print("IL TEMPO TOTALE DELLA SIMULAZIONE: TIME ->"+ tempoEsecuzione +" secondi");
    }

    /**
     * costruttore di Default per avviare la simulazione.
     * @throws IOException 
     */
    public BenchmarksSimulazioniEsempio_10_1_420() throws IOException {
        Log.printLine("Starting "+ getClass().getSimpleName()+" ...");
        
        // First step: Initialize the CloudSim package. It should be called
        // before creating any entities.
        int num_user = 1;   // number of cloud users
     	Calendar calendar = Calendar.getInstance();
     	boolean trace_flag = false;  // mean trace events

     	// Initialize the CloudSim library
     	CloudSim.init(num_user, calendar, trace_flag);

        this.hostList = new ArrayList<>();
        this.vmList = new ArrayList<>();
        this.cloudletList = new ArrayList<>();
        // creo il datacenter
        this.datacenter = createDatacenter("Datacenter_0");
       //creo il broker come varibile di istanza
        try {
			this.broker = new DatacenterBroker("Broker" );
		} catch (Exception e) {
			this.broker =null;
			e.printStackTrace();
		}
		
        createAndSubmitVmAndCloudlets();
        
        NetworkTopology.addLink(datacenter.getId(),broker.getId(),10.0,1);
        
        runSimulationAndPrintResults();
        Log.printLine(getClass().getSimpleName()+" finished!" );
    }

    private void runSimulationAndPrintResults() throws IOException {
    	Log.disable();
    	
    	CloudSim.startSimulation();
    	
    	List<Cloudlet> newList = broker.getCloudletReceivedList();

		CloudSim.stopSimulation();
        Log.enable();
        printCloudletList(newList);
    }

    /**
     * Creates cloudlets and submit them to the broker, applying
     * a different submission delay for each one (simulating the dynamic cloudlet arrival).
     *
     * @param vmList.get(index) Vm to run the cloudlets to be created
     *
     * @see #createCloudlet(int, Vm, DatacenterBroker)
     */
    private void createAndSubmitCloudlets(List<Vm> vmList) {
        int cloudletId = cloudletList.size();
        long submissionDelay = 0;
        List<Cloudlet> list = new ArrayList<>(NUMBER_OF_CLOUDLETS);
        int conta =0;
        
        int cloudcount =NUMBER_OF_CLOUDLETS*420;
       
        for(int i = 0; i < cloudcount; i++){
            Cloudlet cloudlet = createCloudlet(cloudletId++, broker, submissionDelay);
          
            if(conta == NUMBER_OF_CLOUDLETS) {
            	 submissionDelay += 1;
            	 conta = 0;
            }
            
            conta++;
            list.add(cloudlet);
        }
        
        broker.submitCloudletList(list);
        
        cloudletList.addAll(list);
    }

    /**
     * Creates one Vm and a group of cloudlets to run inside it,
     * and submit the Vm and its cloudlets to the broker.
     *
     * @see #createVm(int, org.cloudbus.cloudsim.brokers.DatacenterBroker)
     */
    private void createAndSubmitVmAndCloudlets() {
        
        Vm vm = createVm(0,0); // aggiungendo 0 di base la macchina virtuale viene creata con un singolo core
        this.vmList.add(vm);
        Vm vm1 = createVm(0,3); 
        this.vmList.add(vm1);
        Vm vm2 = createVm(1,1);//2 core
        this.vmList.add(vm2);
        Vm vm3 = createVm(1,4);
        this.vmList.add(vm3);
        Vm vm4 = createVm(2,2);
        this.vmList.add(vm4);
        Vm vm5 = createVm(2,5);
        this.vmList.add(vm5);
        
        broker.submitVmList(this.vmList);
        

        createAndSubmitCloudlets(vmList);
    }

    /**
     * Creates a VM with pre-defined configuration.
     *
     * @param id the VM id
     * @param broker the broker that will be submit the VM
     * @return the created VM
     *
     */
    private Vm createVm(int pes,int id) {
    	int brokerId = broker.getId();
        int mips = 53840;
        long size = 10000; // image size (MEGABYTE)
        int ram = 2048; // vm memory (MEGABYTE)
        long bw = 1000;
        String vmm = "Xen"; //VMM name
        
        return new Vm(id, brokerId, mips, VM_PES_NUMBER + pes, ram, bw, size, vmm, new CloudletSchedulerTimeShared());
    }

    /**
     * Cloudlet di tipo A
     *
     * @param id Cloudlet id
     * @param vm vm to run the cloudlet
     * @param broker the broker that will submit the cloudlets
     * @return the created cloudlet
     */
    private Cloudlet createCloudlet(int id,  DatacenterBroker broker, long time) {
        long fileSize = 100;
        long outputSize = 1000;
        long length = 60000; //in number of Million Instructions (MI)
        int pesNumber = 1;
        UtilizationModel utilizationModel = new UtilizationModelFull();
        Cloudlet cloudlet1 = new Cloudlet(id, length, pesNumber, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel);
        
        cloudlet1.setUserId(broker.getId());

        cloudlet1.setDelaySend(time);
        return cloudlet1;
    }

    /**
     * Creates a Datacenter with pre-defined configuration.
     *
     * @return the created Datacenter
     */
    private Datacenter createDatacenter(String name) {
        Host host = createHost(0);
        hostList.add(host);
        Host host1 = createHost(1);
        hostList.add(host1);
        
        //Create a DatacenterCharacteristics object that stores the
		//    properties of a data center: architecture, OS, list of
		//    Machines, allocation policy: time- or space-shared, time zone
		//    and its price (G$/Pe time unit).
		String arch = "x86";      // system architecture
		String os = "Linux";          // operating system
		String vmm = "Xen";
		double time_zone = 10.0;         // time zone this resource located
		double cost = 3.0;              // the cost of using processing in this resource
		double costPerMem = 0.05;		// the cost of using memory in this resource
		double costPerStorage = 0.001;	// the cost of using storage in this resource
		double costPerBw = 0.0;			// the cost of using bw in this resource
		LinkedList<Storage> storageList = new LinkedList<Storage>();	//we are not adding SAN devices by now

		DatacenterCharacteristics characteristics = new DatacenterCharacteristics(
				arch, os, vmm, hostList, time_zone, cost, costPerMem,
				costPerStorage, costPerBw);

		Datacenter datacenter = null;
		try {
			datacenter = new Datacenter(name, characteristics, new VmAllocationPolicySimple(hostList), storageList, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return datacenter;
    }

    /**
     * ogni host ha 6gb di ram e un processore 
     * Intel Core i5 7300U 	53,840 MIPS da 2.6 GHz
     * 
     * @param id The Host id
     * @return the created host
     */
    private Host createHost(int id) {
        List<Pe> peList = new ArrayList<>();
        long mips = 53840;
        
        for(int i = 1; i <= HOST_PES_NUMBER; i++){
            peList.add(new Pe(i, new PeProvisionerSimple(mips)));
        }
        
        int ram = 6144; // in Megabytes
        long storage = 1000000; // in Megabytes
        int bw =  18500; //in Megabits/s che sono 2,3 GBs

        return new Host(id,new RamProvisionerSimple(ram),new BwProvisionerSimple(bw),storage,peList,new VmSchedulerTimeShared(peList));
    }
    
	private static void printCloudletList(List<Cloudlet> list) {
		int size = list.size();
		Cloudlet cloudlet;

		String indent = "    ";
		Log.printLine();
		Log.printLine("========== OUTPUT ==========");
		Log.printLine("Cloudlet ID" + indent + "STATUS" + indent +
				"Data center ID" + indent + "VM ID" + indent + "Time" + indent + "Start Time" + indent + "Finish Time");

		for (int i = 0; i < size; i++) {
			cloudlet = list.get(i);
			Log.print(indent + cloudlet.getCloudletId() + indent + indent);

			if (cloudlet.getCloudletStatus() == Cloudlet.SUCCESS){
				Log.print("SUCCESS");

				DecimalFormat dft = new DecimalFormat("###.##");
				Log.printLine( indent + indent + cloudlet.getResourceId() + indent + indent + indent + cloudlet.getVmId() +
						indent + indent + dft.format(cloudlet.getActualCPUTime()) + indent + indent + dft.format(cloudlet.getExecStartTime())+
						indent + indent + dft.format(cloudlet.getFinishTime()));
			}
		}

	}
}

