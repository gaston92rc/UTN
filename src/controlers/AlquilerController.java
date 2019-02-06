package controlers;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DataSocio;
import data.DataTarjeta;
import models.Socio;
import models.Tarjeta;

/**
 * Servlet implementation class Alquiler
 */
@WebServlet({ "/AlquilerController", "/alquilerController", "/Alquilercontroller", "/ALQUILERCONTROLLER" })
public class AlquilerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER=Logger.getLogger("AlquilerController");
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public AlquilerController() {
    	super();
     
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
		String tarjeta= request.getParameter("tarjeta");
		String fechaAlquiler=request.getParameter("fechaAlquiler");
		String titulo=request.getParameter("titulo");
		String username=request.getParameter("username");
		
		Tarjeta t=null;
		Socio s=null;
		String msj=null;
		DataTarjeta data= new DataTarjeta();
		DataSocio dataS= new DataSocio();
		System.out.println("ES "+ username );
		
		if(tarjeta.equals("Elegir...")) {
			msj="No se pudo añadir película a alquileres.";
			request.setAttribute("mensaje", msj);
		    request.getRequestDispatcher("/AlquilerRespuesta.jsp").forward(request, response);			
		}else{
			try {
				s=dataS.getSocioByNombreUsuario(username);
				s.setTarjeta(t);
				t=data.getById(Integer.parseInt(tarjeta));
				
			} catch (NumberFormatException e) {
				LOGGER.severe("ERROR: "+e);
			} catch (Exception e) {
				LOGGER.severe("ERROR: "+e);
			}
			msj="Muchas Gracias. Si desea deshacer el alquiler dirijase a su perfil."; 
			request.setAttribute("mensaje", msj);
		    request.getRequestDispatcher("/AlquilerRespuesta.jsp").forward(request, response);	
		}
	
	
	}

}
