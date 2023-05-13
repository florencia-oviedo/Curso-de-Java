package com.pildorasinformaticas.productos;

import java.sql.*;
import java.util.*;
import java.util.Date;

import javax.sql.DataSource;


public class ModeloProductos {

	private DataSource origenDatos;
	
	public ModeloProductos(DataSource origenDatos) {
		this.origenDatos = origenDatos;
	}
	
	public List<Productos> getProductos() throws Exception {
		
		List<Productos> productos = new ArrayList<>();
		
		Connection miConexion =null;
		
		Statement miStatement = null;
		
		ResultSet miResultSet=null;
		
		//-------Establecer la conexion---------------
		
		miConexion = origenDatos.getConnection();
		
		//-------Crear sentencia SQL y statement---------
		
		String intruccionSQL ="SELECT * FROM PRODUCTOS";
		
		miStatement = miConexion.createStatement();
		
		//---------Ejecutar sentencia---------
		
		miResultSet = miStatement.executeQuery(intruccionSQL);
		
		//----Recorrer el ResultSet obtenido-------- 
		
		while(miResultSet.next()) {//mientras haya registro en el result set
			
			String c_art= miResultSet.getString("CÓDIGOARTÍCULO");
			
			String seccion= miResultSet.getString("SECCIÓN");
			String n_art= miResultSet.getString("NOMBREARTÍCULO");
			double precio= miResultSet.getDouble("PRECIO");
			Date fecha= miResultSet.getDate("FECHA");
			String importado = miResultSet.getString("IMPORTADO");
			String p_origen= miResultSet.getString("PAÍSDEORIGEN");
			
			//creamos los objetos que contengan la info de la tabla establecido en el constructor
			Productos prod_temporal = new Productos(c_art,seccion,n_art,precio,fecha,importado,p_origen);
			//agregamos esos objetos a la lista
			productos.add(prod_temporal);
				
		}
		
		return productos;
	}

	public void agregarNuevoProducto(Productos nuevoProducto) throws Exception{
		Connection miConexion = null;
		PreparedStatement miStatement = null;
		
		//Obtener la conexion con la BBDD
		try {
			
			miConexion = origenDatos.getConnection();
			
		//Crear la instruccion SQL que inserte el producto. Crear la consulta preparada
		
		String instruccionSQL = "INSERT INTO PRODUCTOS(CÓDIGOARTÍCULO,SECCIÓN,NOMBREARTÍCULO,PRECIO,FECHA,IMPORTADO,PAÍSDEORIGEN)"
				+ " VALUES(?,?,?,?,?,?,?)";
		
		miStatement = miConexion.prepareStatement(instruccionSQL);
		
		//Establecer los parametros para el producto
		miStatement.setString(1, nuevoProducto.getCodigoArticulo());
		miStatement.setString(2, nuevoProducto.getSeccion());
		miStatement.setString(3, nuevoProducto.getnArticulo());
		miStatement.setDouble(4, nuevoProducto.getPrecio());
		
		java.util.Date utilDate = nuevoProducto.getFecha(); 
		java.sql.Date fechaConvertida = new java.sql.Date(utilDate.getTime());
		
		miStatement.setDate(5, fechaConvertida);
		miStatement.setString(6, nuevoProducto.getImportado());
		miStatement.setString(7, nuevoProducto.getPaisOrigen());
		
		//Ejecutar la instruccion SQL
		miStatement.execute();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			miStatement.close();
			miConexion.close();
		}
	}

	public Productos getProducto(String codigo_articulo) throws Exception {
		
		Productos elProducto = null;
		Connection miConexion=null;
		PreparedStatement miStatement=null;
		ResultSet miRS = null;
		String cod_articulo = codigo_articulo;
		
		try {
			
		//establecer la conexion con la bbdd	
		miConexion  = origenDatos.getConnection();
		
		//crear la consulta que busque el producto
		String consultaSQL = "SELECT * FROM PRODUCTOS WHERE CÓDIGOARTÍCULO= ?";
		
		//crear la consulta preparada
		miStatement = miConexion.prepareStatement(consultaSQL);
		
		//establecer los parametros de esa consulta
		miStatement.setString(1, cod_articulo);
		
		//ejecutar la consulta
		miRS = miStatement.executeQuery();
		
		//obtener los datos de respuestas
		if(miRS.next()) {
			
			String c_art= miRS.getString("CÓDIGOARTÍCULO");
			String seccion= miRS.getString("SECCIÓN");
			String n_art= miRS.getString("NOMBREARTÍCULO");
			double precio= miRS.getDouble("PRECIO");
			Date fecha= miRS.getDate("FECHA");
			String importado = miRS.getString("IMPORTADO");
			String p_origen= miRS.getString("PAÍSDEORIGEN");
			
			elProducto = new Productos(c_art,seccion,n_art,precio,fecha,importado,p_origen);
			
		}else {
			throw new Exception("No hemos encontrado el producto con código artículo= "+cod_articulo);
		}
		
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			miStatement.close();
			miConexion.close();
		}
		
		return elProducto;
	}

	public void actualizarProducto(Productos productoActualizado) throws Exception{
		Connection miConexion = null;
		PreparedStatement miStatement = null;
		
		//Establecer la conexcion BBDD
		try {
		miConexion = origenDatos.getConnection();
			
		//Crear la sentencia SQL
		String sentenciaSQL= "UPDATE PRODUCTOS SET SECCIÓN=?, NOMBREARTÍCULO=?, PRECIO=?, FECHA=?, "
				+ "IMPORTADO=?, PAÍSDEORIGEN=? WHERE CÓDIGOARTÍCULO=?";
		
		//Crear la consulta preparada
		miStatement = miConexion.prepareStatement(sentenciaSQL);
		//Establecer los parametros
		miStatement.setString(1, productoActualizado.getSeccion());
		miStatement.setString(2, productoActualizado.getnArticulo());
		miStatement.setDouble(3, productoActualizado.getPrecio());
		
		java.util.Date utilDate = productoActualizado.getFecha(); 
		java.sql.Date fechaConvertida = new java.sql.Date(utilDate.getTime());
		miStatement.setDate(4, fechaConvertida);
		
		miStatement.setString(5, productoActualizado.getImportado());
		miStatement.setString(6, productoActualizado.getPaisOrigen());
		miStatement.setString(7, productoActualizado.getCodigoArticulo());
		
		//Ejecutar la instruccion SQL
		miStatement.execute();
		}finally {
			miStatement.close();
			miConexion.close();
		}
	}

	public void eliminarProducto(String codArticulo) throws Exception{
		
		Connection miConexion = null;
		PreparedStatement miStatement = null;
		
		// Establecer la conexion con la BBDD
		try {
		miConexion = origenDatos.getConnection();
		
		//Consulta SQL
		String consultaSQL = "DELETE FROM PRODUCTOS WHERE CÓDIGOARTÍCULO=?";
		
		//Preparar la consulta
		miStatement = miConexion.prepareStatement(consultaSQL);
		
		//Establecer parametros de consulta
		miStatement.setString(1, codArticulo);
		
		//Ejecutar sentencia SQL
		miStatement.execute();
		}finally {
			miStatement.close();
			miConexion.close();
		}
	}
		
}
