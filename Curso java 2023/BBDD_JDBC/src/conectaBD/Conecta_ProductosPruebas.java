package conectaBD;
import java.sql.*;
public class Conecta_ProductosPruebas {

	public static void main(String[] args) {
		
		try {
			//Paso 1. Crear conexion
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "1234");
			
			// Paso 2. Crear objeto Statement
			Statement miStatement  =  miConexion.createStatement();
			
			//Paso 3. Ejecutar SQL
			ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM PRODUCTOS");
			
			//Paso 4. Recorrer el ResultSet(tabla virtual)
			while(miResultSet.next()) {
				System.out.println(miResultSet.getString("CÓDIGOARTÍCULO") + " "+ miResultSet.getString("NOMBREARTÍCULO")+" "+ miResultSet.getDouble("PRECIO")
				+ " "+ miResultSet.getDate("FECHA"));
			}
			miResultSet.close();
		}catch(Exception e) {
			System.out.println("No conecta");
			e.printStackTrace();
		}

	}

}
