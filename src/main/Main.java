package main;



import java.util.Scanner;

import clases.Cerrojo;
import hilos.HiloEjemplo;
import hilos.HiloEjemplo2;
import hilos.RunSumadorPArcial;
import hilos.RunTiempo;

public class Main {
	public static final int MAX=100000;
	public static final int NUM_HILOS = 2;
	private static int[] array=generateArray();
	private static Object monitor=new Object();
	private static int sumatorio;
	private static int hilosTerminados;
	
	public static void main(String[] args) {
		Cerrojo c=new Cerrojo();
		System.out.println(c);
		Runnable r=new HiloEjemplo2();
		Thread hilo=new Thread(r);
		Thread hilo2=new Thread(r);
		hilo.start();
		hilo2.start();
		/*Ejemplo ej=new Ejemplo();
		ej.clone();
		long startTime = System.currentTimeMillis();
		sumaParalela();
		System.out.println(System.currentTimeMillis()-startTime);
		startTime = System.currentTimeMillis();
		sumaSecuencial();
		System.out.println(System.currentTimeMillis()-startTime);*/
		
		/*Thread hilo1=new Thread(new HiloEjemplo(0));
		Thread hilo2=new Thread(new HiloEjemplo2(0));
		hilo1.start();
		hilo2.start();*/
		
	}

	private static int[] generateArray() {
		int[] array=new int[MAX];
		for(int i=0;i<MAX;i++) {
			array[i]=(int)Math.round(Math.random()*6);
		}
		return array;
	}

	public static void sumaSecuencial() {
		int sumatorio=0;
		for(int i=0;i<MAX;i++) {
			System.out.println(i);
			for(int j=0;j<MAX;j++) {
				if(i!=j && array[i]==array[j])
					sumatorio+=array[i];
			}
		}
		System.out.println("Sumatorio secuencial= "+sumatorio);
		
	}

	public static void sumaParalela() {
		int offset=MAX/NUM_HILOS;
		RunSumadorPArcial run1=new RunSumadorPArcial(0,offset*1);
		RunSumadorPArcial run2=new RunSumadorPArcial(offset*1,offset*2);
		//RunSumadorPArcial run3=new RunSumadorPArcial(offset*2,offset*3);
		//RunSumadorPArcial run4=new RunSumadorPArcial(offset*3,offset*4);
		Thread hilo1=new Thread(run1);
		Thread hilo2=new Thread(run2);
		//Thread hilo3=new Thread(run3);
		//Thread hilo4=new Thread(run4);
		hilo1.start();
		hilo2.start();
		//hilo3.start();
		//hilo4.start();
		synchronized (monitor) {
			try {
				monitor.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Sumatorio paralela= "+sumatorio);
	}

	public static int[] getArray() {
		return array;
	}

	public static Object getMonitor() {
		return monitor;
	}

	public static int getSumatorio() {
		return sumatorio;
	}

	public static void setArray(int[] array) {
		Main.array = array;
	}

	public static void setMonitor(Object monitor) {
		Main.monitor = monitor;
	}

	public static void setSumatorio(int sumatorio) {
		Main.sumatorio = sumatorio;
	}

	public static int getHilosTerminados() {
		return hilosTerminados;
	}

	public static void setHilosTerminados(int hilosTerminados) {
		Main.hilosTerminados = hilosTerminados;
	}

	
	
	

}
