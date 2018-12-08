package data;


import java.util.List;

import models.Genero;
import models.Pelicula;


public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DataPelicula data= new DataPelicula();
		Genero g=new Genero();
		
		Pelicula p=new Pelicula("aaaaa","aaaa","aaaa",g);
		data.altaPelicula(p);
		boolean  lista= data.eliminarPelicula(p); 
		
			
			System.out.println(lista);
		
	} 

}
