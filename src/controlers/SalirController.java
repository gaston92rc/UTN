package controlers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SalirController
 */
@WebServlet({ "/SalirController", "/salirController", "/salircontroller" })
public class SalirController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalirController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false); 
		 
		if(session!=null) {
		 session.invalidate();
		 request.setAttribute("error", "Ha cerrado sesión correctamente");
		 RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Index.jsp");
		 requestDispatcher.forward(request, response);
		 System.out.println("Salió correctamente");
		}	
	}
}
