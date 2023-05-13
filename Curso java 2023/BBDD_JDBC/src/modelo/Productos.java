package modelo;

public class Productos {
	
	private String nArticulos;
	private String seccion;
	private String precio;
	private String pOrigen;
	
	public Productos() {
		nArticulos="";
		seccion="";
		precio="";
		pOrigen="";
	}

	public String getnArticulos() {
		return nArticulos;
	}

	public void setnArticulos(String nArticulos) {
		this.nArticulos = nArticulos;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getpOrigen() {
		return pOrigen;
	}

	public void setpOrigen(String pOrigen) {
		this.pOrigen = pOrigen;
	}
	
	
}
