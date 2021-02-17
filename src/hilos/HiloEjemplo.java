package hilos;

public class HiloEjemplo implements Runnable{

	private static Object monitor=new Object();
	private int inicioCuenta;
	
	public HiloEjemplo(int inicioCuenta) {
		this.inicioCuenta=inicioCuenta;
	}
	
	@Override
	public void run() {
		//int finCuenta=inicioCuenta+100;
		for(int i=0;i<=100;i++) {
			System.out.println(i);
		}
		
	}

}
