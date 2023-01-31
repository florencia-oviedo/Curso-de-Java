
public class manipulacion_cadenas {

	public static void main(String[] args) {
		
		String nombre = "Florencia";
		
		System.out.println("Mi nombre es "+nombre);
		
		System.out.println("Mi nombre tiene "+ nombre.length() + " letras");
		
		System.out.println("La primera letra de "+ nombre +" es la "+ nombre.charAt(0));
		
		int ultimaLetra = nombre.length();
		System.out.println("La última letra del nombre "+ nombre +" es "+ nombre.charAt(ultimaLetra -1));
		
		

	}

}
