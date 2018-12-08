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
 * Servlet implementation class BajaPeliculas
 */
@WebServlet({ "/BajaPeliculas", "/bajapeliculas", "/Bajapeliculas", "/bajaPeliculas" })
public class BajaPeliculas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER=Logger.getLogger("DataPelicula");
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BajaPeliculas() {
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
		
		DataPelicula dp=new DataPelicula();
		Pelicula p=new Pelicula(titulo);
		
		boolean b=dp.eliminarPelicula(p);		
		String msj=null;

		if(b){
						
			msj="Se eliminó película correctamente"; 
			
		}else {
			msj="No se pudo eliminar película"; 
			LOGGER.warning(msj);
		}
		
		request.setAttribute("mensaje", msj);
	    request.getRequestDispatcher("/ABMCPeliculas.jsp").forward(request, response);	
	}	

}
