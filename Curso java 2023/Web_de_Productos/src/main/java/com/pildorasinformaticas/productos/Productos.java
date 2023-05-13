package com.pildorasinformaticas.productos;

import java.util.Date;

public class Productos {
	
	private String codigoArticulo;
	
	private String seccion;
	
	private String nArticulo;
	
	private double precio;
	
	private Date fecha;
	
	private String importado;
	
	private String paisOrigen;

	public Productos(String codigoArticulo, String seccion, String nArticulo, double precio, Date fecha,
			String importado, String paisOrigen) {
		this.codigoArticulo = codigoArticulo;
		this.seccion = seccion;
		this.nArticulo = nArticulo;
		this.precio = precio;
		this.fecha = fecha;
		this.importado = importado;
		this.paisOrigen = paisOrigen;
	}

	public Productos(String seccion, String nArticulo, double precio, Date fecha, String importado, String paisOrigen) {
		this.seccion = seccion;
		this.nArticulo = nArticulo;
		this.precio = precio;
		this.fecha = fecha;
		this.importado = importado;
		this.paisOrigen = paisOrigen;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getnArticulo() {
		return nArticulo;
	}

	public void setnArticulo(String nArticulo) {
		this.nArticulo = nArticulo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getImportado() {
		return importado;
	}

	public void setImportado(String importado) {
		this.importado = importado;
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	@Override
	public String toString() {
		return "Productos [codigoArticulo=" + codigoArticulo + ", seccion=" + seccion + ", nArticulo=" + nArticulo
				+ ", precio=" + precio + ", fecha=" + fecha + ", importado=" + importado + ", paisOrigen=" + paisOrigen
				+ "]";
	}
	
	
	
	
	
	
	
	
}
