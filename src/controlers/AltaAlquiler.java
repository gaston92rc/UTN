package controlers;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DataAlquiler;
import models.Alquiler;

/**
 * Servlet implementation class AltaAlquiler
 */
@WebServlet({ "/AltaAlquiler", "/altaalquiler", "/altaAlquiler", "/Altaalquiler" })
public class AltaAlquiler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = Logger.getLogger("AltaAlquiler");
  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaAlquiler() {
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
		String alquiler=request.getParameter("alquiler");
		String estado=request.getParameter("estado");
		

			Alquiler a=new Alquiler();
			a.setEstado(estado);
			a.setId(Integer.parseInt(alquiler));
			String msj=null;
			DataAlquiler data= new DataAlquiler();
			System.out.println("ME da "+a.getEstado()+" "+a.getEstado());
			boolean valor=data.actualizarEstadoAlquiler(a);
			
			if(valor) {
				msj="Se actualizó estado correctamente";
			}else {
				msj="No se pudo actualizar estado"; 
				LOGGER.warning(msj);
			}
			request.setAttribute("mensaje", msj);
		    request.getRequestDispatcher("/AltaAlquiler.jsp").forward(request, response);
			}
			

}
