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
 * Servlet implementation class ModificacionAlquiler
 */
@WebServlet({ "/ModificacionAlquiler", "/Modificacionalquiler", "/modificacionAlquiler", "/modificacionalquiler" })
public class ModificacionAlquiler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER=Logger.getLogger("ModificacionAlquiler");   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificacionAlquiler() {
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
		String importePorDia=request.getParameter("monto");
		DataAlquiler dp=new DataAlquiler();
		
		if(importePorDia!=null) {
		Alquiler a=new Alquiler(Double.parseDouble(importePorDia));
		boolean b=dp.actualizarAlquiler(a);	
		String msj=null;

		if(b){
						
			msj="Se actualizó monto por día"; 
			request.setAttribute("mensaje", msj);
		    request.getRequestDispatcher("ModificarAlquiler.jsp").forward(request, response);
			
		}else{
			msj="No se pudo actualizar monto por día"; 
			LOGGER.warning(msj);
			request.setAttribute("mensaje", msj);
		    request.getRequestDispatcher("ModificarAlquiler.jsp").forward(request, response);
		}}else {
			String msj="No se pudo actualizar monto por día"; 
			LOGGER.warning(msj);
			request.setAttribute("mensaje", msj);
		    request.getRequestDispatcher("ModificarAlquiler.jsp").forward(request, response);
		}
			

	}

}
