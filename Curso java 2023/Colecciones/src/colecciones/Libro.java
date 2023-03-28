package colecciones;

import java.util.Objects;

public class Libro {
	//campos de clase
	private String autor;
	private String titulo;
	private int ISBN;
	
	//Constructor
	public Libro(String titulo,String autor, int ISBN) {
		this.autor = autor;
		this.titulo = titulo;
		this.ISBN = ISBN;
	}
	
	public String getDatos() {
		return "El titulo es: "+titulo+". El autor es: "+autor+". El código ISBN es: "+ISBN;
	}
	/*public boolean equals(Object obj) { //Sobreescribimos equals
		if(obj instanceof Libro) {
			Libro otro = (Libro) obj; //casting para que se transforme en clase Libro
			if(this.ISBN == otro.ISBN) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}*/
	//de forma automatica eclipse sobreescribe equals en source>generate hashcodes y equals

	@Override
	public int hashCode() {
		return Objects.hash(ISBN);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return ISBN == other.ISBN;
	}
	
}
