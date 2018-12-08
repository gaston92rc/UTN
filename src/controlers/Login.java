package controlers;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DataSocio;
import models.Socio;

/**
 * Servlet implementation class Login
 */
@WebServlet({ "/Login", "/login", "/LOGIN", "/lOGIN" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger("Login");  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		String usuario = request.getParameter("Username");
		String password = request.getParameter("Password");
		
		HttpSession session=request.getSession();
		DataSocio ds=new DataSocio();
		Socio socio=ds.login(usuario, password);
		//Si devuelve null, entonces idSocio=0.
		String msj="";
				if(socio.getIdSocio()>0 && socio.getTarjeta().getId()==1) {
					session.setAttribute("admin", socio);
					LOGGER.info(socio.getUsername());
					//msj="Bienvenido "+ socio.getUsername();
		           request.getRequestDispatcher("/mensajeLoginAdmin.jsp").forward(request, response);					
				}else if(socio.getIdSocio()>0 && socio.getRol().equals("socio")) {
					session.setAttribute("socio", socio);
					LOGGER.info(socio.getUsername());
					//msj="Bienvenido "+ socio.getUsername();
				    request.getRequestDispatcher("/mensajeLoginSocio.jsp").forward(request, response);
				}else {
					msj="Usuario y/o clave incorrecto/s"; 
					LOGGER.warning(msj);
				    request.setAttribute("mensaje", msj);
				    request.getRequestDispatcher("/mensajeRegister.jsp").forward(request, response);
				}
				
	        }catch(Exception e) {
	        	   LOGGER.severe("ERROR: "+e);
	        }
	}
}
