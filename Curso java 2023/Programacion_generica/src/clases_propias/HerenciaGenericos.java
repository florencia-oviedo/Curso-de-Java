package clases_propias;

public class HerenciaGenericos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Empleado administrativa = new Empleado("Elena",45,1500);
		Jefe directoraComercial = new Jefe("Ana",27,3500);
		Empleado nuevoEmpleado = directoraComercial; // Por principio de sustitucion un Jefe siempre es un Empleado*/
		//Puedo almacenar un objeto de tipo jefe a una variable de tipo Empleado
		
		//En clases genericas no funciona el principio de sustitucion
		Pareja<Empleado> administrativa = new Pareja<Empleado>();
		Pareja<Jefe> directoraComercial = new Pareja<Jefe>();
		//Pareja<Empleado> otroEmpleado= directoraComercial;
		
		//creamos un metodo en la clase pareja que me muestre un trabajador de tipo Empleado
		Pareja.imprimirTrabajor(administrativa);
		Pareja.imprimirTrabajor(directoraComercial);
		
	}

}
