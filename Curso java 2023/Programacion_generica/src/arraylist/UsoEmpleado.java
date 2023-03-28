package arraylist;
import java.util.*;
public class UsoEmpleado {

	public static void main(String[] args) {
		
		// Array normal
		
		/*Empleado listaEmpleados[]= new Empleado[3];
		
		listaEmpleados[0] = new Empleado("Ana",45,2500);
		listaEmpleados[1] = new Empleado("Antonio",55,2000);
		listaEmpleados[2] = new Empleado("Maria",25,2600);*/
		
		//ArrayList
		ArrayList <Empleado> listaEmpleados = new ArrayList <Empleado> ();
		// Aclarar la capacidad que va a tener
		//listaEmpleados.ensureCapacity(11);
		//Usamos el metodo add para añadir objetos 
		listaEmpleados.add(new Empleado("Ana",45,2500));//Tambien pueden crear una variable instanciando el objeto
		listaEmpleados.add(new Empleado("Antonio",55,2000));
		listaEmpleados.add(new Empleado("Maria",25,2600));
		listaEmpleados.add(new Empleado("Florencia",29,2800));
		listaEmpleados.add(new Empleado("Maria",25,2600));
		listaEmpleados.add(new Empleado("Ana",45,2500));//Tambien pueden crear una variable instanciando el objeto
		listaEmpleados.add(new Empleado("Antonio",55,2000));
		listaEmpleados.add(new Empleado("Maria",25,2600));
		listaEmpleados.add(new Empleado("Florencia",29,2800));
		
		//Para agregar un objeto en una posicion determinada eliminando el objeto que estaba ocupando esa posicion!!! y reemplazando por el nuevo
		listaEmpleados.set(1,new Empleado("Olga",52,2200));
		
		//Si no quieres reemplazar el anterior objeto , usamos add(posicion, elemento)
		//listaEmpleados.add(1,new Empleado("Olga",52,2800)); //corre el array a la derecha
		
		//Corta el exceso de memoria
		//listaEmpleados.trimToSize();
		// Ver cuantos elementos tiene el arrayList
		//System.out.println(listaEmpleados.size());
		
		//Para acceder a un objeto en particular desde su posicion
		//System.out.println(listaEmpleados.get(4).dameDatos());
		
		/*for(Empleado e: listaEmpleados) {
			System.out.println(e.dameDatos());
		}*/
		
		// guardamos el objeto iterator en una variable de Iterator
		Iterator <Empleado> mi_iterador = listaEmpleados.iterator();
		//hasnext() nos dice si tenemos mas objetos o no dentro de la coleccion
		while(mi_iterador.hasNext()) { //mientras sea true
			System.out.println(mi_iterador.next().dameDatos());
		}
		
		
		
		//Forma de recorrer con for normal
		/*for(int i=0;i<listaEmpleados.size();i++) {
			System.out.println(listaEmpleados.get(i).dameDatos());
		}*/
		//Forma de recorrer con for normal version 2
		/*for(int i=0;i<listaEmpleados.size();i++) {
			Empleado e = listaEmpleados.get(i);
			System.out.println(e.dameDatos());
		}*/
		
		//Como pasar de una arrayList a un array normal
		//Creamos un array de tipo Empleado y el tamaño va a ser el mismo q el del arrayList lo hacemos con el metodo size()
		
		/*Empleado arrayEmpleados[] = new Empleado[listaEmpleados.size()];
		//Copiamos con el metodo to array la listaEmpleados en el array creado
		listaEmpleados.toArray(arrayEmpleados);
		//usamos for normal
		for(int i=0;i<arrayEmpleados.length;i++) {
			System.out.println(arrayEmpleados[i].dameDatos());
		}*/
		
		
	}

}
class Empleado{
	
	private String nombre;
	private int edad;
	private double salario;
	
	public Empleado(String nombre, int edad,double salario) {
		this.nombre = nombre;
		this.edad = edad;
		this.salario = salario;
	}
	
	public String dameDatos() {
		return "El empleado se llama "+nombre+". Tiene "+edad+" años. Y un salario de "+salario;
	}
}
