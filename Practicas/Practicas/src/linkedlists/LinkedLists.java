
package linkedlists;

import java.util.LinkedList;
import java.util.List;



public class LinkedLists {
    public static void main(String[] args) {
        
        List<Persona> lista = new LinkedList<Persona>();
        
        lista.add(new Persona(1,"Flor",29));
        lista.add(new Persona(2,"Nacho",25));
        lista.add(new Persona(3,"Gise",28));
        lista.add(new Persona(4,"Joha",26));
        //agrego al principio
        lista.add(0,new Persona(5,"FiuFiu",15));
       
        System.out.println("--------FOREACH----------");
        
        //foreach solo se puede porque no tienen un indice determinado
        for(Persona perso: lista){
            System.out.println("Prueba: "+perso.getNombre());
        }
        
    }
}
