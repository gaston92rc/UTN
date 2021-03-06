package controlers;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DataPelicula;
import data.FactoryConnection;
import models.Genero;
import models.Pelicula;

/**
 * Servlet implementation class AltaPelicula
 */
@WebServlet({ "/ActualizarPeliculas", "/actualizarPeliculas", "/Actualizarpeliculas", "/actualizarpeliculas" })
public class ActualizarPeliculas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER=Logger.getLogger("DataPelicula");
  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarPeliculas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	   //doGet(request, response);
		String titulo=request.getParameter("titulo");
		String descripcion=request.getParameter("descripcion");
		String duracion=request.getParameter("duracion");
		String genero=request.getParameter("genero");
		String imagen=request.getParameter("imagen");
		String anio=request.getParameter("anio");
		String trailer=request.getParameter("trailer");
		String pais=request.getParameter("pais");
		String detalle=request.getParameter("detalle");
		String img=imagen.substring(42, imagen.length());
		
		Genero g=new Genero(Integer.parseInt(genero));
		DataPelicula dp=new DataPelicula();
		String t=dp.getPeliculaById(Integer.parseInt(titulo));
		Pelicula p=new Pelicula(t,descripcion,duracion,g,img,Integer.parseInt(anio),detalle,trailer, pais);
		
		boolean b=dp.actualizarPelicula(p);		
		String msj=null;

		if(b){
			
			
			msj="Se actualiz� pel�cula correctamente"; 
			
		}else {
			msj="No se pudo actualizar pel�cula"; 
			LOGGER.warning(msj);
		}
		
		request.setAttribute("mensaje", msj);
	    request.getRequestDispatcher("/ModificarPelicula.jsp").forward(request, response);	
	}	


}
