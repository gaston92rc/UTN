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
 * Servlet implementation class BajaSocios
 */
@WebServlet("/BajaSocios")
public class BajaSocios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER=Logger.getLogger("BajaSocios");
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BajaSocios() {
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
		String IdUsuario=request.getParameter("usuario");
		System.out.println("ES "+IdUsuario);
		DataSocio ds=new DataSocio();
		Socio s=new Socio(Integer.parseInt(IdUsuario));
		
		boolean b=ds.eliminarSocio(s);		
		String msj=null;

		if(b){
						
			msj="Se eliminó socio correctamente"; 
			
		}else {
			msj="No se pudo eliminar socio"; 
			LOGGER.severe(msj);
		}
		
		request.setAttribute("mensaje", msj);
	    request.getRequestDispatcher("/BajaSocio.jsp").forward(request, response);	
	}	

}
