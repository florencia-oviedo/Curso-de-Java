
package pilas;

import java.util.Stack;


public class Pilas {
    public static void main(String[] args) {
        Stack<Integer> pila = new Stack<Integer>();
        System.out.println("pila vacía = " + pila);
        System.out.println("Está vacía? = " + pila.isEmpty());
        
        //agregar
        pila.push(1);
        pila.push(2);
        pila.push(3);
        pila.push(4);
        pila.push(5);
        
        //Recorrido
        for(Integer pilita : pila){
            System.out.println(pilita);
        }
        
        //mostrar
        System.out.println("pila :" + pila);
        System.out.println("Está vacía? = " + pila.isEmpty());
        
        pila.pop();//eliminar el ultimo registro que entro
        System.out.println("Está el 3? = " + pila.search(3));
        System.out.println("Ultimo agregado = " + pila.peek());
        
        
    }
}
