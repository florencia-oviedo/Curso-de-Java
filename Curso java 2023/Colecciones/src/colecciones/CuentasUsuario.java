package colecciones;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CuentasUsuario {

	public static void main(String[] args) {
		// Creamos los objetos clientes
		Cliente cliente1 = new Cliente("Antonio Banderas","00001",200000);
		Cliente cliente2 = new Cliente("Florencia Oviedo","00002",150000);
		Cliente cliente3 = new Cliente("Rafael Nadal","00003",500000);
		Cliente cliente4 = new Cliente("Julio Iglesias","00004",600000);
		Cliente cliente5 = new Cliente("Julio Iglesias","00004",600000);
		
		//Creamos la coleccion
		//Ver cual es la coleccion mas adecuada, si se pueden repetir datos, si vamos a agregar o eliminar mucho, o es de solo lectura
		//Set no permite datos repetidos, uso sencillo de add(), la desventaja que cuesta ordenarlos pero en este caso no es imprescindibles.
		//Set es una interface tenemos que usar una clase que la implemente
		Set <Cliente> clientesBanco  = new HashSet <Cliente>();
		
		//Agregamos clientes
		clientesBanco.add(cliente1);
		clientesBanco.add(cliente2);
		clientesBanco.add(cliente3);
		clientesBanco.add(cliente4);
		clientesBanco.add(cliente5);//Se imprime igual el mismo valor que tiene de cliente 4 y eso que no admitia Set duplicados y ademas lo gestionaba el add()
		
		//Recorremos esta coleccion
		//este for para eliminar un cliente especifico
		/*for(Cliente cliente : clientesBanco) {
			//System.out.println(cliente.getNombre()+" "+cliente.getN_cuenta()+" "+ cliente.getSaldo());
			if(cliente.getNombre().equals("Julio Iglesias")) {
				clientesBanco.remove(cliente);
			}
		}*/
		
		//Eliminamos un objeto en particular
		Iterator<Cliente> it = clientesBanco.iterator();
		
		while(it.hasNext()) {
			String nombre_cliente = it.next().getNombre();
			if(nombre_cliente.equals("Julio Iglesias")){
				it.remove();
			}
				
		}
		
		//este for recorre solamente
		for(Cliente cliente : clientesBanco) {
			System.out.println(cliente.getNombre()+" "+cliente.getN_cuenta()+" "+ cliente.getSaldo());
		}
		//Ejecutamos y no aparecen ordenados!
		
		//Lo haremos con iterador para recorrer
		/*Iterator<Cliente> it = clientesBanco.iterator();
		
		while(it.hasNext()) {
			String nombre_cliente = it.next().getNombre(); //Para almacenar en la variable el nombre del 1er cliente primero tenemos que saltar
														//Por eso usamos next y una vez q lo hicimos despues obtenemos el nombre.
			System.out.println(nombre_cliente);
			//String n_cuenta = it.next().getN_cuenta(); No sirve ya que va a saltar de nuevo 
		}*/
		
		
	}

}
