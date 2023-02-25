package leyendo_escribiendo;
import java.io.*;

public class Lectura_Escritura_Byte {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int contador = 0;
		int[] datos_entrada = new int[45462];
		try {
			
			FileInputStream archivo_lectura = new FileInputStream("C:/Users/Nacho/Desktop/leyendo_creando/nami.jpg");
			
			boolean final_ar = false;
			
			while(!final_ar) {
				int byte_entrada = archivo_lectura.read();
				if(byte_entrada != -1) {
					datos_entrada[contador] = byte_entrada;
				}
				else {
					final_ar = true;
				}
				
				System.out.println(datos_entrada[contador]);
				contador++;
			}
			
		}catch(IOException e) {
			System.out.println("Error al acceder a la imagen");
		}
		System.out.println("Cantidad de bytes: "+contador);
		
		crear_fichero(datos_entrada);

	}
	
	static void crear_fichero(int datos_nuevo_fichero []) {
		
		try {
			FileOutputStream fichero_nuevo = new FileOutputStream("C:/Users/Nacho/Desktop/leyendo_creando/nami_copia.jpg");
			
			for(int i=0;i<datos_nuevo_fichero.length;i++) {
				
				fichero_nuevo.write(datos_nuevo_fichero[i]);
			}
			
			fichero_nuevo.close();
		}catch(IOException e) {
			System.out.println("Error al crear el archivo");
		}
	}

}
