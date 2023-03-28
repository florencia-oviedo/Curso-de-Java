package colecciones;

public class Uso_libro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Libro libro1 = new Libro("P en Java","Juan Diaz",25);
		Libro libro2 = new Libro("P en Java2","Juan Diaz",25);
		//El metodo equals no sabe nada del codigo ISBN que no tienen q haber repetidos
		//libro1 = libro2; //Con esto entran al if ya que estan en la misma referencia 
		if(libro1.equals(libro2)) {
			System.out.println("Es el mismo libro");
			System.out.println(libro1.hashCode());
			System.out.println(libro2.hashCode());
		}
		else {
			System.out.println("No es el mismo libro");
			System.out.println(libro1.hashCode());
			System.out.println(libro2.hashCode());
		}
	}

}
