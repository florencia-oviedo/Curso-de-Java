package principal;

import javax.swing.JFrame;

import vista.MarcoAplicacion2;

public class EjecutaModeloVistaControlador {

	public static void main(String[] args) {
		
		MarcoAplicacion2 marco  = new MarcoAplicacion2();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}
