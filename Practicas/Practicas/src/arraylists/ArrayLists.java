
package arraylists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



public class ArrayLists {
    public static void main(String[] args) {
        
        List<Persona> listaArray = new ArrayList<Persona>();
      
        listaArray.add(new Persona(1,"Flor",29));
        listaArray.add(new Persona(2,"Nacho",25));
        listaArray.add(new Persona(3,"Gise",28));
        listaArray.add(new Persona(4,"Joha",26));
        
        LinkedList<Persona> listaLinked= new LinkedList<Persona>();
        listaLinked.add(new Persona(1,"Flor",29));
        listaLinked.add(new Persona(2,"Nacho",25));
        listaLinked.add(new Persona(3,"Gise",28));
        listaLinked.add(new Persona(4,"Tita",26));
        
        //Eliminar un objeto, remove en ArrayList
        listaArray.remove(1); //paso un indice

        //Remove en LinkedList
        String nombreBorrar = "Nacho";//quiero q me elimine esto
        
        for(Persona perso: listaLinked){
            if(perso.getNombre().equals(nombreBorrar)){
                listaLinked.remove(perso);
                break;//se deja de recorrer
            }
        }
        System.out.println("---------Luego de eliminar---------");
        
        System.out.println("---------LINKEDLIST---------");
        for(Persona perso: listaLinked){
            System.out.println(perso.getNombre());
            }
        
        //recorrer por indice
        System.out.println("--------ARRAYLIST----------");
        for (int i = 0; i < listaArray.size(); i++) {
            System.out.println("Prueba: "+ listaArray.get(i).getNombre());
            
        }
        
        //Tamaño lista: cantidad de elementos que tiene
        System.out.println("¿Qué tamaño tienen las listas?");
        System.out.println("ArrayList: = " + listaArray.size());
        System.out.println("LinkedList: = " + listaLinked.size());
        
        //obtener primer objeto
        System.out.println("---Primer y ultimo objeto(solo para LINKEDLIST)---");
        System.out.println("Primero de LinkedList: " + listaLinked.getFirst().toString()); //ponemos el toString para ver el objeto completo, el get First o Last es una direccion en memoria
        System.out.println("Ultimo de LinkedList: " + listaLinked.getLast().toString());
        
        //borrar toda la lista
        System.out.println("-------------Borrando lista------- ");
        listaArray.clear();
        listaLinked.clear();
        
        //Comprobar si esta vacia
        System.out.println("--------Está vacia alguna lista?--------");
        System.out.println("ArrayList : " + listaArray.isEmpty());
        System.out.println("LinkedList : " + listaLinked.isEmpty());
        
    }
}
