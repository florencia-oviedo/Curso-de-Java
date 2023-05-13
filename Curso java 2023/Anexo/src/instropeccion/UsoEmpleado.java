package instropeccion;

public class UsoEmpleado {
	public static void main(String[] args) {
		
		Persona antonio = new Persona("Antonio");
		System.out.println(antonio.getNombre());
		
		Empleado ana=  new Empleado("Ana",35000);
		System.out.println(ana.getNombre());
		System.out.println(ana.getSalario());
		
		//System.out.println(antonio.getClass()); Una forma 11
		//Class cl1 = antonio.getClass(); //forma 2
		//System.out.println(cl1.getName());
		Class cl1;
		String nombreClase= "instropeccion.Persona";
		try {
			cl1 = Class.forName(nombreClase);
			System.out.println(cl1);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
		nombreClase= "instropeccion.Empleado";
		try {
			cl1 = Class.forName(nombreClase);
			System.out.println(cl1);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}

}
class Persona{
	
	private String nombre;
	
	public Persona(String nombre) {
		this.nombre= nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
}
class Empleado extends Persona{
	
	private double salario;

	public Empleado(String nombre, double salario) {
		super(nombre);
		this.salario= salario;
	}
	
	public void setIncentivo(double incentivo) {
		this.salario += incentivo;
	}
	
	public String getSalario() {
		return "El salario es: "+this.salario;
	}
	
	
}