package sockets1;
import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.*;

public class Servidor {
	//Servidor va a hacer dos tareas por un lado va a tener que recibir texto y por otro lado en segundo plano realizar otra tarea
	//Esa tarea es permanecer a la escucha constantemente y tener el puerto 9999 abierto
	//Utilizando hilos threads para hacer esto

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoServidor mimarco=new MarcoServidor();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
class MarcoServidor extends JFrame implements Runnable {
	
	private	JTextArea areatexto;
	
	public MarcoServidor(){
		
		setBounds(1200,300,280,350);				
			
		JPanel milamina= new JPanel();
		
		milamina.setLayout(new BorderLayout());
		
		areatexto=new JTextArea();
		
		milamina.add(areatexto,BorderLayout.CENTER);
		
		add(milamina);
		
		setVisible(true);
		
		Thread mihilo = new Thread(this); //creamos el hilo luego del metodo run asi esta a la escucha
		mihilo.start(); //va en el constructor ya que apenas instanciamos esta a la escucha
		
		}
	
	

	@Override
	public void run() {
		//System.out.println("Estoy en la escucha");
		try {
			ServerSocket servidor = new ServerSocket(9999); //instanciamos un objeto de servidor socket para la escucha
			String nick,ip,mensaje;
			ArrayList <String> listaIp =new ArrayList<String>();
			//creamos la instancia de PaqueteEnvio
			PaqueteEnvio paquete_recibido = new PaqueteEnvio();
			
			
			
			while(true) {
				//que acepte cualquier conexion q venga del exterior
				Socket misocket = servidor.accept();
				
				//Creo el flujo de entrada de objeto
				ObjectInputStream paquete_datos = new ObjectInputStream(misocket.getInputStream());
				paquete_recibido =  (PaqueteEnvio) paquete_datos.readObject();
				nick = paquete_recibido.getNick();
				ip = paquete_recibido.getIp();
				mensaje = paquete_recibido.getMensaje();
				
				//crear flujo de entrada clase 3
				//DataInputStream flujo_entrada  = new DataInputStream(misocket.getInputStream());
				//lo leemos ese flujo
				//String mensaje_texto = flujo_entrada.readUTF();
				//areatexto.append(" \n "+mensaje_texto); //escribimos en el area de texto
				if(!mensaje.equals("Online")) {
				
				areatexto.append("\n"+ nick + ": "+ mensaje + " para "+ ip);
				//creamos otro socket para que vaya al cliente 2
				Socket envia_destinatario = new Socket(ip,9090);
				ObjectOutputStream paquete_reenvio = new ObjectOutputStream(envia_destinatario.getOutputStream());
				//tenemos que meter la info a enviar dentro de este paquete reenvio
				paquete_reenvio.writeObject(paquete_recibido);
				
				paquete_reenvio.close();
				envia_destinatario.close();
				misocket.close();//cerramos la conexion
				}else {
					//-----------------DETECTA ONLINE-----------------//
					InetAddress localizacion = misocket.getInetAddress(); //me da la ip 
					String ip_remota = localizacion.getHostAddress(); //me da la ip en string
					System.out.println("Online: "+ip_remota);
					listaIp.add(ip_remota);// se van agregando las ip en la lista
					paquete_recibido.setIps(listaIp);//metimos dentro un paquete el arrayList
					
					for(String e: listaIp) {
						System.out.println("Array: "+ e); //Para ver si funciona ok la lista
						Socket envia_destinatario = new Socket(e,9090);
						ObjectOutputStream paquete_reenvio = new ObjectOutputStream(envia_destinatario.getOutputStream());
						//tenemos que meter la info a enviar dentro de este paquete reenvio
						paquete_reenvio.writeObject(paquete_recibido);
						
						paquete_reenvio.close();
						envia_destinatario.close();
						misocket.close();//cerramos la conexion
					}
					//-----------------------------------------------//
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
