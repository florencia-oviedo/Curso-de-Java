package ejercicio;

public class Pikachu extends Pokemon implements IElectrico{
	
	public Pikachu(int numPokedex,String nombre,double peso,String sexo,int temporada) {
		super(numPokedex,nombre,peso,sexo,temporada);
	}

	@Override
	protected void atacarPlacaje() {
		System.out.println("Hola soy Pikachu y este es mi ataque Placaje");
		
	}

	@Override
	protected void ataqueAraniazo() {
		System.out.println("Hola soy Pikachu y este es mi ataque Arañazo");
		
	}

	@Override
	protected void ataqueMordisco() {
		System.out.println("Hola soy Pikachu y este es mi ataque Mordisco");
		
	}

	@Override
	public void atacarImpactrueno() {
		System.out.println("Hola soy Pikachu y este es mi ataque impactTrueno");
		
	}

	@Override
	public void atacarPunioTrueno() {
		System.out.println("Hola soy Pikachu y este es mi ataque Puño Trueno");
		
	}

}
