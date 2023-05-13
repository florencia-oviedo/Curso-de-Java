
package herencia;


public class Herencia {
    public static void main(String[] args) {
        
        //Polimorfismo nos permite los mix de datos
        Persona vector[] = new Persona[5];
        vector[0] = new Persona();
        vector[1] = new Empleado();
        vector[2] = new Consultor();
        vector[3] = new Jefe();
       //El polimorfimo me permite poder guardar en un array de la clase Padre, objetos de clase hijas.
        Persona persona = new Persona();
        Consultor consultor = new Consultor();
        persona = consultor; //consultor es hija de Persona y puedo asignarle a persona
        
        //consultor = persona;//aca da error , tengo que hacer un casting transformar la clase persona
        
   
        
        
        
    }
}
