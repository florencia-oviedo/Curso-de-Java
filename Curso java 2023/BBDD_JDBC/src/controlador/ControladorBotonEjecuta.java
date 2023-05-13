package controlador;

import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.*;
import vista.*;

public class ControladorBotonEjecuta implements ActionListener {
	
	private MarcoAplicacion2 elmarco;
	EjecutaConsultas obj = new EjecutaConsultas();
	private ResultSet resultadoConsulta;
	
	public ControladorBotonEjecuta(MarcoAplicacion2 elmarco) {
		this.elmarco = elmarco;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String seleccionSeccion = (String) elmarco.secciones.getSelectedItem();
		String seleccionPais = (String) elmarco.paises.getSelectedItem();
		
		resultadoConsulta  = obj.filtraBBDD(seleccionSeccion, seleccionPais);
		
		try {
			elmarco.resultado.setText("");
			while(resultadoConsulta.next()) {
				
				elmarco.resultado.append(resultadoConsulta.getString(1));
				elmarco.resultado.append(", ");
				
				elmarco.resultado.append(resultadoConsulta.getString(2));
				elmarco.resultado.append(", ");
				
				elmarco.resultado.append(resultadoConsulta.getString(3));
				elmarco.resultado.append(", ");
				
				elmarco.resultado.append(resultadoConsulta.getString(4));
				elmarco.resultado.append("\n");
			}
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
	}

}
