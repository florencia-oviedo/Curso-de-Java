package conectaBD;

import java.sql.*;

public class ModificaBBDD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//Paso 1. Crear conexion
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "1234");
			
			// Paso 2. Crear objeto Statement
			Statement miStatement  =  miConexion.createStatement();
			
			//Para insertar registros
			//String intruccion_Sql = "INSERT INTO PRODUCTOS(CÓDIGOARTÍCULO,NOMBREARTÍCULO,PRECIO) VALUES('AR77','PANTALÓN',25.35)";
			
			//Actualizar registro
			//String intruccion_Sql ="UPDATE PRODUCTOS SET PRECIO = PRECIO*2 WHERE CÓDIGOARTÍCULO='AR77'";
			
			//Eliminar registro
			String intruccion_Sql = "DELETE FROM PRODUCTOS WHERE CÓDIGOARTÍCULO='AR80'";
			miStatement.executeUpdate(intruccion_Sql);
			
			System.out.println("Datos modificados correctamente");
					
			
			
		}catch(Exception e) {
			System.out.println("No conecta");
			e.printStackTrace();
		}
	}

}
