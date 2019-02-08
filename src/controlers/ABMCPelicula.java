package controlers;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DataPelicula;
import models.Genero;
import models.Pelicula;

/**
 * Servlet implementation class ABMCPelicula
 */
@WebServlet({ "/ABMCPelicula", "/abmcpelicula", "/ABMCpelicula" })
public class ABMCPelicula extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = Logger.getLogger("ABMCPelicula");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ABMCPelicula() {
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
		String pais=request.getParameter("pais");
		String trailer=request.getParameter("trailer");
		String detalle=request.getParameter("detalle");
		
		String img=imagen.substring(42, imagen.length()); //57-76
		DataPelicula dp=new DataPelicula();
		String msj=null;
		System.out.println("ESte "+img);

		if(!genero.equals("Elegir...") && !titulo.isEmpty() && !descripcion.isEmpty() && !duracion.isEmpty()) {
			
			Genero gen=new Genero(Integer.parseInt(genero));		
			Pelicula pelicula=new Pelicula(titulo, descripcion, duracion, gen, img,Integer.parseInt(anio),detalle,trailer,pais);
			msj="Se añadió película correctamente";
			dp.altaPelicula(pelicula);		
			
		}else {
			msj="No se pudo añadir película"; 
			LOGGER.warning(msj);
		}
		
		request.setAttribute("mensaje", msj);
	    request.getRequestDispatcher("/AltaPelicula.jsp").forward(request, response);	
	}	

}
