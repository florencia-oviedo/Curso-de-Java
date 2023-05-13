package modelo;
import java.sql.*;

public class Conexion {
	
	private Connection miConexion = null;
	public Conexion() {
		
	}
	
	public Connection dameConexion() {
		try {
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "1234");
		}catch(Exception e) {
			
		}
		
		return miConexion;
	}
}
