
package com.mycompany.jpapruebas.logica;

import com.mycompany.jpapruebas.persistencia.ControladoraPersistencia;
import java.util.ArrayList;


public class ControladoraLogica {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public void crearAlumno(Alumno alumno){
        controlPersis.crearAlumno(alumno);
    }
    
    public void eliminarAlumno(int id){
        controlPersis.eliminarAlumno(id);
    }
    
    public void editarAlumno(Alumno alu){
        controlPersis.editarAlumno(alu);
    }
    
    public Alumno traerAlumno(int id){
        return controlPersis.traerAlumno(id);
    }
    
    public ArrayList<Alumno> traerListaAlumnos(){
        return controlPersis.traerListaAlumnos();
    }
    
    //Carrera
     public void crearCarrera(Carrera carrera){
        controlPersis.crearCarrera(carrera);
    }
    
    public void eliminarCarrea(int id){
        controlPersis.eliminarCarrera(id);
    }
    
    public void editarCarrera(Carrera carrera){
        controlPersis.editarCarrera(carrera);
    }
    
    public Carrera traerCarrera(int id){
        return controlPersis.traerCarrera(id);
    }
    
    public ArrayList<Carrera> traerListaCarreras(){
        return controlPersis.traerListaCarreras();
    }
}
