package hilos;

import main.Main;

public class RunTiempo implements Runnable{

	private Object monitor=new Object();
	public static int numeroAleatorio;
	public static int numeroIntroducido;
	public static boolean acertado=true;

	@Override
	public void run() {
		do {
			
			numeroAleatorio=(int) Math.round(Math.random()*5);
			synchronized (monitor) {
			numeroIntroducido=-1;
			System.out.println("Numero generado:" + numeroAleatorio);
			try {
				monitor.wait(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(numeroIntroducido+" vs "+numeroAleatorio);	
		}
		while(numeroAleatorio!=numeroIntroducido); 
		acertado=false;
		System.out.println("Enhorabuena, acertaste!!");
	}

}

