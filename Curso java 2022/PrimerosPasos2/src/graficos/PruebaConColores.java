package graficos;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaConColores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoConColor marco = new MarcoConColor();
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
class MarcoConColor extends JFrame{
	
	public MarcoConColor() {
		setTitle("Prueba de colores");
		setSize(400,400);
		LaminaConColor lamina = new LaminaConColor();
		add(lamina);
		//lamina.setBackground(Color.PINK);
		lamina.setBackground(SystemColor.window); //da color de fondo del S.O por default a la lamina
	}
}

class LaminaConColor extends JPanel{
	
	//sobreescribimos el metodo paintComponent
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		Rectangle2D rectangulo = new Rectangle2D.Double(100,100,200,150);
		g2.setPaint(Color.BLUE);
		g2.draw(rectangulo);
		g2.setPaint(Color.RED);
		g2.fill(rectangulo);
		Ellipse2D elipse =  new Ellipse2D.Double();
		elipse.setFrame(rectangulo);
		Color color = new Color(100,150,80);
		g2.setPaint(color);
		g2.fill(elipse);
		
		
	}
}