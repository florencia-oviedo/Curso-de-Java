package ejercicio;

public class Squirtle extends Pokemon implements IAgua {
	
	public Squirtle(int numPokedex,String nombre,double peso,String sexo,int temporada) {
		super(numPokedex,nombre,peso,sexo,temporada);
	}

	@Override
	protected void atacarPlacaje() {
		System.out.println("Hola soy Squirtle y este es mi ataque Placaje");
		
	}

	@Override
	protected void ataqueAraniazo() {
		System.out.println("Hola soy Squirtle y este es mi ataque Arañazo");
		
	}

	@Override
	protected void ataqueMordisco() {
		System.out.println("Hola soy Squirtle y este es mi ataque Mordisco");
		
	}

	@Override
	public void atacarHidrobomba() {
		System.out.println("Hola soy Squirtle y este es mi ataque Hidrobomba");
		
	}

	@Override
	public void atacarBurbuja() {
		System.out.println("Hola soy Squirtle y este es mi ataque Burbuja");
		
	}

	@Override
	public void atacarPistolaAgua() {
		System.out.println("Hola soy Squirtle y este es mi ataque Pistola agua");
		
	}

}
