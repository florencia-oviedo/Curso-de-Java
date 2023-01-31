package graficos;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class PruebaDibujo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoConDibujo marco = new MarcoConDibujo();
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}

}

class MarcoConDibujo extends JFrame{
	
	public MarcoConDibujo() {
		setTitle("Prueba de dibujo");
		setSize(400,400);
		LaminaConFiguras lamina = new LaminaConFiguras();
		add(lamina);
	}
}

class LaminaConFiguras extends JPanel{
	
	//sobreescribimos el metodo paintComponent
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//g.drawRect(50, 50, 200, 200); Dibuja un rectangulo
		//g.drawLine(100, 100, 300, 200); Dibuja una linea
		//g.drawArc(100, 100, 100, 200, 120, 150);
		Graphics2D g2 = (Graphics2D) g;
		Rectangle2D rectangulo = new Rectangle2D.Double(100,100,200,150);
		g2.draw(rectangulo);
		Ellipse2D elipse =  new Ellipse2D.Double();
		elipse.setFrame(rectangulo);
		g2.draw(elipse);
		g2.draw(new Line2D.Double(100, 100, 300, 250));
		double centroX = rectangulo.getCenterX();
		double centroY = rectangulo.getCenterY();
		double radio = 150;
		Ellipse2D circulo =  new Ellipse2D.Double();
		circulo.setFrameFromCenter(centroX,centroY,centroX+radio,centroY+radio);
		g2.draw(circulo);
		
	}
}