import java.util.*;

public class Entrada_ejemplo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce su nombre,por favor: ");
		String nombre = entrada.nextLine();
		
		System.out.println("Introduce su edad,por favor: ");
		int edad = entrada.nextInt();
		
		System.out.println("Hola "+nombre+" su edad es: "+edad);
		
		

	}

}
