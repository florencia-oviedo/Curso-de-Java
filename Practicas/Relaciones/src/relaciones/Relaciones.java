
package relaciones;

import java.util.ArrayList;
import java.util.List;


public class Relaciones {
    public static void main(String[] args) {
        
        Auto auto = new Auto();
        auto.setId(1L);
        auto.setMarca("Renault");
        auto.setModelo("Duster");
        
        List<Propietario> listaprop = new ArrayList<Propietario>();
        
        Propietario prop1 = new Propietario();
        Propietario prop2 = new Propietario();
        
        prop1.setId(29L);
        prop1.setNombre("Florencia");
        prop1.setApellido("Arellano");
        
        prop2.setId(25L);
        prop2.setNombre("Adolfo");
        prop2.setApellido("Cova");
        
        listaprop.add(prop1);
        listaprop.add(prop2);
        
        auto.setListaPropietarios(listaprop);//le asigne la lista de propietarios
        System.out.println("El auto "+auto.getMarca() +" "+ auto.getModelo() + 
                "tiene como propietarios :" + auto.getListaPropietarios().toString());
        
    }
}
