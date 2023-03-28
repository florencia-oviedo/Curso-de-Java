package clases_propias;

public class Uso_Pareja {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pareja <String> una = new Pareja <String>();
		una.setPrimero("Flor");
		System.out.println(una.getPrimero());
		
		Persona persona1 = new Persona("Ana"); //creamos un objeto Persona
		//Creamos una clase Pareja de tipo Persona
		Pareja <Persona> otra = new Pareja <Persona>();
		otra.setPrimero(persona1); //espera un objeto de tipo Persona
		System.out.println(otra.getPrimero());
		
		

	}

}
class Persona{
	private String nombre;
	
	public Persona(String nombre) {
		this.nombre = nombre;
	}
	public String toString() {
		return nombre;
	}
	
}
