package conectaBD;

import java.sql.*;

public class ConsultaPreparada {

	public static void main(String[] args) {
		
		
		try {
			// 1. CREAR LA CONEXION
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "1234");
			
			//2. PREPARAR LA CONSULTA
			PreparedStatement miSentencia = miConexion.prepareStatement("SELECT NOMBREARTÍCULO,SECCIÓN,PAÍSDEORIGEN FROM PRODUCTOS "
					+ "WHERE SECCIÓN= ? AND PAÍSDEORIGEN=? ");
			
			// 3. ESTABLECER LOS PARAMETROS DE CONSULTA.
			miSentencia.setString(1, "Deportes");
			miSentencia.setString(2, "USA");
			
			// 4. EJECUTAR Y RECORRER LA CONSULTA
			ResultSet rs = miSentencia.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString(1) + " "+ rs.getString(2) + " " + rs.getString(3));
					
			}
			
			rs.close();
			
			//REUTILIZACION SQL
			System.out.println("");
			System.out.println("Ejecución de la 2da consulta");
			System.out.println("");
			
			miSentencia.setString(1, "CERÁMICA");
			miSentencia.setString(2, "CHINA");
			
			// 4. EJECUTAR Y RECORRER LA CONSULTA
			rs = miSentencia.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString(1) + " "+ rs.getString(2) + " " + rs.getString(3));
					
			}
			
			rs.close();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
