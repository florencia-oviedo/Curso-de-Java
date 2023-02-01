import javax.swing.*;
public class Bucles_ejemplo1 {

	public static void main(String[] args) {
		
		String clave = "Florencia";
		
		String pass = "";
		
		
		while (clave.equals(pass) == false) {
			
			pass = JOptionPane.showInputDialog("Digite la contraseña: ");
			
			if(clave.equals(pass) == false) {
				System.out.println("La contraseña es incorrecta");
			}
		}
		System.out.println("Contraseña correcta, acceso permitido");
		
	}

}
