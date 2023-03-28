package usothreads;

//Clase 4 Threads

public class SincronizandoHilos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HilosVarios hilo1 = new HilosVarios();
		HilosVarios2 hilo2 = new HilosVarios2(hilo1);//Clase 5 Thread,Hasta que no termine hilo1 su ejecucion no comenzara el hilo2
		hilo2.start();// no importa el orden, empezamos con el hilo2 pero comienza hasta q termina hilo1
		hilo1.start();
		
		System.out.println("Terminadas las tareas"); //Hilo del main, se ejecuta primero antes q el hilo2 sin join
	}

}
class HilosVarios extends Thread{
	
	public void run() { //se llama automaticamente
		for(int i=0;i<15;i++) {
			System.out.println("Ejecutando Hilos "+ getName());//con getName me da el nombre de hilo interno de Java
			try {
				Thread.sleep(500); //Para q ejecute mas lento
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}
}
class HilosVarios2 extends Thread{
	private Thread hilo;
	
	public HilosVarios2(Thread hilo) {
		this.hilo = hilo;
	}
	
	public void run() { //se llama automaticamente
		
		try {
			hilo.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i=0;i<15;i++) {
			System.out.println("Ejecutando Hilos "+ getName());//con getName me da el nombre de hilo interno de Java
			try {
				Thread.sleep(500); //Para q ejecute mas lento
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}
}