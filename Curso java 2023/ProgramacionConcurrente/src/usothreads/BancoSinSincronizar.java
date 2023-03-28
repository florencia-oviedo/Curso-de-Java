package usothreads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BancoSinSincronizar {

	public static void main(String[] args) {
		
		Banco b = new Banco();
		for(int i=0;i<100;i++) {
			EjecucionTransferencias r = new EjecucionTransferencias(b,i,2000);
			Thread t = new Thread(r);
			t.start();
		}
		

	}

}
class Banco {
	//campo de clase para almacenar las 100 cuentas
	private final double[] cuentas;
	//private Lock cierreBanco= new ReentrantLock(); //variable de tipo Lock interface que contiene un objeto de tipo ReentrantLock
	//private Condition saldoSuficiente;
	
	//constructor
	public Banco() {
		cuentas = new double[100];//creamos las 100 cuentas
		for(int i=0;i<cuentas.length;i++) {
			cuentas[i]=2000; //le pasamos 2000 pesos a cada cuenta
		}
		//saldoSuficiente = cierreBanco.newCondition()//le decimos que el bloqueo cierreBanco tiene que establecerse en base a una condicion
		
;	}
	
	//metodo para hacer las transferencias
	//especificar la cuenta de origen , cuenta destino, cantidad de dinero a transferir
	
	public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException {
		//cierreBanco.lock();//bloquea al siguiente hilo para que no entre al codigo
		//try {
		//comprobar que la cantidad de dinero no supere la cantidad q tiene la cuenta origen
		while(cuentas[cuentaOrigen]< cantidad) {//evalua que el saldo no sea inferior a la transferencia
			//System.out.println("---------------CANTIDAD INSUFICIENTE "+ cuentaOrigen+"....SALDO: "+cuentas[cuentaOrigen]+"....CANTIDAD:"+cantidad);
			//return;
			//saldoSuficiente.await(); //Mientras sea verdad que el hilo se mantenga a la espera
			wait();
		}
		//Q se imprima el thread para saber que hilo hace la transferencia es meramente informativo
		System.out.println(Thread.currentThread());
		cuentas[cuentaOrigen] -= cantidad;//dinero que sale de la cuenta origen
		
		System.out.printf("%10.2f de %d para %d", cantidad, cuentaOrigen, cuentaDestino);
		cuentas[cuentaDestino] += cantidad;
		
		System.out.printf(" Saldo total: %10.2f%n", getSaldoTotal());
		notifyAll();
		//saldoSuficiente.signalAll();
		//}
		/*finally {
			//cierreBanco.unlock();//desbloque el codigo para q entre el siguiente hilo
		}*/
	}
	public double getSaldoTotal() {
		double sumaCuentas =0;
		//sumamos el contenido de las cuentas recorriendo el array cuentas
		for(double a: cuentas) {
			sumaCuentas +=a;
		}
		return sumaCuentas;
	}
}

class EjecucionTransferencias implements Runnable {
	//campos de clase
	private Banco banco;
	private int deLaCuenta;
	private double cantidadMax;
	//constructor
	public EjecucionTransferencias(Banco b,int de,double max) {
		banco = b;
		deLaCuenta=de;
		cantidadMax = max;
		
	}
	
	@Override
	public void run() {
		try {
			while(true) {
			
				int paraLaCuenta = (int)(100*Math.random()); //para acceder a una cuenta random
				double cantidad = cantidadMax*Math.random();//cantidad a transferir , siempre da menos de 2000
			
				banco.transferencia(deLaCuenta, paraLaCuenta, cantidad);
			
				Thread.sleep((int)Math.random()*10); //para ver las transferencias lento
				
			}
		 } catch (InterruptedException e) {
				
				e.printStackTrace();
			}
	}
		
}
	

