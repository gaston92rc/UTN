package controlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import data.DataPelicula;
import models.Pelicula;

/**
 * Servlet implementation class Busqueda
 */
@WebServlet({ "/BusquedaAdmin", "/BUSQUEDAADMIN", "/busquedaadmin" })
public class BusquedaAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusquedaAdmin() {
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
		String busqueda=request.getParameter("buscar");
		
		ArrayList<Pelicula> lista=null;
		DataPelicula dp=new DataPelicula();
		lista=dp.getByQuery(busqueda);
		if(busqueda!=null) {
			request.setAttribute("peliculas", lista);
			request.getRequestDispatcher("/ResultadoBusqueda.jsp").forward(request, response);
		}else {
			request.setAttribute("peliculas", lista);
			request.getRequestDispatcher("/ResultadoBusquedaGeneral.jsp").forward(request, response);
		}
		
	}

}
