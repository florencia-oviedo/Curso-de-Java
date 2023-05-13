package transacciones;

import java.sql.*;

import javax.swing.JOptionPane;

public class TransaccionProductos {

	public static void main(String[] args) {
		
		//--------------------------- TRANSACCIONES PARTE 2 JDBC-------------------------
		
		Connection miConexion = null;
		try {
			 miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "1234");
			
			miConexion.setAutoCommit(false); //Indicamos que queremos la consultas SQL en bloque todas juntas q se ejecuten
			
			Statement miStatement = miConexion.createStatement();
			
			
			String instruccion_Sql1 = "DELETE FROM PRODUCTOS WHERE PAÍSDEORIGEN='ITALIA'";

			String instruccion_Sql2 = "DELETE FROM PRODUCTOS WHERE PRECIO>300";
			
			String instruccion_Sql3 = "UPDATE PRODUCTOS SET PRECIO= PRECIO*1.15";
			
			boolean ejecutar = ejecutar_transaccion();
			
			if(ejecutar) {
				
				miStatement.executeUpdate(instruccion_Sql1);
				
				miStatement.executeUpdate(instruccion_Sql2);
				
				miStatement.executeUpdate(instruccion_Sql3);
				
				miConexion.commit();
				
				System.out.println("Se ejecutó la transación correctamente");
			}
			else {
				System.out.println("No se realizó ningún cambio en la base de datos");
			}
			
			
			
			
		}catch(Exception e) {
			
			try {
				miConexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			System.out.println("ERROR Algo salió mal y no se realizó cambio alguno en la BBDD");
		}
	
	}
	
	static boolean ejecutar_transaccion() {
		
		String ejecucion =JOptionPane.showInputDialog("¿Ejecutamos la transacción?");
		
		if(ejecucion.equals("si")) {
			return true;
		}else {
			return false;
		}
		
	}

}
