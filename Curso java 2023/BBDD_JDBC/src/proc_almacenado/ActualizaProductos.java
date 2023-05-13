package proc_almacenado;
import java.sql.*;

import javax.swing.JOptionPane;

public class ActualizaProductos {

	public static void main(String[] args) {
		
		//-----------PROCEDIMIENTOS ALMACENADOS CON PARAMETROS TEMA DE JDBC-------------------------
		
		double nPrecio = Integer.parseInt(JOptionPane.showInputDialog("Introduce el precio"));
		String nArt  = JOptionPane.showInputDialog("Introduce nombre del artículo");
		
		try {
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "1234");
			
			CallableStatement miSentencia = miConexion.prepareCall("{CALL ACTUALIZA_PROD(?,?)}");//asi es con parametros
			
			miSentencia.setDouble(1, nPrecio); //En el primer parametro pide el precio 
			
			miSentencia.setString(2, nArt); //Segundo parametro pide el nombre articulo
			
			miSentencia.execute();
			
			System.out.println("Actualizado correctamente");
			
		}catch(Exception e) {
			
		}
	}

}
