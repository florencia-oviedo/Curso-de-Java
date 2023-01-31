package graficos;

import javax.swing.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.*;

public class PruebaConImagenes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoConImagen marco = new MarcoConImagen();
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
class MarcoConImagen extends JFrame{
	
	public MarcoConImagen() {
		setTitle("Prueba de imagen");
		setBounds(750,300,300,200); 
		LaminaConImagen lamina = new LaminaConImagen();
		add(lamina);
		
	}
}

class LaminaConImagen extends JPanel{
	//Constructor
	public LaminaConImagen() {
		
		try {
			imagen = ImageIO.read(new File("src/graficos/candado.png"));
		}
		catch(IOException e) {
			System.out.println("La imagen no se encuentra");
		}
		
	}
		
	//sobreescribimos el metodo paintComponent
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		//Para saber el tamaño de una imagen capturada 
		int anchoImagen = imagen.getWidth(this);
		int altoImagen = imagen.getHeight(this);
		
		g.drawImage(imagen, 0, 0, null);
		
		//Copiar una imagen y hacer modo mosaico
		for(int i = 0; i<300;i++) {
			for(int j=0;j<200;j++) {
				
				if(i+j>0) {
	
					g.copyArea(0, 0, anchoImagen, altoImagen,anchoImagen*i,altoImagen*j);
				}
				
				
			}
		}
		
	
		
	}
	private Image imagen;
}