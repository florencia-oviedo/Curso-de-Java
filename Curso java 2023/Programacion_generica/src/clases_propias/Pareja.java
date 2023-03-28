package clases_propias;

public class Pareja <T> { //clase generica con un argumento generico de tipo T
	
	//Campo de clase generico
	private T primero;
	
	//constructor
	public Pareja() {
		primero = null;
	}
	//setter
	public void setPrimero(T nuevoValor) {
		primero = nuevoValor;
	}
	//getter
	
	public T getPrimero() {
		return primero;
	}
	
	public static void imprimirTrabajor(Pareja<? extends Empleado> p) { //Con ? extends incluimos a las subclases que pueda tener Empleado
		Empleado primero = p.getPrimero();
		System.out.println(primero);
	}
	
}
