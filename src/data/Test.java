package data;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Test {
   public static void main(String[] args) {
		
		String msj="Error al subscribirse\n\nEl correo ingresado ya está en uso.";

		try {
			
				
			msj="Sucripción satisfactoria.";;
			

			Properties props=new Properties();
			props.setProperty("mail.smtp.host", "smtp.gmail.com");
			props.setProperty("mail.smtp.starttls.enable", "true");
			props.setProperty("mail.smtp.port", "587");
			props.setProperty("mail.smtp.auth", "true");
			
			Session session=Session.getDefaultInstance(props);
			
			String correoRemitente="cosmic.keys.emperor@gmail.com";
			String passwordRemitente="Realmadrid13*";
			String correoReceptor="your.name.be.gloriana@gmail.com";
			String asuntoMensaje="Subcripción añadida correctamente";
			String mensaje="<h1>Recibirá nuevas</h1> notificaciones periódicamente.\n\n Saludos.";
			MimeMessage message=new MimeMessage(session);
			message.setFrom(new InternetAddress(correoRemitente));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
			message.setSubject(asuntoMensaje);
			message.setText(mensaje);
			Transport t=session.getTransport("smtp");
			t.connect(correoRemitente,passwordRemitente);
			t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
			t.close();
			
			
		}catch(AddressException e) {
			
			System.out.println("ERROR 2: "+e);
			
		}
		catch(MessagingException e) {
			
			System.out.println("ERROR 1: "+e);
		}
	}
}