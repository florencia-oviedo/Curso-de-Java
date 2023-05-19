
package logica;

import java.util.ArrayList;
import java.util.List;


public class TestPlanta {
    public static void main(String[] args) {
        
        Arbol arbol = new Arbol();
        Flor flor = new Flor();
        Arbusto arbusto = new Arbusto();
        
        //llamar a los metodos 3 desde cada objeto forma 1
        arbol.saludar();
        flor.saludar();
        arbusto.saludar();
        //Otra opcion con arraylist
        System.out.println("-------------Otra opcion----------");
        List<Planta> listaPlantas = new ArrayList<Planta>();
        listaPlantas.add(arbol);
        listaPlantas.add(flor);
        listaPlantas.add(arbusto);
        for (Planta p : listaPlantas) {
            p.saludar();
        }
        
        
        
        
        
    }
}
