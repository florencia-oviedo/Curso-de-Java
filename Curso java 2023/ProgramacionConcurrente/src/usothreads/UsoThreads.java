package usothreads;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
public class UsoThreads {

	public static void main(String[] args) {
		
		JFrame marco = new MarcoRebote();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);

	}
}
//Clase para multiple hilos
class PelotaHilos implements Runnable{
	
	public PelotaHilos(Pelota pelota, Component componente) {//recibe la lamina
		this.pelota = pelota;
		this.componente = componente;
	}
	private Pelota pelota;//campos de clase
	private Component componente;
	
	@Override
	public void run() { // es llamado cuando ejecutamos start
		System.out.println("Estamos del hilo al comenzar "+ Thread.currentThread().isInterrupted()); 
		//for(int i = 1; i<=3000;i++) {
		//while(!Thread.interrupted()) { //Mientras no ha sido interrumpido el hilo
		//otra manera
		while(!Thread.currentThread().isInterrupted()) {
			pelota.mueve_pelota(componente.getBounds());
			componente.paint(componente.getGraphics());
			try {
				Thread.sleep(4);//Hace una pausa de una ejecucion recibe argumento milisegundos en tipo Long
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				//System.out.println("Hilo bloqueado.Imposible su interrupción");
				//System.exit(0); sale de la aplicacion termina el programa
				Thread.currentThread().interrupt();
			}	
		}
		System.out.println("Estamos del hilo al finalizar "+ Thread.currentThread().isInterrupted()); 
		
	}
	
}
//Movimiento de la pelota
class Pelota{
	//Mueve la pelota inviertiendo posicion si choca con los limites
	public void mueve_pelota(Rectangle2D limites) {
		x +=dx;
		y += dy;
		
		if( x < limites.getMinX()) {
			x = limites.getMinX();
			dx=-dx;
		}
		
		if(x+TAMX >= limites.getMaxX()) {
			x = limites.getMaxX() - TAMX;
			dx= -dx;
		}
		if(y<limites.getMinY()) {
			y = limites.getMinY();
			dy = -dy;
		}
		
		if(y+TAMY >= limites.getMaxY()) {
			y= limites.getMaxY() - TAMY;
			dy =-dy;
		}
	}
	
	//Forma de la pelota en su posicion inicial
	public Ellipse2D getShape() {
		return new Ellipse2D.Double(x,y,TAMX,TAMY);
	}
	private static final int TAMX = 15;
	private static final int TAMY=15;
	private double x=0;
	private double y=0;
	private double dx=1;
	private double dy=1;
	
}

//Lamina que dibuja las pelotas-------------------------------------------------------------------
class LaminaPelota extends JPanel{
	//Añadimos pelota a la lamina
	public void add(Pelota b) {
		pelotas.add(b);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		for(Pelota b: pelotas) {
			g2.fill(b.getShape());	
		}
	}
	private ArrayList<Pelota> pelotas = new ArrayList<Pelota>();
}

//Marco Con laminas y botones
class MarcoRebote extends JFrame{
	
	public MarcoRebote() {
		setBounds(600,300,600,350);
		setTitle("Rebotes");
		lamina = new LaminaPelota();
		add(lamina,BorderLayout.CENTER);
		JPanel laminaBotones = new JPanel();
		//boton 1
		arranca1 = new JButton("Hilo1");
		arranca1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evento) {
				comienza_el_juego(evento);
			}
		});
		laminaBotones.add(arranca1);
		
		//boton2
		arranca2 = new JButton("Hilo2");
		arranca2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evento) {
				comienza_el_juego(evento);
			}
		});
		laminaBotones.add(arranca2);
		//boton3
		arranca3 = new JButton("Hilo3");
		arranca3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evento) {
				comienza_el_juego(evento);
			}
		});
		laminaBotones.add(arranca3);
		//------botones de detener------------------------
		detener1 = new JButton("Detener1");
		detener1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evento) {
				detener(evento);
			}
		});
		laminaBotones.add(detener1);
		//boton detener 2
		detener2 = new JButton("Detener2");
		detener2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evento) {
				detener(evento);
			}
		});
		laminaBotones.add(detener2);
		//boton detener 3
		detener3 = new JButton("Detener3");
		detener3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evento) {
				detener(evento);
			}
		});
		laminaBotones.add(detener3);
		
		add(laminaBotones,BorderLayout.SOUTH);
	}
	
	
	//Añade pelota y la bota 1000 veces
	public void comienza_el_juego(ActionEvent evento) {
		
		Pelota pelota = new Pelota();
		lamina.add(pelota);
		
		Runnable r = new PelotaHilos(pelota,lamina);
		//Thread t = new Thread(r);
		if(evento.getSource().equals(arranca1)) {
			t1= new Thread(r);
			t1.start(); 
		}else if(evento.getSource().equals(arranca2)) {
			t2= new Thread(r);
			t2.start();
		}
		else if(evento.getSource().equals(arranca3)) {
			t3= new Thread(r);
			t3.start();
		}
		//Todo esto permite crear varias pelotas en ejecucion y poder salir cuando quiera
		//metodo start llama automaticamente al metodo run()
	}
	public void detener(ActionEvent evento) { //detiene el hilo en ejecucion
		//t.stop(); //esta obsoleto
		//t.interrupt(); //solicitamos una detencion del hilo, pero no funciona lanza la exception de sleep
		if(evento.getSource().equals(detener1)) {
			t1.interrupt();
		}else if(evento.getSource().equals(detener2)) {
			t2.interrupt();
		}else if(evento.getSource().equals(detener3)) {
			t3.interrupt();
		}
	}
	Thread t1,t2,t3;
	JButton arranca1,arranca2,arranca3,detener1,detener2,detener3;
	private LaminaPelota lamina;
}