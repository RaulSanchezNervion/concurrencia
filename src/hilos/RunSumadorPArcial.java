package hilos;

import main.Main;

public class RunSumadorPArcial implements Runnable{

	private int indiceMenor;
	private int indiceMayor;
	
	
	
	public RunSumadorPArcial(int indiceMenor, int indiceMayor) {
		super();
		this.indiceMenor = indiceMenor;
		this.indiceMayor = indiceMayor;
	}



	@Override
	public void run() {
		int sumador=0;
		for(int i=indiceMenor;i<indiceMayor;i++) {
			System.out.println(i);
			for(int j=0;j<Main.MAX;j++) {
				if(i!=j && Main.getArray()[i]==Main.getArray()[j])
					sumador+=Main.getArray()[i];
			}
			
		}
		synchronized (Main.getMonitor()) {
			Main.setSumatorio(Main.getSumatorio()+sumador);
			Main.setHilosTerminados(Main.getHilosTerminados()+1);
			if(Main.getHilosTerminados()==Main.NUM_HILOS)
				Main.getMonitor().notifyAll();
		}
		
	}

}
