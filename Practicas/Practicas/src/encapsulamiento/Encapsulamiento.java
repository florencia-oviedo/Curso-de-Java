
package encapsulamiento;


public class Encapsulamiento {
    public static void main(String[] args) {
        Alumno alumno = new Alumno();
        Alumno alu  =new Alumno(2,"Flor","Ov");
        System.out.println("id: " + alu.getId() );
        System.out.println("Nombre: " + alu.getNombre());
        System.out.println("Apellido: " + alu.getApellido());
        
    }
}
