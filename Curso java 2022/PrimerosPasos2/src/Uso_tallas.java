import java.util.*;
public class Uso_tallas {
	
	enum Talla {
		
		MINI("S"),MEDIANO("M"),GRANDE("L"),MUY_GRANDE("XL");
		private Talla(String abreviatura) {
			this.abreviatura = abreviatura;
		}
		private String abreviatura;
		
		public String dame_abreviatura() {
			return abreviatura;
		}
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Escribe una talla: MINI,MEDIANO,GRANDE,MUY_GRANDE");
		String entrada_datos = entrada.next().toUpperCase();
		Talla la_talla = Enum.valueOf(Talla.class, entrada_datos);
		
		System.out.println("Talla = "+ la_talla);
		System.out.println("Abreviatura = "+ la_talla.dame_abreviatura());
		
	}

}
