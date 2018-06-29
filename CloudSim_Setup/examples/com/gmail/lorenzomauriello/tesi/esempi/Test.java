package com.gmail.lorenzomauriello.tesi.esempi;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



public class Test {

	public static void main(String[] args) throws IOException {
		
		BufferedWriter bw = new BufferedWriter (new FileWriter("CloudSimLogTempi.txt"));
		PrintWriter outFile = new PrintWriter (bw);
		outFile.println("Il professore aveva detto che potevamo visualizzare il nostro esempio tenendo conto di 3 variabili utenti, rate, tempo.");
		
		outFile.println("Variazione del tempo.");
	            
		double inizio = System.currentTimeMillis();
		
		new BenchmarksSimulazioniEsempio_10_1_60();
		
		double fine = System.currentTimeMillis();
        double tempoEsecuzione =(fine-inizio)/1000;
        outFile.println("IL TEMPO TOTALE DELLA SIMULAZIONE -"+BenchmarksSimulazioniEsempio_10_1_60.class.getSimpleName()+": TIME ->"+ tempoEsecuzione +" secondi");
        
        /**######################################################################*/
        System.out.println(" ");
        inizio = System.currentTimeMillis();
		
		new BenchmarksSimulazioniEsempio_10_1_120();
		
		fine = System.currentTimeMillis();
        tempoEsecuzione =(fine-inizio)/1000;
        outFile.println("IL TEMPO TOTALE DELLA SIMULAZIONE -"+BenchmarksSimulazioniEsempio_10_1_120.class.getSimpleName()+": TIME ->"+ tempoEsecuzione +" secondi");
        /**######################################################################*/
        System.out.println(" ");
        inizio = System.currentTimeMillis();
		 
		new BenchmarksSimulazioniEsempio_10_1_180();
		 
		fine = System.currentTimeMillis();
        tempoEsecuzione =(fine-inizio)/1000;
        outFile.println("IL TEMPO TOTALE DELLA SIMULAZIONE -"+BenchmarksSimulazioniEsempio_10_1_180.class.getSimpleName()+": TIME ->"+ tempoEsecuzione +" secondi");
        /**######################################################################*/
        System.out.println(" ");
        inizio = System.currentTimeMillis();
		 
		new BenchmarksSimulazioniEsempio_10_1_240();
		 
		fine = System.currentTimeMillis();
        tempoEsecuzione =(fine-inizio)/1000;
        outFile.println("IL TEMPO TOTALE DELLA SIMULAZIONE -"+BenchmarksSimulazioniEsempio_10_1_240.class.getSimpleName()+": TIME ->"+ tempoEsecuzione +" secondi");
        /**######################################################################*/
        System.out.println(" ");
        inizio = System.currentTimeMillis();
		 
		new BenchmarksSimulazioniEsempio_10_1_300();
		 
		fine = System.currentTimeMillis();
        tempoEsecuzione =(fine-inizio)/1000;
        outFile.println("IL TEMPO TOTALE DELLA SIMULAZIONE -"+BenchmarksSimulazioniEsempio_10_1_300.class.getSimpleName()+": TIME ->"+ tempoEsecuzione +" secondi");
        /**######################################################################*/
        System.out.println(" ");
        inizio = System.currentTimeMillis();
		 
		new BenchmarksSimulazioniEsempio_10_1_360();
		 
		fine = System.currentTimeMillis();
        tempoEsecuzione =(fine-inizio)/1000;
        outFile.println("IL TEMPO TOTALE DELLA SIMULAZIONE -"+BenchmarksSimulazioniEsempio_10_1_360.class.getSimpleName()+": TIME ->"+ tempoEsecuzione +" secondi");
        /**######################################################################*/
        System.out.println(" ");
        inizio = System.currentTimeMillis();
		 
		new BenchmarksSimulazioniEsempio_10_1_420();
		 
		fine = System.currentTimeMillis();
        tempoEsecuzione =(fine-inizio)/1000;
        outFile.println("IL TEMPO TOTALE DELLA SIMULAZIONE -"+BenchmarksSimulazioniEsempio_10_1_420.class.getSimpleName()+": TIME ->"+ tempoEsecuzione +" secondi");
        
        outFile.println("variazione utenti.");
        
        /**######################################################################*/
        System.out.println(" ");
        inizio = System.currentTimeMillis();
		
		new BenchmarksSimulazioniEsempio_20_1_60();
		
		fine = System.currentTimeMillis();
        tempoEsecuzione =(fine-inizio)/1000;
        outFile.println("IL TEMPO TOTALE DELLA SIMULAZIONE -"+BenchmarksSimulazioniEsempio_20_1_60.class.getSimpleName()+": TIME ->"+ tempoEsecuzione +" secondi");
        /**######################################################################*/
        System.out.println(" ");
        inizio = System.currentTimeMillis();
		
		new BenchmarksSimulazioniEsempio_30_1_60();
		
		fine = System.currentTimeMillis();
        tempoEsecuzione =(fine-inizio)/1000;
        outFile.println("IL TEMPO TOTALE DELLA SIMULAZIONE -"+BenchmarksSimulazioniEsempio_30_1_60.class.getSimpleName()+": TIME ->"+ tempoEsecuzione +" secondi");
        /**######################################################################*/
        System.out.println(" ");
        inizio = System.currentTimeMillis();
		
		new BenchmarksSimulazioniEsempio_40_1_60();
		
		fine = System.currentTimeMillis();
        tempoEsecuzione =(fine-inizio)/1000;
        outFile.println("IL TEMPO TOTALE DELLA SIMULAZIONE -"+BenchmarksSimulazioniEsempio_40_1_60.class.getSimpleName()+": TIME ->"+ tempoEsecuzione +" secondi");
        /**######################################################################*/
        System.out.println(" ");
        inizio = System.currentTimeMillis();
		
		new BenchmarksSimulazioniEsempio_50_1_60();
		
		fine = System.currentTimeMillis();
        tempoEsecuzione =(fine-inizio)/1000;
        outFile.println("IL TEMPO TOTALE DELLA SIMULAZIONE -"+BenchmarksSimulazioniEsempio_50_1_60.class.getSimpleName()+": TIME ->"+ tempoEsecuzione +" secondi");
        /**######################################################################*/
        System.out.println(" ");
        inizio = System.currentTimeMillis();
		
		new BenchmarksSimulazioniEsempio_60_1_60();
		
		fine = System.currentTimeMillis();
        tempoEsecuzione =(fine-inizio)/1000;
        outFile.println("IL TEMPO TOTALE DELLA SIMULAZIONE -"+BenchmarksSimulazioniEsempio_60_1_60.class.getSimpleName()+": TIME ->"+ tempoEsecuzione +" secondi");
        /**######################################################################*/
        System.out.println(" ");
        inizio = System.currentTimeMillis();
		
		new BenchmarksSimulazioniEsempio_70_1_60();
		
		fine = System.currentTimeMillis();
        tempoEsecuzione =(fine-inizio)/1000;
        outFile.println("IL TEMPO TOTALE DELLA SIMULAZIONE -"+BenchmarksSimulazioniEsempio_70_1_60.class.getSimpleName()+": TIME ->"+ tempoEsecuzione +" secondi");
        /**######################################################################*/
        System.out.println(" ");
        inizio = System.currentTimeMillis();
		
		new BenchmarksSimulazioniEsempio_80_1_60();
		
		fine = System.currentTimeMillis();
        tempoEsecuzione =(fine-inizio)/1000;
        outFile.println("IL TEMPO TOTALE DELLA SIMULAZIONE -"+BenchmarksSimulazioniEsempio_80_1_60.class.getSimpleName()+": TIME ->"+ tempoEsecuzione +" secondi");
        /**######################################################################*/
        System.out.println(" ");
        inizio = System.currentTimeMillis();
		
		new BenchmarksSimulazioniEsempio_90_1_60();
		
		fine = System.currentTimeMillis();
        tempoEsecuzione =(fine-inizio)/1000;
        outFile.println("IL TEMPO TOTALE DELLA SIMULAZIONE -"+BenchmarksSimulazioniEsempio_90_1_60.class.getSimpleName()+": TIME ->"+ tempoEsecuzione +" secondi");
        /**######################################################################*/
        System.out.println(" ");
        inizio = System.currentTimeMillis();
		
		new BenchmarksSimulazioniEsempio_100_1_60();
		
		fine = System.currentTimeMillis();
        tempoEsecuzione =(fine-inizio)/1000;
        outFile.println("IL TEMPO TOTALE DELLA SIMULAZIONE -"+BenchmarksSimulazioniEsempio_100_1_60.class.getSimpleName()+": TIME ->"+ tempoEsecuzione +" secondi");
        
        outFile.println("variazione rate");
        
        /**######################################################################*/
        System.out.println(" ");
        inizio = System.currentTimeMillis();
		
		new BenchmarksSimulazioniEsempio_10_2_60();
		
		fine = System.currentTimeMillis();
        tempoEsecuzione =(fine-inizio)/1000;
        outFile.println("IL TEMPO TOTALE DELLA SIMULAZIONE -"+BenchmarksSimulazioniEsempio_10_2_60.class.getSimpleName()+": TIME ->"+ tempoEsecuzione +" secondi");
        /**######################################################################*/
        System.out.println(" ");
        inizio = System.currentTimeMillis();
		
		new BenchmarksSimulazioniEsempio_10_3_60();
		
		fine = System.currentTimeMillis();
        tempoEsecuzione =(fine-inizio)/1000;
        outFile.println("IL TEMPO TOTALE DELLA SIMULAZIONE -"+BenchmarksSimulazioniEsempio_10_3_60.class.getSimpleName()+": TIME ->"+ tempoEsecuzione +" secondi");
        /**######################################################################*/
        System.out.println(" ");
        inizio = System.currentTimeMillis();
		
		new BenchmarksSimulazioniEsempio_10_4_60();
		
		fine = System.currentTimeMillis();
        tempoEsecuzione =(fine-inizio)/1000;
        outFile.println("IL TEMPO TOTALE DELLA SIMULAZIONE -"+BenchmarksSimulazioniEsempio_10_4_60.class.getSimpleName()+": TIME ->"+ tempoEsecuzione +" secondi");
        /**######################################################################*/
        System.out.println(" ");
        inizio = System.currentTimeMillis();
		
		new BenchmarksSimulazioniEsempio_10_5_60();
		
		fine = System.currentTimeMillis();
        tempoEsecuzione =(fine-inizio)/1000;
        outFile.println("IL TEMPO TOTALE DELLA SIMULAZIONE -"+BenchmarksSimulazioniEsempio_10_5_60.class.getSimpleName()+": TIME ->"+ tempoEsecuzione +" secondi");
        /**######################################################################*/
        System.out.println(" ");
        inizio = System.currentTimeMillis();
		
		new BenchmarksSimulazioniEsempio_10_6_60();
		
		fine = System.currentTimeMillis();
        tempoEsecuzione =(fine-inizio)/1000;
        outFile.println("IL TEMPO TOTALE DELLA SIMULAZIONE -"+BenchmarksSimulazioniEsempio_10_6_60.class.getSimpleName()+": TIME ->"+ tempoEsecuzione +" secondi");
        /**######################################################################*/
        System.out.println(" ");
        inizio = System.currentTimeMillis();
		
		new BenchmarksSimulazioniEsempio_10_7_60();
		
		fine = System.currentTimeMillis();
        tempoEsecuzione =(fine-inizio)/1000;
        outFile.println("IL TEMPO TOTALE DELLA SIMULAZIONE -"+BenchmarksSimulazioniEsempio_10_7_60.class.getSimpleName()+": TIME ->"+ tempoEsecuzione +" secondi");
        /**######################################################################*/
        System.out.println(" ");
        inizio = System.currentTimeMillis();
		
		new BenchmarksSimulazioniEsempio_10_8_60();
		
		fine = System.currentTimeMillis();
        tempoEsecuzione =(fine-inizio)/1000;
        outFile.println("IL TEMPO TOTALE DELLA SIMULAZIONE -"+BenchmarksSimulazioniEsempio_10_8_60.class.getSimpleName()+": TIME ->"+ tempoEsecuzione +" secondi");
        /**######################################################################*/
        System.out.println(" ");
        inizio = System.currentTimeMillis();
		
		new BenchmarksSimulazioniEsempio_10_9_60();
		
		fine = System.currentTimeMillis();
        tempoEsecuzione =(fine-inizio)/1000;
        outFile.println("IL TEMPO TOTALE DELLA SIMULAZIONE -"+BenchmarksSimulazioniEsempio_10_9_60.class.getSimpleName()+": TIME ->"+ tempoEsecuzione +" secondi");
        /**######################################################################*/
        System.out.println(" ");
        inizio = System.currentTimeMillis();
		
		new BenchmarksSimulazioniEsempio_10_10_60();
		
		fine = System.currentTimeMillis();
        tempoEsecuzione =(fine-inizio)/1000;
        outFile.println("IL TEMPO TOTALE DELLA SIMULAZIONE -"+BenchmarksSimulazioniEsempio_10_10_60.class.getSimpleName()+": TIME ->"+ tempoEsecuzione +" secondi");
        
        
        
        outFile.close();
	}

}
