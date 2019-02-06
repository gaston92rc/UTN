package controlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.logging.Logger;

import data.DataSocio;
import models.Socio;
import models.Tarjeta;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger("Register");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		
		try {
		String nombre=request.getParameter("Name");
	    String apellido=request.getParameter("LastName");
	    String correo=request.getParameter("Email");
		String usuario=request.getParameter("Username");
	    String password=request.getParameter("Password");
	    Tarjeta tarjeta = new Tarjeta();
	    tarjeta.setIdTarjeta(1);
	    
	    Socio socio=new Socio(usuario.toLowerCase(), password, apellido, nombre, "activo", correo,"socio",tarjeta, 0);
	    
	    DataSocio ds = new DataSocio();
	    String validacion=ds.register(socio);;
	    
	    if(validacion.equalsIgnoreCase("ok")) {
	    	HttpSession session = request.getSession();
			session.setMaxInactiveInterval(600); //10 minutos
			session.setAttribute("socio", usuario);
			request.setAttribute("nombreUsuario", usuario);
			request.getRequestDispatcher("/IndexSocio.jsp").forward(request, response);
	    }else {
	    	 request.setAttribute("error", validacion); 
			 request.getRequestDispatcher("/Index.jsp").forward(request, response);
	    }
	    
	    
		
		}catch(Exception e) {
			LOGGER.severe("ERROR: "+e);
		}
	    
	}

}
