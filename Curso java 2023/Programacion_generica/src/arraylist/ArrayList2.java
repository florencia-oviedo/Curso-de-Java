package arraylist;

public class ArrayList2 {
	
	//campos de clase
	private Object[] datosElemento;
	private int i=0;
	
	//constructor
	public ArrayList2(int z) {
		datosElemento = new Object[z];
	}
	
	//metodo get
	public Object get(int i) {
		return datosElemento[i];
	}
	
	//metodo add
	public void add(Object o) {
		datosElemento[i] = o;
		i++;
	}
	
	

	
}
