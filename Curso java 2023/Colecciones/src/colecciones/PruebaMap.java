package colecciones;
import java.util.*;
public class PruebaMap {

	public static void main(String[] args) {
		
		
		//Clave de tipo string y valor como tipo empleado
		HashMap<String,Empleado> personal = new HashMap<String,Empleado>();
		//introducir objetos de tipo empleado
		personal.put("145", new Empleado("Juan"));//creamos el objeto adentro
		personal.put("146", new Empleado("Ana"));
		personal.put("147", new Empleado("Antonio"));
		personal.put("148", new Empleado("Sandra"));
		
		System.out.println(personal);
		
		//Como eliminamos un objeto de un mapa
		personal.remove("147");
		System.out.println(personal);
		
		//Sustitur un elemento que hay dentro del mapa
		//lo hacemos volviendo introducir un elemento con la misma clave
		personal.put("148", new Empleado("Florencia"));
		System.out.println(personal);
		
		//metodo entryset
		//System.out.println(personal.entrySet());//le decimos que nos devuelva una coleccion de tipo Set y q nos imprima
		
		for(Map.Entry<String, Empleado> entrada : personal.entrySet()) {
			Empleado valor = entrada.getValue();
			String clave = entrada.getKey();
			System.out.println("Clave = "+clave+", Valor = "+valor);
		}
		
		
		
	}

}

class Empleado { 
	
	//campos de clase
	private String nombre;
	private double sueldo;
	
	//Constructor
	public Empleado(String n) {
		nombre= n;
		sueldo = 2000; //todos van a tener el mismo sueldo
	}
	
	public String toString() {
		return "[Nombre = "+nombre+ ", Sueldo = "+sueldo+"]";
	}
}