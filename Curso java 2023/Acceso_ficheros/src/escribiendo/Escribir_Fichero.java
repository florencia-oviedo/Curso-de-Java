package escribiendo;

import java.io.FileWriter;
import java.io.IOException;

public class Escribir_Fichero {

	public static void main(String[] args) {
		
		Escribiendo acceder_escritura = new Escribiendo();
		acceder_escritura.escribir();

	}

}
class Escribiendo{
	public void escribir() {
		String frase = "Esto es una prueba de escritura2";
		try {
			FileWriter escritura = new FileWriter("C:/Users/Nacho/Desktop/texto_nuevo.txt");// lugar que quiero guardar el archivo nuevo + su nombre nuevo con la extension
			
			for(int i=0; i < frase.length();i++) {
				
				escritura.write(frase.charAt(i));
				
			}
			escritura.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
