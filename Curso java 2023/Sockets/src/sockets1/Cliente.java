package sockets1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.*;
import java.util.ArrayList;

import javax.swing.*;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoCliente mimarco=new MarcoCliente();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
class MarcoCliente extends JFrame{
	
	public MarcoCliente(){
		
		setBounds(600,300,280,350);
				
		LaminaMarcoCliente milamina=new LaminaMarcoCliente();
		
		add(milamina);
		
		setVisible(true);
		addWindowListener(new EnvioOnline());//creamos un objeto
		}	
	
}
//Clase que gestiona el evento de Ventana-----ENVIO DE SEÑAL ONLINE-------------
class EnvioOnline extends WindowAdapter{ //implementa todos los metodos de una interface para elegir un metodo y q no nos obligue a poner todos
	//metodo
	public void windowOpened(WindowEvent e) {
		try {
			
			Socket misocket = new Socket("192.168.1.39",9999);
			//creamos un paquete donde enviaremos un dato o algo q reciba el servidor
			PaqueteEnvio datos = new PaqueteEnvio();
			datos.setMensaje("Online");
			//creamos el flujo de datos donde enviaremos este objeto a traves del socket y q lo reciba el servidor
			ObjectOutputStream paquete_datos = new ObjectOutputStream(misocket.getOutputStream());
			//escribimos en ese flujo de datos el objeto q queremos enviar
			paquete_datos.writeObject(datos);
			misocket.close();
			
		}catch(Exception e1) {
			
		}
	}
	
	
}

class LaminaMarcoCliente extends JPanel implements Runnable{
	
	public LaminaMarcoCliente(){
		String nick_usuario = JOptionPane.showInputDialog("Nick: ");
		JLabel n_nick = new JLabel("Nick:");
		add(n_nick);
		nick = new JLabel();
		nick.setText(nick_usuario);
		add(nick);
	
		JLabel texto=new JLabel("Online: ");
		
		add(texto);
		
		ip = new JComboBox();
		/*ip.addItem("Usuario 1");
		ip.addItem("Usuario 2");
		ip.addItem("Usuario 3");*/
		//ip.addItem("192.168.1.39");
		add(ip);
		
		campochat  = new  JTextArea(12,20);
		add(campochat);
	
		campo1=new JTextField(20);
	
		add(campo1);		
	
		miboton=new JButton("Enviar");
		
		EnviaTexto mievento = new EnviaTexto();
		miboton.addActionListener(mievento);
		
		add(miboton);
		
		Thread mihilo = new Thread(this);
		mihilo.start();
	}
	
	private class EnviaTexto implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//System.out.println(campo1.getText()); muestra lo q escribimos en el campo de texto
			campochat.append("\n"+ "Yo : "+ campo1.getText());
			try {
				Socket misocket = new Socket("192.168.1.39",9999);//Ip y puerto
				PaqueteEnvio datos = new PaqueteEnvio();//empaquetamos los datos
				
				datos.setNick(nick.getText());//obtengo el texto del campo nick y lo almacene en propiedad Nick
				datos.setIp(ip.getSelectedItem().toString()); //obtengo el texto del campo ip y lo almacene en nick
				datos.setMensaje(campo1.getText()); //obtengo el texto del mensaje y lo almaceno en mensaje
				//enviar objetos ahora no texto(por eso no usamos dataoutputstream)
				ObjectOutputStream paquete_datos = new ObjectOutputStream(misocket.getOutputStream());//flujo de salida
				paquete_datos.writeObject(datos);//objeto que queremos enviar
				misocket.close();
				
				/*DataOutputStream flujo_salida = new DataOutputStream(misocket.getOutputStream());//indicarle a este flujo de datos por donde va a circular, por este socket
				//Hemos construido un flujo de salida que va a circular por el socket(puente virtual)
				flujo_salida.writeUTF(campo1.getText()); // en el flujo de datos de salida va a viajer el texto del campo1 , escribe en el flujo lo q hay en el campo1, ese flujo circula por el socket
				//el socket se dirige a tal servido
				flujo_salida.close();*/
				
				
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
			}
			
		}
		
	}
	
	private JTextArea campochat;	
		
	private JTextField campo1;
	private JComboBox ip;
	private JLabel nick;
	
	private JButton miboton;

	@Override
	public void run() {
		try {
			
			ServerSocket servidor_cliente = new ServerSocket(9090);
			Socket cliente;
			PaqueteEnvio paquete_recibido;
			while(true) {
				cliente = servidor_cliente.accept();
				ObjectInputStream flujo_entrada = new ObjectInputStream(cliente.getInputStream());
				paquete_recibido = (PaqueteEnvio) flujo_entrada.readObject();
				
				if(!paquete_recibido.getMensaje().equals("Online")) {
					campochat.append("\n"+paquete_recibido.getNick()+" : "+paquete_recibido.getMensaje());
				}else {
					//campochat.append("\n"+paquete_recibido.getIps());
					ArrayList<String> ipsMenu = new ArrayList<String>();
					ipsMenu = paquete_recibido.getIps();
					
					ip.removeAllItems();
					
					for(String e :ipsMenu) {
						ip.addItem(e);
					}
				}
				
				
				
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}

class PaqueteEnvio implements Serializable{
	private String mensaje,nick,ip;
	private ArrayList<String> ips;
	
	public ArrayList<String> getIps() {
		return ips;
	}

	public void setIps(ArrayList<String> ips) {
		this.ips = ips;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}