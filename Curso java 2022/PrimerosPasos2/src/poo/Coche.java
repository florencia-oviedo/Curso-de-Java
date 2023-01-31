package poo;

public class Coche {
	
	private int ruedas;
	private int largo;
	private int ancho;
	private int motor;
	private int peso_plataforma;
	private String color;
	private int peso_total;
	private boolean asientos_cuero,climatizador;
	
	public Coche() {
		ruedas = 4;
		largo = 2000;
		ancho = 300;
		motor = 1600;
		peso_plataforma = 500;
	}
	
	public String dime_datos_generales() { //GETTER LARGO
		return "La plataforma del vehículo tiene "+ruedas+" ruedas "+
			". Mide "+ largo/1000 + " metros con un ancho de "+ ancho +
			" cm y un peso de plataforma de "+peso_plataforma + " kg.";
	}
	
	public void establece_color(String color_coche) { //setter color
		color = color_coche;
	}
	
	public String dime_color() { //getter color
		return "El color del coche es: "+color;
	}
	
	public void configura_asientos(String asientos_cuero) {
		if(asientos_cuero.equalsIgnoreCase("si")) {
			this.asientos_cuero = true;
		}
		else {
			this.asientos_cuero = false;
		}
	}
	
	public String dime_asientos() {
		if(asientos_cuero == true) {
			return "El coche tiene asientos de cuero";
		}
		else {
			return "El coche tiene asientos de serie";
		}
	}
	
	public void configura_climatizador(String climatizador) { //SETTER
		if(climatizador.equalsIgnoreCase("si")) {
			this.climatizador = true;
		}
		else {
			this.climatizador = false;
		}
	}
	
	public String dime_climatizador() {
		if(climatizador==true) {
			return "El coche incorpora climatizador";
		}
		else {
			return "El coche lleva aire acondicionado";
		}
	}
	
	public String dime_peso_coche() {
		int peso_carroceria = 500;
		peso_total = peso_plataforma + peso_carroceria;
		
		if(asientos_cuero == true) {
			peso_total = peso_total + 50;
		}
		
		if(climatizador == true) {
			peso_total +=20;
		}
		return "El peso del coche es: "+peso_total;
	}
	
	public int precio_coche() {
		int precio_final = 10000;
		if(asientos_cuero == true) {
			precio_final += 2000;
		}
		if(climatizador == true) {
			precio_final += 1500; 
		}
		return precio_final;
	}

}
