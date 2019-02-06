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
		String usuario = request.getParameter("Username");
		String password = request.getParameter("Password"); 
		Socio s=new Socio();
		s.setUsername(usuario);
		s.setPassword(password);
		DataSocio ds=new DataSocio();
		String validacion=ds.login(s);
		System.out.println("ES "+validacion);
		try{
		 
		 if(validacion.equalsIgnoreCase("admin")){
		 
			 HttpSession session = request.getSession(); 
			 session.setAttribute("admin", usuario); 
			 request.setAttribute("nombreUsuario", usuario);
			 request.getRequestDispatcher("/IndexAdmin.jsp").forward(request, response);
		 }else if(validacion.equalsIgnoreCase("socio")){
		 
			 HttpSession session = request.getSession();
			 session.setMaxInactiveInterval(600); //10 minutos
			 session.setAttribute("socio", usuario);
			 request.setAttribute("nombreUsuario", usuario);
			 request.getRequestDispatcher("/IndexSocio.jsp").forward(request, response);
		 }
		 else{
			 request.setAttribute("error", validacion); 
			 request.getRequestDispatcher("/Index.jsp").forward(request, response);
		 }
		 }catch(Exception e) {
		  	   LOGGER.severe("ERROR: "+e);
		  }
		}

}
