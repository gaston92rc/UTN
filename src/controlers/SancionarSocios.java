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
 * Servlet implementation class BajaSancionSocios
 */
@WebServlet("/SancionarSocios")
public class SancionarSocios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER =Logger.getLogger("BajaSancionSocios");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SancionarSocios() {
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
		
		String estado=request.getParameter("estado");
		String usuario=request.getParameter("usuario");
		
		DataSocio data=new DataSocio();
		Socio socio=new Socio(usuario,estado);
		boolean valor = data.altaSancionados(socio);
		
		String msj=null;

		if(!valor){
			
			msj="Se actualizó estado correctamente"; 
			
		}else {
			msj="No se pudo actualizar estado"; 
			LOGGER.severe(msj);
		}
		
		request.setAttribute("mensaje", msj);
	    request.getRequestDispatcher("/SancionarSocio.jsp").forward(request, response);	
	}	


}
