package poo;

public class Pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Empleados trabajador1 = new Empleados("Paco");
		Empleados trabajador2 = new Empleados("Ana");
		
		trabajador1.cambiaSeccion("RRHH");
		
		System.out.println(trabajador1.devuelveDatos());
		
		System.out.println(trabajador2.devuelveDatos());
		System.out.println(Empleados.dameIdSiguiente());
		
		
	}

}
class Empleados{
	
	
	private final String nombre;
	private String seccion;
	private int id;
	private static int idSiguiente = 1;
	
	
	//Constructor
	
	public Empleados(String nom) {
		nombre = nom;
		seccion = "Administración";
		id = Empleados.idSiguiente;
		Empleados.idSiguiente++;

	}
	
	public void cambiaSeccion(String seccion) {
		this.seccion = seccion;
	}
	
	public String devuelveDatos() {
		return "El nombre es: "+ nombre + ", su id es: "+ id + " y la sección es: "+ seccion;
	}
	
	public static String dameIdSiguiente() {
		return "El id siguiente es: "+ Empleados.idSiguiente;
	}
	
	
}
