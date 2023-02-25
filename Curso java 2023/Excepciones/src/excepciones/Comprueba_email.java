package excepciones;

import java.io.EOFException;

import javax.swing.JOptionPane;

public class Comprueba_email {

	public static void main(String[] args) {
		
		String email = JOptionPane.showInputDialog("Digite el email: ");
		try {
			examina_mail(email);
		}catch(LongitudEmailErronea e) {
			System.out.println("El email es corto");
			e.printStackTrace();
		}
		

	}
	
	static void examina_mail(String email) throws LongitudEmailErronea {
		int arroba= 0;
		boolean punto = false;
		if(email.length()<=3) {
			//ArrayIndexOutOfBoundsException excepcion = new ArrayIndexOutOfBoundsException();
			//throw new EOFException(); //simplificado
			throw new LongitudEmailErronea("El email no puede tener menos de 3 caracteres");
		}
		else {
		
		for(int i=0;i<email.length();i++) {
			
			if (email.charAt(i)=='@') {
				arroba++;
			}
			
			if (email.charAt(i)=='.') {
				punto = true;
			}
		}
		if(arroba==1 && punto==true) {
			System.out.println("Es correcto el email");
		}
		else {
			System.out.println("No es correcto el email");
		}
	  }
	}

}
class LongitudEmailErronea extends Exception{
	//Es lo recomendable tener 2 constructores ,uno vacio y otro con parametro de tipo String
	public LongitudEmailErronea() {
		
	}
	public LongitudEmailErronea(String msj_error) {
		super(msj_error);
	}
}
