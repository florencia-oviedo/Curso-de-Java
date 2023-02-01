package poo;

import java.util.Date;
import java.util.GregorianCalendar;

public class Uso_Persona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona [] Personas= new Persona[2];
		Personas[0]= new Empleado2("Luis Conde",50000,2009,2,25);
		Personas[1] = new Alumno("Ana Lopez","Biologicas");
		
		for(Persona p:Personas) {
			System.out.println(p.dameNombre()+", "+p.dameDescripcion());
			
		}

	}

}

abstract class Persona{
	
	private String nombre;
	
	public Persona(String nom) {
		
		nombre = nom;
		
	}
	
	public String dameNombre(){
		return nombre;
	}
	
	public abstract String dameDescripcion();
	
	
	
}




class Empleado2 extends Persona {
	
	public Empleado2(String nom,double sue,int agno, int mes,int dia) {
		super(nom);
		Empleado2.idSiguiente++;
		id = idSiguiente;
		sueldo = sue;
		GregorianCalendar calendario = new GregorianCalendar(agno,mes-1,dia);
		altaContrato = calendario.getTime();
	}
	
	public String dameDescripcion() {
		return "Este empleado tiene un id = "+ id + " con un sueldo = "+ sueldo;
	}
	

	public double dameSueldo() { //getter
		return sueldo;
	}
	
	public Date dameFechaContrato() {
		return altaContrato;
	}
	
	public void subeSueldo(double porcentaje) {
		double aumento = sueldo * porcentaje / 100;
		sueldo += aumento;
	}
	
	private double sueldo;
	private Date altaContrato;
	private int id;
	private static int idSiguiente = 0;
	
}

class Alumno extends Persona{
	
	private String carrera;
	
	public Alumno(String nom,String car) {
		super(nom);
		carrera = car;
	}
	
	public String dameDescripcion() {
		return "Este alumno esta estudiando la carrera de "+carrera;
	}
	
	

}