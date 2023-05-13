package proc_almacenado;
import java.sql.*;

public class ConsultaClientes {

	public static void main(String[] args) {
		
		// --------------------------PROCEDIMIENTOS ALMACENADOS JDBC-------------------------
		try {
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "1234");
			
			CallableStatement miSentencia = miConexion.prepareCall("{CALL MUESTRACLIENTES}");
			
			ResultSet rs = miSentencia.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString(1)+ ", "+rs.getString(2) + " ," + rs.getString(3));
			}
			
			rs.close();
			
		}catch(Exception e) {
			
		}
	}

}
