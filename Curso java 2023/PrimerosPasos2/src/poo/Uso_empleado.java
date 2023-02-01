package poo;

import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

public class Uso_empleado {

	public static void main(String[] args) {
		
		/*Empleado empleado1 = new Empleado("Paco Gomez",85000,1990,12,17);
		
		Empleado empleado2 = new Empleado("Ana Lopez",95000,1995,6,2);
		
		Empleado empleado3 = new Empleado("Maria Martin",105000,2005,3,15);
		
		empleado1.subeSueldo(5);
		empleado2.subeSueldo(5);
		empleado3.subeSueldo(5);
		System.out.println("Nombre: " + empleado1.damenombre() + " Sueldo: "+ empleado1.dameSueldo() + " Fecha de Alta: "+ empleado1.dameFechaContrato());
		System.out.println("Nombre: " + empleado2.damenombre() + " Sueldo: "+ empleado2.dameSueldo() + " Fecha de Alta: "+ empleado2.dameFechaContrato());
		System.out.println("Nombre: " + empleado3.damenombre() + " Sueldo: "+ empleado3.dameSueldo() + " Fecha de Alta: "+ empleado3.dameFechaContrato());*/
		
		Jefe jefe_RRHH = new Jefe("Juan",55000,2006,9,25);
		
		jefe_RRHH.estableceIncentivo(2570);
		
		
		Empleado [] misEmpleados = new Empleado[6];
		
		misEmpleados [0] = new Empleado("Paco Gomez",85000,1990,12,17);
		misEmpleados [1] = new Empleado("Ana Lopez",95000,1995,6,2);
		misEmpleados [2] = new Empleado("Maria Martin",105000,2005,3,15);
		misEmpleados [3] = new Empleado("Florencia");
		misEmpleados [4] = jefe_RRHH;
		misEmpleados [5] = new Jefe("Maria",95000,1999,5,26);
		
		Jefe jefa_Finanzas = (Jefe) misEmpleados[5];
		jefa_Finanzas.estableceIncentivo(55000);
		
		
		
		
		
		/*for(int i = 0; i<3;i++) {
			misEmpleados[i].subeSueldo(5);
		}
		
		for(int i = 0; i<3;i++) {
			System.out.println("Nombre: " + misEmpleados[i].damenombre() + " Sueldo: "+ misEmpleados[i].dameSueldo() + " Fecha de Alta: "+ misEmpleados[i].dameFechaContrato());
		}*/
		
		//Con el for each mejorado
		
		System.out.println(jefa_Finanzas.tomar_decisiones("Dar más días de vacaciones a los empleados"));
		System.out.println("El jefe "+ jefa_Finanzas.damenombre() + " tiene un bonus de: "+ jefa_Finanzas.establece_bonus(500));
		System.out.println( misEmpleados[3].damenombre() + " tiene un bonus de: "+ misEmpleados[3].establece_bonus(200));
		
		for(Empleado e: misEmpleados) {
			e.subeSueldo(5);
		}
		
		Arrays.sort(misEmpleados);
		
		for(Empleado e: misEmpleados) {
			System.out.println("Nombre: " + e.damenombre() + " Sueldo: "+ e.dameSueldo() + " Fecha de Alta: "+ e.dameFechaContrato());
		}
		
		
		
		
		
	}

}

class Empleado implements Comparable, Trabajadores{
	
	public Empleado(String nom,double sue,int agno, int mes,int dia) {
		Empleado.idSiguiente++;
		id = idSiguiente;
		nombre = nom;
		sueldo = sue;
		GregorianCalendar calendario = new GregorianCalendar(agno,mes-1,dia);
		altaContrato = calendario.getTime();
	}
	
	public double establece_bonus(double gratificacion) {
		return Trabajadores.bonus_base + gratificacion;
	}
	
	
	public Empleado(String nom) {
		this(nom,30000,2000,01,01);
	}
	
	public String damenombre() { //getter nombre
		return nombre + " id: "+ id;
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
	
	private String nombre;
	private double sueldo;
	private Date altaContrato;
	private int id;
	private static int idSiguiente = 0;
	
	public int compareTo(Object miObjeto){
		
		Empleado otroEmpleado = (Empleado) miObjeto;
		if(this.id < otroEmpleado.id) {
			return -1;
		}
		if(this.id>otroEmpleado.id) {
			return 1;
		}
		return 0;
	}
	
}

class Jefe extends Empleado implements Jefes1 {
	
	public Jefe(String nom,double sue, int agno, int mes, int dia){
		
		super(nom,sue,agno,mes,dia);	
	}
	
	public String tomar_decisiones(String decision) {
		return "Un miembro de la dirección ha tomado la decisión de: "+ decision;
	}
	
	public double establece_bonus(double gratificacion) {
		double prima = 2000;
		return  Trabajadores.bonus_base + gratificacion + prima;
	}
	
	
	public void estableceIncentivo(double b) {
		incentivo = b;
	}
	
	public double dameSueldo() {
		double sueldoJefe =  super.dameSueldo();
		return sueldoJefe + incentivo;
	}
	
	private double incentivo;
}

