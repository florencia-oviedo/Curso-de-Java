package colecciones;
import java.util.*;

public class PruebaLinkedList {

	public static void main(String[] args) {
		
		LinkedList<String> personas = new LinkedList<String>();
		//Agregamos elementos
		personas.add("Pepe");
		personas.add("Sandra");
		personas.add("Ana");
		personas.add("Laura");
		
		//Para saber el tamaño
		System.out.println(personas.size());
		//agregamos un iterator
		
		ListIterator<String> it = personas.listIterator();//este iterador nos va a permitir accder a todas las opciones de iterator
		
		it.next(); //Esta en la primera posicion
		it.add("Flor");//va a estar entre Pepe Y Sandra
		
		
		//imprimr en consola todos los elementos
		for(String persona:personas) {
			System.out.println(persona);
		}//salen ordenadas en el mismo orden q los agregamos a los elementos
		
		
		
		
		
		
	}

}
