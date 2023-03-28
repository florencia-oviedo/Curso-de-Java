package colecciones;
import java.util.*;
public class PruebaTreeSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*TreeSet<String> ordena_personas= new TreeSet<String>();
		ordena_personas.add("Sandra");
		ordena_personas.add("Amanda");
		ordena_personas.add("Diana");
		
		//recorremos
		for(String persona : ordena_personas) {
			System.out.println(persona);
		}*/
		//Ordena por defecto por orden Alfabetico
		
		Articulo primero = new Articulo(1,"primer articulo");
		Articulo segundo = new Articulo(20,"segundo articulo");
		Articulo tercero = new Articulo(3,"Este es el tercer articulo");
		
		TreeSet <Articulo> articulos = new TreeSet<Articulo>();
		articulos.add(tercero);
		articulos.add(segundo);
		articulos.add(primero);
		
		for(Articulo a:articulos) {
			System.out.println(a.getDescripcion());
		}
		
		//Articulo comparador_art = new Articulo();
		//TreeSet <Articulo> ordena_articulos2 = new TreeSet<Articulo>(comparador_art);
		//En este TreeSet los objetos se van a almacenar ordenador segun lo marque el comparador_Art por orden alfabetico
		
		//ComparadorArt compara_art = new ComparadorArt();//usamos la clase para crear un objeto comparador y no obligamos que la clase Articulo implemente Comparator
		TreeSet <Articulo> ordena_articulos2 = new TreeSet<Articulo>(new Comparator<Articulo>() { //clase interna anonima

			@Override
			public int compare(Articulo o1, Articulo o2) {
				String desc1 = o1.getDescripcion();
				String desc2 = o2.getDescripcion();
				return desc1.compareTo(desc2);
			}
			
		});
		ordena_articulos2.add(primero);
		ordena_articulos2.add(segundo);
		ordena_articulos2.add(tercero);
		
		for(Articulo art : ordena_articulos2) {
			System.out.println(art.getDescripcion());
		}
		//Ordena alfabeticamente utilizando un comparator
		
		
		
		
		
		
	}
}
//Creamos una clase para q implemente la interfaz comparable
class Articulo implements Comparable<Articulo>{
	
	//campos de clase
	private int num_articulo;
	private String descripcion;
	
	//constructor
	public Articulo(int num,String desc) {
		num_articulo = num;
		descripcion = desc;
	}
	
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	@Override
	public int compareTo(Articulo o) {
		
		return num_articulo - o.num_articulo; //ordena por el numero de articulo
	}

}

class ComparadorArt implements Comparator<Articulo>{

	@Override
	public int compare(Articulo o1, Articulo o2) {
		String desc1 = o1.getDescripcion();
		String desc2 = o2.getDescripcion();
		return desc1.compareTo(desc2);
	}
	
}