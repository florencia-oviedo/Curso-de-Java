package clases_propias;


public class UsoEmpleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class Empleado{
	
	private String nombre;
	private int edad;
	private double salario;
	
	public Empleado(String nombre, int edad,double salario) {
		this.nombre = nombre;
		this.edad = edad;
		this.salario = salario;
	}
	
	public double getSueldo() {
		return this.salario;
	}
	
	public String dameDatos() {
		return "El empleado se llama "+nombre+". Tiene "+edad+" años. Y un salario de "+salario;
	}
}

class Jefe extends Empleado{
	
	public Jefe(String nom,int edad , double salario){
		
		super(nom,edad,salario);	
	}
	
	double incentivo(double inc) {
		return inc;
	}
	
}
