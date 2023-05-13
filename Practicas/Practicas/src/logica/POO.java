
package logica;


public class POO {
    public static void main(String[] args) {
        
        Alumno alu1 = new Alumno();
        Alumno alu2 = new Alumno(5,"Florencia","Oviedo");
        
        System.out.println("La id del alumno 2 es: " + alu2.getId());
        System.out.println("El nombre del alumno 2 es: " + alu2.getNombre());
        System.out.println("El apellido del alumno 2 es: " + alu2.getApellido());
        
        System.out.println("---------------------");
        //seteamos los valores del alu1
        alu1.setId(8);
        alu1.setNombre("Nacho");
        alu1.setApellido("Arellano");
        
        System.out.println("La id del alumno 1 es: " + alu1.getId());
        System.out.println("El nombre del alumno 1 es: " + alu1.getNombre());
        System.out.println("El apellido del alumno 1 es: " + alu1.getApellido());
        System.out.println("---------------------");
        alu2.setId(35);//sobreescribe el valor anterior de alu2
        System.out.println("La id del alumno 2 es: " + alu2.getId());
        
    }
}
