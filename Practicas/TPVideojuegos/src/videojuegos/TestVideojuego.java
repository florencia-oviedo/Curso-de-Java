
package videojuegos;

import java.util.ArrayList;

/*
- Crear una ArrayList de tipo VideoJuego. Crear 5 videojegos y guardarlos en la collection.
- Recorrer la ArrayList creada y mostrar por pantalla el titulo, consola y cantidad de jugadores de los videojuegos 
almacenados.
- Cambiar el nombre y la cantidad de jugadores de dos videojuegos. Mostrar por pantalla los datos de todos 
los videojuegos luego del cambio.
- Recorrer la ArrayList y mostrar por pantalla únicamente a los videojuegos que sean de la consola "Nintendo 64"
*/
public class TestVideojuego {
    public static void main(String[] args) {
        
        ArrayList<Videojuego> videojuegos = new ArrayList<Videojuego>();
        Videojuego videojuego1 = new Videojuego(1,"Pokemon","Nintendo64",1,"RPG");
        Videojuego videojuego2 = new Videojuego(2,"Mortal Kombat","PlayStation",2,"Fighter");
        Videojuego videojuego3 = new Videojuego(3,"League of legends","PC",5,"MOBA");
        Videojuego videojuego4 = new Videojuego(4,"Fortnite","XBOX",4,"MOBA");
        Videojuego videojuego5 = new Videojuego(5,"MarioKart","Nintendo64",4,"Carreras");
        
        videojuegos.add(videojuego1);
        videojuegos.add(videojuego2);
        videojuegos.add(videojuego3);
        videojuegos.add(videojuego4);
        videojuegos.add(videojuego5);
        
        
        System.out.println("-------Mostramos los juegos-------");
        for(Videojuego vd : videojuegos){
            System.out.println("El título del juego: " + vd.getTitulo() + ", Consola: "+ vd.getConsola() + 
                    ", Cantidad de jugadores: "+ vd.getCantidadJugadores());
        }
        
        videojuego1.setTitulo("Pokemon Rojo");
        videojuego1.setCantidadJugadores(2);
        videojuego5.setTitulo("MarioKart 3");
        videojuego5.setCantidadJugadores(6);
        
        System.out.println("-------Mostramos los juegos despues del cambio-------");
        for(Videojuego vd : videojuegos){
            System.out.println("El título del juego: " + vd.getTitulo() + ", Consola: "+ vd.getConsola() + 
                    ", Cantidad de jugadores: "+ vd.getCantidadJugadores());
        }
        
        System.out.println("-------Mostramos los juegos que sean de Nintendo64-------");
        for(Videojuego vd : videojuegos){
            if(vd.getConsola().equals("Nintendo64")){
                System.out.println(vd.toString());
            }
        }
        
        
        
        
        
    }
}
