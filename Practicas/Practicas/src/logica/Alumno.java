
package logica;


public class Alumno {
    //atributos
    int id;
    String nombre;
    String apellido;

    public Alumno() {
    }

    public Alumno(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    
    
    
    //método
    //void es para procedimientos hago algo pero no retorna nada
    public void mostrarNombre(){
        System.out.println("Hola soy un alumno y sé decir mi nombre");
    }
    
    public void saberAprobado(double calificacion){
        if(calificacion >=6){
            System.out.println("Aprobé la materia");
        }else{
            System.out.println("uyy no aprobé");
        }
    }
}
