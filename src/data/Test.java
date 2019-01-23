package data;


import java.util.ArrayList;
import java.util.List;

import models.Genero;
import models.Pelicula;
import models.Socio;


public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DataSocio data= new DataSocio();
		ArrayList<Socio> s= data.getSancionado();
		
		for(Socio soc: s) {
			
			System.out.println(soc.toString()+" \n "+soc.getTarjeta().toString());

			
		}		
	} 

}
