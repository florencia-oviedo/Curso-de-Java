package clases_propias;

public class MetodosGenericos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[]nombres = {"Jose","Maria","Pepe"};
		System.out.println(MisMatrices.getMenor(nombres));
		/*String elementos = MisMatrices.getElementos(nombres);
		System.out.println(elementos);*/
		/*Empleado listaEmpleados [] = { new Empleado("Ana",45,2500),new Empleado("Ana",45,2500)};*/
		//System.out.println(MisMatrices.getElementos(listaEmpleados));
	}

}
class MisMatrices{
	
	//Metodo generico
	
	public static <T> String getElementos(T[]a) { //argumento generico y devuelve String
		return "El array tiene "+ a.length + " elementos";
	}
	
	public static <T extends Comparable> T getMenor(T[]a) { //argumento generico y devuelve generico, Si paso String devuelve String.
		
		if(a == null || a.length == 0) {
			return null;
		}
		
		//variable generica
		T elementoMenor = a[0];
		
		for(int i=1;i<a.length;i++) { //empieza en 1 porq en 0 ya lo guardamos
			
			if(elementoMenor.compareTo(a[i])>0) {
				elementoMenor = a[i];
			}
		}
		return elementoMenor;
	}
}
