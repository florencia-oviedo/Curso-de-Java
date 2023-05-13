package com.pildorasinformaticas.productos;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ControladorProductos
 */
@WebServlet("/ControladorProductos")
public class ControladorProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ModeloProductos modeloProductos;
	
	//Definir el dataSource
	@Resource(name="jdbc/Productos")
	private DataSource miPool;
		
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			modeloProductos = new ModeloProductos(miPool); //conexion con el modelo
		}catch(Exception e) {
			
			throw new ServletException(e);
		}
		
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Leer el parametro del formulario
		String elComando = request.getParameter("instruccion");
		
		//Si no se envia el parametro, listar productos
		if(elComando == null) {
			elComando = "listar";
		}
		
		//Redirigir el flujo de ejecucion al metodo adecuado
		switch(elComando) {
		case "listar":
			obtenerProductos(request,response);
			break;
			
		case "insertarBBDD":
			agregarProductos(request,response);
			break;
			
		case "cargar":
			try {
				cargaProductos(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		case "actualizarBBDD":
			try {
				actualizaProductos(request,response);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			break;
		case "eliminar":
			try {
				eliminaProductos(request,response);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			break;
			
		default:
			obtenerProductos(request,response);
		}
		
		
	}


	private void eliminaProductos(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Capturar el cod articulo
		String CodArticulo = request.getParameter("CArticulo");
		
		//Borrar producto de la BBDD
		modeloProductos.eliminarProducto(CodArticulo);
		
		//Volver al listado de producto
		obtenerProductos(request,response);
	}


	private void actualizaProductos(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//Leer los datos que le vienen del formulario actualizar
		String CodArt = request.getParameter("CArt");
		String seccion =request.getParameter("seccion");
		String nombre_articulo =request.getParameter("NArt");
		
		SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = null;
		try {
			fecha = formatofecha.parse(request.getParameter("fecha"));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		double precio = Double.parseDouble( request.getParameter("precio"));
		
		String importado = request.getParameter("importado");
		
		String pais_origen = request.getParameter("POrig");
		
		//Crear un objeto de tipo producto con la info q viene del formulario
		Productos productoActualizado = new Productos(CodArt,seccion,nombre_articulo,precio,fecha,importado,pais_origen);
		
		//actualizar la BBDD con la info objeto producto
		modeloProductos.actualizarProducto(productoActualizado);
		
		//volver al listado con la info actualizada
		obtenerProductos(request,response);
		
	}


	private void cargaProductos(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//Leer el cod articulo que viene del listado
		String codigo_articulo = request.getParameter("CArticulo");
		
		//Enviar cod articulo a modelo
		Productos elProducto = modeloProductos.getProducto(codigo_articulo);
		
		//Colocar atributo correspondiente al cod articulo
		request.setAttribute("productoActualizar", elProducto);
		
		//enviar producto al formulario de actualizar.jsp
		RequestDispatcher miDispatcher = request.getRequestDispatcher("/actualizarProducto.jsp");
		miDispatcher.forward(request, response);
		
	}


	private void agregarProductos(HttpServletRequest request, HttpServletResponse response) {
		//Leer la informacion del producto que viene del formulario
		String cod_articulo = request.getParameter("CArt");
		String seccion =request.getParameter("seccion");
		String nombre_articulo =request.getParameter("NArt");
		
		SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = null;
		try {
			fecha = formatofecha.parse(request.getParameter("fecha"));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		double precio = Double.parseDouble( request.getParameter("precio"));
		
		String importado = request.getParameter("importado");
		
		String pais_origen = request.getParameter("POrig");
		
		//Crear un objeto de tipo Producto
		Productos nuevoProducto = new Productos(cod_articulo,seccion,nombre_articulo,precio,fecha,importado,pais_origen);
		
		//Enviar el objeto al modelo y despues insertar el objeto Producto en la BBDD
		try {
			modeloProductos.agregarNuevoProducto(nuevoProducto);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		//Volver a listar la tabla de Productos
		obtenerProductos(request,response);
	}


	private void obtenerProductos(HttpServletRequest request, HttpServletResponse response) {
		
		
		//obtener la lista de productos desde el modelo
		
		List<Productos> productos;
				
		try {
					
		productos = modeloProductos.getProductos();
				
		// agregar esa lista al request
					
		request.setAttribute("listaProductos", productos);
				
		// enviar ese request a la pagina JSP
					
		RequestDispatcher miDispatcher  =request.getRequestDispatcher("/listaProductos.jsp");
					
		miDispatcher.forward(request, response);
					
		}catch(Exception e) {
					e.printStackTrace();
			}
		}

}
