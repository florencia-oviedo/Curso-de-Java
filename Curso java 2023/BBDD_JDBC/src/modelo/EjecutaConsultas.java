package modelo;
import java.sql.*;

public class EjecutaConsultas {
	
	private Conexion miConexion;
	private ResultSet rs;
	private PreparedStatement enviaConsultaSeccion;
	private final String consultaSeccion ="SELECT NOMBREARTÍCULO,SECCIÓN,PRECIO,PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=?";
	
	private PreparedStatement enviaConsultaPais;
	private final String consultaPais ="SELECT NOMBREARTÍCULO,SECCIÓN,PRECIO,PAÍSDEORIGEN FROM PRODUCTOS WHERE PAÍSDEORIGEN=?";
	
	private PreparedStatement enviaConsultaSeccionPais;
	private final String consultaSeccionPais ="SELECT NOMBREARTÍCULO,SECCIÓN,PRECIO,PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=? AND PAÍSDEORIGEN=?";

	private Statement enviaConsultaTodos;
	private final String ConsultaTodos = "SELECT NOMBREARTÍCULO,SECCIÓN,PRECIO,PAÍSDEORIGEN FROM PRODUCTOS ";
	
	public EjecutaConsultas(){
		miConexion = new Conexion();
	}
	
	
	
	public ResultSet filtraBBDD (String seccion, String pais) {
		
		Connection conecta = miConexion.dameConexion();
		rs = null;
		
		
		try {
		if(!seccion.equals("Todos") && pais.equals("Todos")) {
			
			enviaConsultaSeccion = conecta.prepareStatement(consultaSeccion);
			
			enviaConsultaSeccion.setString(1, seccion);
			
			rs = enviaConsultaSeccion.executeQuery();
				
		}
		
		
		else if(seccion.equals("Todos") && !pais.equals("Todos")) {
			
			enviaConsultaPais = conecta.prepareStatement(consultaPais);
			
			enviaConsultaPais.setString(1, pais);
			
			rs = enviaConsultaPais.executeQuery();
		}
		
		else if(!seccion.equals("Todos") && !pais.equals("Todos")){
			
			enviaConsultaSeccionPais = conecta.prepareStatement(consultaSeccionPais);
			
			enviaConsultaSeccionPais.setString(1, seccion);
			enviaConsultaSeccionPais.setString(2, pais);
			rs = enviaConsultaSeccionPais.executeQuery();
			
		}else {
				enviaConsultaTodos = conecta.createStatement();
				rs = enviaConsultaTodos.executeQuery(ConsultaTodos);
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return rs;
		
	}

	
	
	
}
