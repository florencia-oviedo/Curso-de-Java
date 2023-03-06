package ejercicio;

public class Charmander extends Pokemon implements IFuego {
	
	public Charmander(int numPokedex,String nombre,double peso,String sexo,int temporada) {
		super(numPokedex,nombre,peso,sexo,temporada);
	}

	@Override
	protected void atacarPlacaje() {
		System.out.println("Hola soy Charmander y este es mi ataque Placaje");
		
	}

	@Override
	protected void ataqueAraniazo() {
		System.out.println("Hola soy Charmander y este es mi ataque Arañazo");
		
	}

	@Override
	protected void ataqueMordisco() {
		System.out.println("Hola soy Charmander y este es mi ataque Mordisco");
		
	}

	@Override
	public void atacarPunioFuego() {
		System.out.println("Hola soy Charmander y este es mi ataque Puño fuego");
		
	}

	@Override
	public void atacarLanzaLlamas() {
		System.out.println("Hola soy Charmander y este es mi ataque Lanza llamas");
		
	}

	@Override
	public void atacarAscuas() {
		System.out.println("Hola soy Charmander y este es mi ataque Ascuas");
		
	}

}
