package ejercicio;

public class EjercicioIntegrador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Squirtle squirtle = new Squirtle(3,"Squirtle",60,"Macho",1);
		Bulbasur bulbasur = new Bulbasur(4,"Bulbasur",80,"Hembra",1);
		Charmander charmander = new Charmander(5,"Charmander",50,"Macho",1);
		Pikachu pikachu = new Pikachu(5,"Pikachu",65,"Macho",1);
		
		squirtle.ataqueAraniazo();
		squirtle.atacarHidrobomba();
		charmander.ataqueAraniazo();
		charmander.atacarLanzaLlamas();
		bulbasur.ataqueAraniazo();
		bulbasur.atacarDrenaje();
		pikachu.ataqueAraniazo();
		pikachu.atacarImpactrueno();
	}

}

