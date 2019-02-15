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
		String remitente = "cosmic.keys.emperor@gmail.com";  
		String clave = "Realmadrid13*";    
		
		Properties props = System.getProperties();
		props.put("mail.smtp.host", "smtp.gmail.com"); 
		props.put("mail.smtp.user", remitente);
		props.put("mail.smtp.clave", clave);    
		props.put("mail.smtp.auth", "true");    
		props.put("mail.smtp.starttls.enable", "true"); 
		props.put("mail.smtp.port", "587"); 
	    Session session = Session.getDefaultInstance(props);
	    MimeMessage message = new MimeMessage(session);

			    try {
			        message.setFrom(new InternetAddress(remitente));
			        message.addRecipients(Message.RecipientType.TO, remitente);  
			        message.setSubject(subject);
			        message.setText(messageUser+"\n\n\n"+name+", "+lastName+": "+email);
			        Transport transport = session.getTransport("smtp");
			        transport.connect("smtp.gmail.com", remitente, clave);
			        transport.sendMessage(message, message.getAllRecipients());
			        transport.close();
			        request.setAttribute("mensaje", msj);
					request.getRequestDispatcher("/mensajeContact.jsp").forward(request, response);
			    	}
			    		catch (MessagingException e) {
			    		LOGGER.severe("ERROR: "+e);   
			    	}
			
		}catch(Exception e) {
			
			LOGGER.severe("ERROR: "+e);
			request.setAttribute("mensaje", msj);
			request.getRequestDispatcher("/mensajeContact.jsp").forward(request, response);
			
		}
	}	
}
