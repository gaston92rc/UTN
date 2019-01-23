package controlers;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DataSocio;
import models.Socio;

/**
 * Servlet implementation class ABMCSocio
 */
@WebServlet({ "/ABMCSocio", "/abmcsocio", "/ABMCSOCIO" })
public class ABMCSocio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = Logger.getLogger("ABMCSocio");

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ABMCSocio() {
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
		String id=request.getParameter("id");
		String estado=request.getParameter("estado");
		
		DataSocio data=new DataSocio();
		int in=Integer.parseInt(id);
		Socio socio=new Socio(in,estado);
		boolean valor = data.altaSancionados(socio);
		
		String msj=null;

		if(valor){
			
			
			msj="Se actualizó estado correctamente"; 
			
		}else {
			msj="No se pudo actualizar estado"; 
			LOGGER.severe(msj);
		}
		
		request.setAttribute("mensaje", msj);
	    request.getRequestDispatcher("/AltaSocio.jsp").forward(request, response);	
	}	


}
