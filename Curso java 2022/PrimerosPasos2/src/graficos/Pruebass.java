package graficos;

import java.awt.GraphicsEnvironment;

import javax.swing.JOptionPane;

public class Pruebass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fuente = JOptionPane.showInputDialog("Introduce la fuente");
		boolean estalafuente = false;
		String nombreDeFuentes [] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		for(String nombrefuente : nombreDeFuentes) {
			if(nombrefuente.equals(fuente)) {
				estalafuente = true;
			}
			
		}
		
		if(estalafuente) {
			System.out.println("Esta instalada la fuente");
		}
		else {
			System.out.println("No esta instalada la fuente");
		}
		
		
		
		
	}

}
