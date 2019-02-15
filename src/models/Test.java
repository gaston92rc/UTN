package models;

public class Test {

	public static void main(String[] args) {

		String destinatario =  "alguien@servidor.com"; //A quien le quieres escribir.
	    String asunto = "Correo de prueba enviado desde Java";
	    String cuerpo = "Esta es una prueba de correo...";

	    Emailer.enviarConGMail("your.name.be.gloriana@gmail.com", "asunto boludo", "cuerpo boludo");
	}

}
