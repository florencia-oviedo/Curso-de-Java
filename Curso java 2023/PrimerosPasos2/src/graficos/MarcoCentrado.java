package graficos;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;

public class MarcoCentrado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoCentrado2 mimarco = new MarcoCentrado2();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

}

class MarcoCentrado2 extends JFrame{
	
	public MarcoCentrado2() {
		Toolkit mipantalla = Toolkit.getDefaultToolkit();
		Dimension tamanioPantalla = mipantalla.getScreenSize();
		int alturaPantalla = tamanioPantalla.height;
		int anchoPantalla = tamanioPantalla.width;
		setSize(anchoPantalla/2,alturaPantalla/2);
		setLocation(anchoPantalla/4,alturaPantalla/4);
		setTitle("MarcoCentrado");
		Image miIcono  =  mipantalla.getImage("src/graficos/iconomio.jpg");
		setIconImage(miIcono);
	}
}
