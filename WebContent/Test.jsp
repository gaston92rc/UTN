<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language='java' contentType='text/html;charset=iso-8859-1'%>
<%@ page import='java.util.*' %>
<%@ page import='models.Genero' %>
<%@ page import='models.Pelicula' %>
<%@ page import='data.DataGenero' %>
<%@ page import='data.DataPelicula' %>
<!DOCTYPE html>
<html lang="es">
<head> 
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">    
    <title>AMBC Peliculas Administrador</title>
</head>
<body>

 <% 
			    	    int i=1;
			    	    DataPelicula dataPel= new DataPelicula();
			        	ArrayList<Pelicula> p;
						p = dataPel.getAll(); 
			            
						for(Pelicula pel: p){
						
			        %>
  
<a target='_blank' href="<%= request.getContextPath()%>/images/<%= pel.getImagen() %>"><img src="<%= request.getContextPath()%>/images/<%= pel.getImagen() %>" /></a></td>
  <% }
	   			      %>
</body>
</html>