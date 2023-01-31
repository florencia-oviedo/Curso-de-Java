package graficos;
import javax.swing.*;
import java.awt.*;

public class EscribiendoMarco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoConTexto mimarco = new MarcoConTexto(); //Instanciamos 
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cuando cierra la ventana termina el programa
	}

}
//Creamos la clase para hacer el Marco
class MarcoConTexto extends JFrame{
	
	public MarcoConTexto() {
		
		setSize(600,450); //damos tamaño al marco
		setLocation(400,200); //damos la ubicacion del marco
		setTitle("Mi primer texto"); //damos el titulo
		//agregamos la lamina
		Lamina milamina= new Lamina();
		add(milamina);
		setVisible(true); //dar visibilidad al marco SIEMPRE VA AL FINAL PARA DAR MAS VISIBILIDAD
	}
}
//Creamos la nueva clase para crear la lamina o panel para poder escribir texto
class Lamina extends JPanel{
	
	//Sobreescribimos el metodo painComponent para poner lo que queremos
	public void paintComponent(Graphics g) {
		//llamamos al metodo de la clase Padre paint Component para q tengamos lo default mas lo q queremos
		super.paintComponent(g);
		//metodo de la clase graphics
		g.drawString("Estamos aprendiendo Swing", 100, 100);
	}
}