package metadatos;

import java.sql.*;

public class Info_Metadatos {

	public static void main(String[] args) {
		// ------------------------------METADATOS JDBC-----------------------------------
		
		//mostrarInfoBBDD();
		mostrarInfoTablas();
	}
	
	static void mostrarInfoBBDD() {
		
		Connection miConexion = null;
		
		try {
			
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "1234");
			
			//Obtención de metadatos
			DatabaseMetaData datosBBDD = miConexion.getMetaData();
			
			//Mostrar los datos
			System.out.println("Gestor de BBDD " + datosBBDD.getDatabaseProductName());
			System.out.println("Version del Gestor de BBDD " + datosBBDD.getDatabaseProductVersion());
			
			System.out.println("Nombre del driver " + datosBBDD.getDriverName());
			System.out.println("Versión del driver " + datosBBDD.getDriverVersion());
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				miConexion.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		
	}
	
	static void mostrarInfoTablas() {
		
		Connection miConexion = null;
		ResultSet miResultSet = null;
		
		try {
			
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "1234");
			
			//Obtención de metadatos
			DatabaseMetaData datosBBDD = miConexion.getMetaData();
			
			//Lista de tablas
			System.out.println("Lista de tablas");
			
			miResultSet  = datosBBDD.getTables("curso_sql", null, null, new String[ ] {"TABLE"});
			//miResultSet  = datosBBDD.getTables(null, null, null, null); esta forma tambien
			 
			
			//Recorremos
			
			while(miResultSet.next()) {
				System.out.println(miResultSet.getString("TABLE_NAME"));
			}
			
			//Lista de columnas Productos
			
			System.out.println("");
			System.out.println("Campo de Productos");
			
			miResultSet  = datosBBDD.getColumns(null, null, "productos", null);
			
			//Recorremos
			
			while(miResultSet.next()) {
				System.out.println(miResultSet.getString("COLUMN_NAME"));
			
			
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				miConexion.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		
	}

}
