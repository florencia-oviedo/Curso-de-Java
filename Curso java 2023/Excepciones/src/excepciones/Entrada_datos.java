package excepciones;

import java.io.IOException;
import java.util.*;

public class Entrada_datos {

	public static void main(String[] args) {
		
		System.out.println("¿Que deseas hacer?");
		System.out.println("1. Introducir datos");
		System.out.println("2. Salir del programa");
		
		Scanner entrada=  new Scanner(System.in);
		
		int decision = entrada.nextInt();
		
		if(decision == 1) {
			try {
				pedirDatos();
			}catch(Exception e) {
				//System.out.println("Error de tipo en edad");
			}
			
		}
		else {
			System.out.println("Adiós");
			System.exit(0);
		}
		
		entrada.close();

	}
	
	static void pedirDatos() throws IOException {
		
		//try {
		Scanner entrada=  new Scanner(System.in);
		System.out.println("Introduce tu nombre: ");
		String nombre_usuario = entrada.nextLine();
		System.out.println("Introduce tu edad: ");
		int edad = entrada.nextInt();
		System.out.println("Hola "+nombre_usuario + ". El año que viene tendrás "+(edad+1)+" años.");
		entrada.close();
			
		//}
		//catch(Exception e) {
			//System.out.println("Error de tipo en edad");
		//}
		System.out.println("Hemos terminado");
	}

}
