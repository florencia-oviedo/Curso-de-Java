package conectaBD;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Aplicacion_Consulta {

	public static void main(String[] args) {
		
		JFrame mimarco = new MarcoAplicacion();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);

	}

}
class MarcoAplicacion extends JFrame{
	//campos de clase
	private JComboBox secciones;
	private JComboBox paises;
	private JTextArea resultado;
	private PreparedStatement enviaConsultaSeccion;
	private PreparedStatement enviaConsultaPais;
	private PreparedStatement enviaConsultaTodos;
	
	private Statement enviaConsultaTodos1;
	private final String consultaTodos1 = "SELECT NOMBREARTÍCULO, SECCIÓN,PRECIO, PAÍSDEORIGEN FROM PRODUCTOS";
	
	private final String consultaSeccion = "SELECT NOMBREARTÍCULO, SECCIÓN,PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=?";
	private Connection miConexion;
	private final String consultaPais = "SELECT NOMBREARTÍCULO, SECCIÓN,PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE PAÍSDEORIGEN=?";
	private final String consultaTodos = "SELECT NOMBREARTÍCULO, SECCIÓN,PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=? AND PAÍSDEORIGEN=?";
	
	public MarcoAplicacion() {
		setTitle("Consulta BBDD");
		setBounds(500,300,400,400);
		setLayout(new BorderLayout());
		JPanel menus = new JPanel();
		menus.setLayout(new FlowLayout());
		secciones = new JComboBox();
		secciones.setEditable(false);
		secciones.addItem("Todos");
		
		paises = new JComboBox();
		paises.setEditable(false);
		paises.addItem("Todos");
		
		resultado =new JTextArea(4,50);
		resultado.setEditable(false);
		add(resultado);
		
		menus.add(secciones);
		menus.add(paises);
		
		add(menus,BorderLayout.NORTH);
		
		add(resultado,BorderLayout.CENTER);
		
		JButton botonConsulta = new JButton("Consulta");
		
		botonConsulta.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				ejecutaConsulta();
			}
			
		});
		
		add(botonConsulta,BorderLayout.SOUTH);
		
		
		
		//----------------------CONEXION CON BBDD-----------------
		try {
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "1234");
			
			Statement sentencia  =  miConexion.createStatement();
			
			//-----------CARGA JCOMBOBOX SECCIONES-----------------
			String consulta = "SELECT DISTINCTROW SECCIÓN FROM PRODUCTOS";
			
			ResultSet rs = sentencia.executeQuery(consulta);
			
			while(rs.next()) {
				
				secciones.addItem(rs.getString(1));
			}
			
			rs.close();
			
			//-----------CARGA JCOMBOBOX PAISES-----------------
			consulta = "SELECT DISTINCTROW PAÍSDEORIGEN FROM PRODUCTOS";
			
			rs = sentencia.executeQuery(consulta);
			
			while(rs.next()) {
				
				paises.addItem(rs.getString(1));
			}
			
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//------METODO PARA CONSULTA
	private void ejecutaConsulta() {
		
		ResultSet rs = null;
		
		try {
			
			resultado.setText("");
			
			String seccion = (String) secciones.getSelectedItem();
			
			String pais = (String) paises.getSelectedItem();
			
			if(!seccion.equals("Todos") && pais.equals("Todos")) { //PRIMERA POSILIBILIDAD SI ELIGIO SOLO SECCION Y NO PAISES
				
				enviaConsultaSeccion = miConexion.prepareStatement(consultaSeccion);
			
				enviaConsultaSeccion.setString(1, seccion); //lo q eligio en el desplegable y el 1 es el ? parametro de la consulta
			
				rs = enviaConsultaSeccion.executeQuery();	
			}
			else if(seccion.equals("Todos") && !pais.equals("Todos")) { //Si solo elige el 2do desplegable y el primero lo deja tal cual
				
				enviaConsultaPais = miConexion.prepareStatement(consultaPais);
				
				enviaConsultaPais.setString(1, pais); //lo q eligio en el desplegable y el 1 es el ? parametro de la consulta
			
				rs = enviaConsultaPais.executeQuery();
				
			}
			else if(!seccion.equals("Todos") && !pais.equals("Todos")) {
				
				enviaConsultaTodos = miConexion.prepareStatement(consultaTodos);
				
				enviaConsultaTodos.setString(1, seccion);
				
				enviaConsultaTodos.setString(2, pais);
			
				rs = enviaConsultaTodos.executeQuery();
				
			}
			else { //CREE PARA QUE SE MUESTRE TODOS TANTO EN SECCION Y PAISES
				enviaConsultaTodos1  = miConexion.createStatement();
				rs = enviaConsultaTodos1.executeQuery(consultaTodos1);
			}
			
			
			while(rs.next()) {
				resultado.append(rs.getString(1));
				
				resultado.append(", ");
				
				resultado.append(rs.getString(2));
				
				resultado.append(", ");
				
				resultado.append(rs.getString(3));
				
				resultado.append(", ");
				
				resultado.append(rs.getString(4));
				
				resultado.append("\n");
			}
			
			
			
				
		}catch(Exception e) {
			
		}
		
		
	}
}