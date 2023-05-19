
package com.mycompany.jpapruebas;

import com.mycompany.jpapruebas.logica.Alumno;
import com.mycompany.jpapruebas.logica.Carrera;
import com.mycompany.jpapruebas.logica.ControladoraLogica;
import java.util.Date;
//import com.mycompany.jpapruebas.persistencia.ControladoraPersistencia;


public class JPAPrueba {
    public static void main(String[] args) {
        
        //ControladoraPersistencia controlPersis = new ControladoraPersistencia(); creamos una entidad/tabla
        
        //creamos un nuevo registro
        //ControladoraLogica control = new ControladoraLogica();
        //Alumno alu = new Alumno(30,"Luisina","DePaula", new Date());
        //control.crearAlumno(alu); 
        
        //como eliminar un registro:
        //ControladoraLogica control = new ControladoraLogica();
        //control.eliminarAlumno(30);
        
        //Creamos un alumno
        //ControladoraLogica control = new ControladoraLogica();
        //Alumno alu1 = new Alumno(23,"Sakura","CardCaptor", new Date());
        //control.crearAlumno(alu1);//creamos un alumno
        
        //alu.setApellido("De Paula");//cambie el mismo objeto
        //control.editarAlumno(alu);//enviar a la logica para q se lo mande a la persistencia y lo modifique desde la bbdd
        
        
        //Listar 
        //ControladoraLogica control = new ControladoraLogica();
//        System.out.println("-----BUSQUEDA INDIVIDUAL------");
//        Alumno alu = control.traerAlumno(15);
//        System.out.println("El alumno es: "+ alu.toString());
//        
//        System.out.println("-----BUSQUEDA DE TODOS LOS REGISTROS------");
//        ArrayList<Alumno>listaAlumnos = control.traerListaAlumnos();
//        
//        for(Alumno al : listaAlumnos){
//            System.out.println("El alumno es: "+ al.toString());
//        }
//        System.out.println("-----------------------------");
        
        
        ControladoraLogica control = new ControladoraLogica();
        //Creamos una tabla Carrera
        Carrera carrera = new Carrera(25,"Tecnicatura en Programación");
        //Creamos un registro carrera en la BBDD
        control.crearCarrera(carrera);
        //Creacion de alumno con carrera
        Alumno alu = new Alumno(31,"Adolfo","Covarrubias", new Date(),carrera);
        //Guardamos el alumno en BBDD
        control.crearAlumno(alu);
        //vemos el resultado
        System.out.println("-----------------------------");
        System.out.println("----DATOS ALUMNOS---");
        Alumno alu1 = control.traerAlumno(31);
        System.out.println("El alumno es: "+ alu1.getNombre()+" "+alu1.getApellido());
        System.out.println("Cursa la carrera de :"+alu1.getCarrera().getNombre());
        
    }
}

