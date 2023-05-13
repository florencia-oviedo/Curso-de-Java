package instropeccion;

import java.lang.reflect.*;
import java.util.Scanner;

public class PruebaInstropeccion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite el nombre de la clase");
		String nombreClase;
		
		nombreClase = entrada.next();
		
		//Imprimir clase y super clase 
		try {
			Class cl = Class.forName(nombreClase);
			Class supercl = cl.getSuperclass();
			
			System.out.println("Clase "+ nombreClase);
			
			if(supercl != null && supercl!= Object.class) {
				System.out.println("extends "+ supercl.getName());
			}
			System.out.println();
			
			imprimirConstructores(cl);
			
			System.out.println();
			
			imprimirMetodos(cl);
			
			System.out.println();
			
			imprimirCampos(cl);
			
		}catch(Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		
	}
	
	

	public static void imprimirConstructores(Class cl) {
		Constructor[] constructores = cl.getDeclaredConstructors();
		
		for(Constructor c : constructores) {
			String nombre = c.getName();
			System.out.print(" "+ Modifier.toString(c.getModifiers()));
			System.out.print(" "+ nombre + "(");
			//imprimir parametros
			
			Class[] tipoParam = c.getParameterTypes();
			for(int i=0 ; i< tipoParam.length;i++) {
				if(i>0) {
					System.out.print(",  ");
					System.out.print(tipoParam[i].getName());
				}
			}
			
			System.out.print(");");
			
		}
			
	}
	//imprime todos los metodos de las clases
	public static void imprimirMetodos(Class cl) {
		
		Method[] metodos = cl.getDeclaredMethods();
		
		for(Method m : metodos) {
			Class tipo = m.getReturnType();
			String nombre = m.getName();
			
			//Imprime modificadores , tipo y nombre
			System.out.print(" "+ Modifier.toString(m.getModifiers()));
			System.out.print(" "+ tipo.getName() + " " + nombre + "(");
			
			//imprime parametros
			Class [] tiposParam = m.getParameterTypes();
			for(int i=0 ; i< tiposParam.length;i++) {
				if(i>0) System.out.print(", ");
				System.out.print(tiposParam[i].getName());
					
				
			}
			System.out.println(");");			
		}
	}
	//Imprime los campos de la clase
	public static void imprimirCampos(Class cl) {
		Field [] campos = cl.getDeclaredFields();
		for(Field f: campos) {
			Class tipoCampo = f.getType();
			String nombre = f.getName();
			System.out.print(" "+ Modifier.toString(f.getModifiers()));	
			System.out.print(" "+ tipoCampo.getName() + " " + nombre + ";");
			System.out.println("");	
		}
	}
	
}
