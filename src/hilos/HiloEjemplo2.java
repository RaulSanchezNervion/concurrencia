package hilos;

public class HiloEjemplo2 implements Runnable{

	private static Object monitor=new Object();
	private  int  sumatorio;
	
	public HiloEjemplo2() {
		//this.inicioCuenta=inicioCuenta;
	}
	
	@Override
	public void run() {
		//int finCuenta=inicioCuenta+100;
		ejemplo();
		
	}

	private void ejemplo() {
		for(int i=1;i<=100;i++) {		
			sumatorio++;
			System.out.println(sumatorio);
		}
		
	}

}
