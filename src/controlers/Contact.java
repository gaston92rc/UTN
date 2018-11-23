package controlers;

import java.io.IOException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import java.util.Properties;
import java.util.logging.Logger;


/**
 * Servlet implementation class Contact
 */
@WebServlet({ "/Contact", "/contact", "/CONTACT" })
public class Contact extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER=Logger.getLogger("Contact");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contact() {
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
		String msj="Mensaje enviado correctamente";
		String msjError="No se pudo enviar el mensaje";

		try {
			String name=request.getParameter("nombre");
			String lastName=request.getParameter("apellido");
		    String email=request.getParameter("correo");
			String subject=request.getParameter("asunto");
			String messageUser=request.getParameter("mensaje");

			Properties props=new Properties();
			props.setProperty("mail.smtp.host", "smtp.gmail.com");
			props.setProperty("mail.smtp.starttls.enable", "true");
			props.setProperty("mail.smtp.port", "587");
			props.setProperty("mail.smtp.auth", "true");
			
			Session session=Session.getDefaultInstance(props);
			
			String correoRemitente="cosmic.keys.emperor@gmail.com";
			String passwordRemitente="Realmadrid13*";
			String correoReceptor=email;
			String asuntoMensaje=subject;
			String mensaje=messageUser;
			MimeMessage message=new MimeMessage(session);
			message.setFrom(new InternetAddress(correoRemitente));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
			message.setSubject(asuntoMensaje);
			message.setText(mensaje);
			Transport t=session.getTransport("smtp");
			t.connect(correoRemitente,passwordRemitente);
			t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
			t.close();

			request.setAttribute("mensaje", msj);
			request.getRequestDispatcher("/mensajeContact.jsp").forward(request, response);
			
			
			
		}catch(AddressException e) {
			
			LOGGER.severe("ERROR: "+e);
			request.setAttribute("mensaje", msjError);
			request.getRequestDispatcher("/mensajeContact.jsp").forward(request, response);
			
		}
		catch(MessagingException e) {
			
			LOGGER.severe("ERROR: "+e);
			request.setAttribute("mensaje", msjError);
			request.getRequestDispatcher("/mensajeContact.jsp").forward(request, response);
		}
	}

}
