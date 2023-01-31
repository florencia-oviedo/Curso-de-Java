package poo;

public class Furgoneta extends Coche {
	private int capacidad_carga;
	private int plazas_extra;
	
	public Furgoneta(int plazas_extra,int capacidad_carga) {
		super();
		this.plazas_extra = plazas_extra;
		this.capacidad_carga = capacidad_carga;
	}
	
	//getter
	public String dimeDatosFurgoneta() {
		return "La capacidad de carga es: "+ capacidad_carga +
				" Y las plazas son: "+ plazas_extra;
	}
}
