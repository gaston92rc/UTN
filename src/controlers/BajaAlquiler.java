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
 * Servlet implementation class BajaAlquiler
 */
@WebServlet({ "/BajaAlquiler", "/bajaalquiler", "/bajaAlquiler", "/Bajaalquiler" })
public class BajaAlquiler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER=Logger.getLogger("BajaAlquiler");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BajaAlquiler() {
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
		String fechaDevolucion=request.getParameter("fechaDevolucion");
		DataAlquiler dp=new DataAlquiler();
		System.out.println("fecha es "+fechaDevolucion);
		
		if(!fechaDevolucion.equals("")) {
		Alquiler a=new Alquiler(Integer.parseInt(titulo),fechaDevolucion);
		boolean b=dp.eliminarAlquiler(a);	
		String msj=null;

		if(b){
						
			msj="Se agregó fecha de devolución"; 
			request.setAttribute("mensaje", msj);
		    request.getRequestDispatcher("BajaAlquiler.jsp").forward(request, response);
			
		}else{
			msj="No se pudo agregar fecha de devolución"; 
			LOGGER.warning(msj);
			request.setAttribute("mensaje", msj);
		    request.getRequestDispatcher("BajaAlquiler.jsp").forward(request, response);
		}}else {
			String msj="No se pudo agregar fecha de devolución"; 
			LOGGER.warning(msj);
			request.setAttribute("mensaje", msj);
		    request.getRequestDispatcher("BajaAlquiler.jsp").forward(request, response);
		}
			

	}

}
