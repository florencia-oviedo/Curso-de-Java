package ejercicio;

public class Bulbasur extends Pokemon implements IPlanta {
	public Bulbasur(int numPokedex,String nombre,double peso,String sexo,int temporada) {
		
		super(numPokedex,nombre,peso,sexo,temporada);
		
	}

	@Override
	protected void atacarPlacaje() {
		System.out.println("Hola soy Bulbasur y este es mi ataque Placaje");
		
	}

	@Override
	protected void ataqueAraniazo() {
		System.out.println("Hola soy Bulbasur y este es mi ataque Arañazo");
		
	}

	@Override
	protected void ataqueMordisco() {
		System.out.println("Hola soy Bulbasur y este es mi ataque Mordisco");
		
	}

	@Override
	public void atacarDrenaje() {
		System.out.println("Hola soy Bulbasur y este es mi ataque Drenaje");
		
	}

	@Override
	public void atacarParalizar() {
		System.out.println("Hola soy Bulbasur y este es mi ataque Paralizar");
		
	}

}
