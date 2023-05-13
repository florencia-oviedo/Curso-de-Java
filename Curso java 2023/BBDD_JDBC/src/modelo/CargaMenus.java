package modelo;
import java.sql.*;

public class CargaMenus {
	
	public Conexion miConexion;
	public ResultSet rs;
	public ResultSet rs2;
	
	public CargaMenus() {
		
		miConexion = new Conexion();
	}
	
	public String ejecutaConsultas() {
		
		Productos miProducto = null;
		Connection accesoBBDD = miConexion.dameConexion();
		
		try {
			
			Statement secciones = accesoBBDD.createStatement();
			Statement paises = accesoBBDD.createStatement();
			
			rs = secciones.executeQuery("SELECT DISTINCTROW SECCIÓN FROM PRODUCTOS");
			
			rs2 = paises.executeQuery("SELECT DISTINCTROW PAÍSDEORIGEN FROM PRODUCTOS");
			
			
			
			
				miProducto = new Productos();
				miProducto.setSeccion(rs.getString(1));
				miProducto.setSeccion(rs2.getString(1));
			

			rs.close();
			rs2.close();
			accesoBBDD.close();
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return miProducto.getSeccion();
	}
	
	/*public ResultSet ejecutaConsultas() { //Otra forma del metodo ejecutaConsulta
		Connection accesoBBDD = miConexion.dameConexion();
		try {
			
			Statement secciones = accesoBBDD.createStatement();
			return rs = secciones.executeQuery("SELECT DISTINCTROW SECCIÓN FROM PRODUCTOS");
			
		}catch(Exception e) {
			
		}
		return null;	
	}*/
	
	
	
}
