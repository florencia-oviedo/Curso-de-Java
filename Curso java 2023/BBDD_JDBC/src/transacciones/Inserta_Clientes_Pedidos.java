package transacciones;
import java.sql.*;

public class Inserta_Clientes_Pedidos {

	public static void main(String[] args) {
		
		// ------------------------------TEMA TRANSACCIONES JDBC-----------------------------------
		
		Connection miConexion = null;
		try {
			 miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "1234");
			
			miConexion.setAutoCommit(false); //Indicamos que queremos la consultas SQL en bloque todas juntas q se ejecuten
			
			Statement miStatement = miConexion.createStatement();
			
			String instruccion_Sql1 = "INSERT INTO CLIENTES(CÓDIGOCLIENTE,EMPRESA,DIRECCIÓN) VALUES ('CT85','Oviedo SA', 'PBOTANICO2')";
			
			miStatement.executeUpdate(instruccion_Sql1);
			
			String instruccion_Sql2 = "INSERT INTO PEDIDOS(NÚMERODEPEDIDO,CÓDIGOCLIENTE,FECHADEPEDIDO) VALUES ('99','CT85','2000-11-03')";
			
			miStatement.executeUpdate(instruccion_Sql2);
			
			miConexion.commit();
			
			System.out.println("Datos ingresados correctamente");
			
			
		}catch(Exception e) {
			
			System.out.println("ERROR EN LA INSERCIÓN DE DATOS");
			
			try {
				miConexion.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

}
