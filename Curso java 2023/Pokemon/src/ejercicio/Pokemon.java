package ejercicio;

public abstract class Pokemon {
	
	protected int numPokedex; //solo las hijas tienen acceso con protected
	protected String nombre;
	protected double peso;
	protected String sexo;
	protected int temporada;
	
	public Pokemon(int numPokedex,String nombre,double peso,String sexo,int temporada) {
		this.numPokedex = numPokedex;
		this.nombre = nombre;
		this.peso = peso;
		this.sexo = sexo;
		this.temporada = temporada;
	}
	
	// Tienen 3 ataques en comun
	protected abstract void atacarPlacaje();
	protected abstract void ataqueAraniazo();
	protected abstract void ataqueMordisco();
	//los electricos,agua,fuego y planta tienen ataques distintos por eso usamos interfaces para cada uno

}
