package colecciones;

import java.util.*;

public class PruebaLinkedList2 {

	public static void main(String[] args) {
		//Lista de paises
		LinkedList<String> paises = new LinkedList<String>();
		//Agregamos elementos (paises)
		paises.add("España");
		paises.add("Colombia");
		paises.add("México");
		paises.add("Perú");
		
		//Creamos la segunda lista
		LinkedList<String> capitales = new LinkedList<String>();
		//Agregamos elementos (paises)
		capitales.add("Madrid");
		capitales.add("Bogotá");
		capitales.add("DF");
		capitales.add("Lima");
		
		//System.out.println(paises); //ejecuta [España, Colombia, México, Perú]
		//System.out.println(capitales); //[Madrid, Bogotá, DF, Lima]

		//Un Iterator se encarga de recorrer las listas y añadir/eliminar elementos
		//Para la primera lista
		ListIterator<String> it_paises = paises.listIterator();
		//Para la de capitales
		ListIterator<String> it_cap = capitales.listIterator();
		
		while(it_cap.hasNext()) {
			
			if(it_paises.hasNext()) {
				
				it_paises.next();
			}
			
			it_paises.add(it_cap.next());
		}
		
		System.out.println(paises);//[España, Madrid, Colombia, Bogotá, México, DF, Perú, Lima]
		
		//linkedlist capitales eliminar los numeros pares
		//Tener en cuenta que el iterator ahora se encuentra al final de la lista!
		//Iniciamos de nuevo el iterador
		it_cap = capitales.listIterator(); //vuelve a la posicion inicial
		
		while(it_cap.hasNext()) { //mientras haya un elemento siguiente del iterador
			
			it_cap.next(); //paso a la siguiente posicion
			
			if(it_cap.hasNext()){ //hay otra posicion?
				
				it_cap.next(); //paso al siguiente
				
				it_cap.remove();//elimina esa posicion
			}
		}
				
		System.out.println(capitales);//[Madrid, DF]
				
		//Ahora vamos eliminar las capitales ojo que ahora la lista esta modificada
		//removeAll elimina colecciones
		paises.removeAll(capitales);
		System.out.println(paises);
		
	}

}
