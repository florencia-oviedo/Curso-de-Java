import java.util.*;
public class adivina_numero {

	public static void main(String[] args) {
		
		int aleatorio = (int)(Math.random()*100);
		Scanner entrada = new Scanner(System.in);
		int numero = 0;
		int intentos = 0;
		do{
			intentos++;
			System.out.println("Digite un número: ");
			numero = entrada.nextInt();
			if(aleatorio < numero) {
				System.out.println("Más bajo");
			}
			else if(aleatorio > numero) {
				System.out.println("Más alto");
			}
			
		} while(numero != aleatorio);
		System.out.println("Correcto. Lo haz conseguido en "+intentos+" intentos.");
	}

}
