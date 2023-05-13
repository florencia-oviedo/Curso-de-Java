package aplicacion_final;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Tirar {

	public static void main(String[] args) {
		
		// como hacer una ventana donde estan los documentos para buscar un archivo
		Marco marco = new Marco();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JFileChooser chooser = new JFileChooser();
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter( //construye un filtro abre la ventana de documetnos
		        "Archivos de textos", "txt"); //solo hace visible estos tipos de documentos q vamos a poder elegir
		
		chooser.setFileFilter(filter);
		
		int returnVal = chooser.showOpenDialog(marco);
		if(returnVal == JFileChooser.APPROVE_OPTION) { //el if evalua si se apreto abrir o cerrar
			
		    System.out.println("You chose to open this file: " +
		            chooser.getSelectedFile().getAbsolutePath()); //me dara el nombre del git/imagen q aprete
		    
		    }

	}

}

class Marco extends JFrame{
	
	public Marco() {
		setBounds(300,300,300,300);
		setVisible(true);
	}
}
