package controlers;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

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

import data.DataSocio;
import models.Socio;

/**
 * Servlet implementation class Subscripcion
 */
@WebServlet({ "/Subscripcion", "/SUBSCRIPCION", "/subscripcion" })
public class Subscripcion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER=Logger.getLogger("Subscripcion");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Subscripcion() {
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
			
		String msj="Error al subscribirse.\n\nEl correo ingresado ya está en uso.";

		try {
			String subscripcion=request.getParameter("subscripcion");
			DataSocio dataSocio=new DataSocio();
			boolean existe=dataSocio.existeSubscripcion(subscripcion);
			
			if(!existe) {
				
			 msj="Subscripción satisfactoria.";
			 
			}
			
			Socio socio=dataSocio.getSocioByEmail(subscripcion);
			socio.setSubscripcion(1);
			if(dataSocio.addSubscripcion(socio)){
		
			    String remitente = "cosmic.keys.emperor@gmail.com";  
			    String clave = "Realmadrid13*";
			    String cuerpo="Le llegarán novedades mensualmente.";
			    String asunto="Subscripción";
			    
			    Properties props = System.getProperties();
			    props.put("mail.smtp.host", "smtp.gmail.com"); 
			    props.put("mail.smtp.user", remitente);
			    props.put("mail.smtp.clave", clave);    
			    props.put("mail.smtp.auth", "true");    
			    props.put("mail.smtp.starttls.enable", "true"); 
			    props.put("mail.smtp.port", "587"); 
			    props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

			    Session session = Session.getDefaultInstance(props);
			    MimeMessage message = new MimeMessage(session);

			    try {
			        message.setFrom(new InternetAddress(remitente));
			        message.addRecipients(Message.RecipientType.TO, subscripcion);  
			        message.setSubject(asunto);
			        message.setText(cuerpo);
			        Transport transport = session.getTransport("smtp");
			        transport.connect("smtp.gmail.com", remitente, clave);
			        transport.sendMessage(message, message.getAllRecipients());
			        transport.close();
			        request.setAttribute("mensaje", msj);
					request.getRequestDispatcher("/mensajeSubscripcion.jsp").forward(request, response);
			    }
			    catch (MessagingException e) {
			    	LOGGER.severe("ERROR: "+e);   
			    }
			}else{
				request.setAttribute("mensaje", msj);
				request.getRequestDispatcher("/mensajeSubscripcion.jsp").forward(request, response);
			}
			
		}catch(Exception e) {
			
			LOGGER.severe("ERROR: "+e);
			request.setAttribute("mensaje", msj);
			request.getRequestDispatcher("/mensajeSubscripcion.jsp").forward(request, response);
			
		}
	}	
}
