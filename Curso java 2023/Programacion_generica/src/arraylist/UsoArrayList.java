package arraylist;
import java.io.*;

public class UsoArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList2 archivos = new ArrayList2(5);
		archivos.add("Juan");
		archivos.add("Flor");
		archivos.add("Maria");
		archivos.add("Olga");
		archivos.add(new File("gestion")); //dara error en tiempos de ejecucion ya que no puede convertir un objeto File en String falta casting
		String nombrePersona = (String) archivos.get(4);
		//Probamos con otro tipo de objeto
		//archivos.add(new File("ejemplo"));
		//File nombrePersona = (File) archivos.get(0);
		System.out.println(nombrePersona);
		
		
		
	}

}
