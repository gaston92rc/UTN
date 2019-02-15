package controlers;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DataAlquiler;
import data.DataPelicula;
import data.DataSocio;
import data.DataTarjeta;
import models.Alquiler;
import models.Pelicula;
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
		
		java.util.Date fecha=new java.util.Date();
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
        String fechaAlquiler = DATE_FORMAT.format(fecha);
		String titulo=request.getParameter("titulo");
		String username=request.getParameter("username");
		System.out.println("usuaruio es "+username +" y "+tarjeta+" y  "+fechaAlquiler+" y "+titulo);
		
		Tarjeta t=null;
		Socio s=null;
		Alquiler a=null;
		Pelicula p=null;
		String msj=null;
		DataTarjeta dataT= new DataTarjeta();
		DataSocio dataS= new DataSocio();
		DataAlquiler dataA= new DataAlquiler();
        DataPelicula dataP=new DataPelicula();
		if(tarjeta.equals("Elegir...")) {
			msj="No se pudo añadir película a alquileres.";
			request.setAttribute("mensaje", msj);
		    request.getRequestDispatcher("/AlquilerRespuesta.jsp").forward(request, response);			
		}else{
			try {
				p=dataP.getByTitulo(titulo);
				s=dataS.getSocioByNombreUsuario(username);
				t=dataT.getById(Integer.parseInt(tarjeta));
				s.setTarjeta(t);
				dataA.altaAlquiler(p.getId(), s.getIdSocio(), titulo, Date.valueOf(fechaAlquiler), "activo");
				
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
