import javax.swing.*;
public class entrada_ejemplo2 {

	public static void main(String[] args) {
		String nombre = JOptionPane.showInputDialog("Digite su nombre: ");
		
		String edad = JOptionPane.showInputDialog("Digite su edad: ");
		int edad1 = Integer.parseInt(edad);
		System.out.println("Hola "+nombre+" el año que viene tendrás "+ (edad1+1) + " años.");
		

	}

}
