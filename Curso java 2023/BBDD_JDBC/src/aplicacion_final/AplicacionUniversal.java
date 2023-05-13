package aplicacion_final;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AplicacionUniversal {

	public static void main(String[] args) {
		
		//Una BBDD conectada a un documento txt que tendra los datos de una base de datos que luego la app va a acceder
		MarcoBBDD marco = new MarcoBBDD();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);

	}

}

class MarcoBBDD extends JFrame {
	
	public MarcoBBDD() {
		
		setBounds(300,300,700,700);
		
		LaminaBBDD milamina = new LaminaBBDD();
		
		add(milamina);
	}
	
}

class LaminaBBDD extends JPanel{
	
	public LaminaBBDD() {
		
		setLayout(new BorderLayout());
		comboTablas = new JComboBox();
		areaInformacion = new JTextArea();
		add(areaInformacion,BorderLayout.CENTER);
		
		conectarBBDD();
		obtenerTablas();
		comboTablas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String nombreTabla = (String) comboTablas.getSelectedItem();
				mostrarInfoTabla(nombreTabla);
				
				
			}
			
		});
		
		add(comboTablas,BorderLayout.NORTH);
		
		
		
	}
	//creamos un metodo para que conecte la BBDD de curso_sql
	public void conectarBBDD() {
		
		miConexion = null;
		
		//String datos[] = new String[4];
		
		try {
			
			entrada = new FileReader("C:/Users/Nacho/Desktop/datos_config.txt");
		}catch(IOException e) {
			
			JOptionPane.showMessageDialog(this,"ERROR NO SE ENCONTRÓ ARCHIVO");
			JFileChooser chooser = new JFileChooser();
			
			FileNameExtensionFilter filter = new FileNameExtensionFilter( //construye un filtro abre la ventana de documetnos
			        "Archivos de textos", "txt"); //solo hace visible estos tipos de documentos q vamos a poder elegir
			
			chooser.setFileFilter(filter);
			
			int returnVal = chooser.showOpenDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION) { //el if evalua si se apreto abrir o cerrar
				
				try {
					entrada = new FileReader(chooser.getSelectedFile().getAbsolutePath());
				} catch (FileNotFoundException e1) {
					
					e1.printStackTrace();
				}
				
			    
			    }	
			
		}
			
		try {
			BufferedReader miBuffer = new BufferedReader(entrada);
			
			for(int i=0; i<=3;i++) {
				
				datos[i] = miBuffer.readLine(); //almacena las distintas lineas de texto
			}
			
			miConexion = DriverManager.getConnection(datos[0], datos[1], datos[2]);
			
			entrada.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		}
	
	
	public void obtenerTablas() {
		
		ResultSet miResultSet = null;
		try {
			DatabaseMetaData datosBBDD = miConexion.getMetaData();
			
			
			miResultSet = datosBBDD.getTables(datos[3], null, null, null);
			
			while(miResultSet.next()) {
				
				comboTablas.addItem(miResultSet.getString("TABLE_NAME"));
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void mostrarInfoTabla(String tabla) {
		
		ArrayList<String> campos = new ArrayList<String>();
		
		String consulta = "SELECT * FROM "+ tabla;
		
		try {
			
			areaInformacion.setText("");
			Statement miStatement  = miConexion.createStatement();
			ResultSet miResultSet = miStatement.executeQuery(consulta);
			
			ResultSetMetaData rsBBDD = miResultSet.getMetaData(); //obtener los metadatos de ese result set
			
			for(int i=1; i<= rsBBDD.getColumnCount();i++) {
				
				campos.add(rsBBDD.getColumnLabel(i));
			}
			
			while(miResultSet.next()) {
				
				for( String nombreCampo:campos) {
					areaInformacion.append(miResultSet.getString(nombreCampo) + " ");
				}
				
				areaInformacion.append("\n");
			}
			
		}catch(Exception e) {
			
		}
		
	}
	
	
	private JComboBox comboTablas ;
	private JTextArea areaInformacion;
	private Connection miConexion;
	private FileReader entrada;
	private String datos[]  = new String[4] ;
	
	
	
}