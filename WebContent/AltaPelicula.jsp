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
  
  <div class="container" style="padding-top:20px; padding-bottom:20px;">

  	<div class="row">
	  	<div class="col-sm-4" style="margin:auto;">
	  		  <h1 style="font-weight: bold; margin-button:100px;">Alta Pelicula</h1>
	  		   <hr>
	  		  <br><br>
			  <form  action="ABMCPelicula" method="POST" role=form>
				  <div class="form-group">
				  	<label>Título Película</label><br>
				  	 <input type="text" class="form-group" name="titulo">
				  </div>
	
				  <%
				    DataGenero data = new DataGenero();	
					ArrayList<Genero> g;
					g = data.getAll();  
					
					%>
				  <div class="form-group">
				  	<label>Género Película</label><br>
				  			

					<select name="genero">
                            <option>Elegir...
 								<% for(Genero gen:g){%>
 									
 									<option value="<%= gen.getId() %>"><%= gen.getDenominacion() %></option>
 								<%
 								    }
 								%>     
                    </select>
				  
				  </div>
				  
				 <div class="form-group">
				  	<label>Imagen Película</label>
				  	 <input type="file" class="form-group" name="imagen">
				  </div>
				  
				  <div class="form-group">
				  	<label>Descripción Película</label><br>
				  	<textarea class="form-control" style="max-width: 174px;"  id="Textarea" name="descripcion" rows="2"></textarea>
				  </div>
				  
				  <div class="form-group">
				  	<label>Duración Película</label><br>
				  	 <input type="text" class="form-group" name="duracion">
				  </div>
				  
				  <div class="form-group">
				  	<label>Año Película</label><br>
				  	 <input type="text" class="form-group" name="anio">
				  </div>
				  
				   <div class="form-group">
				  	<label>País Película</label><br>
				  	 <input type="text" class="form-group" name="pais">
				  </div>
				  
				   <div class="form-group">
				  	<label>Trailer Película</label><br>
				  	 <input type="text" class="form-group" name="trailer">
				  	 <p>URL de Youtube</p>
				  </div>
				  
				   <div class="form-group">
				  	<label>Detalle Película</label><br>
				  	 <input type="text" class="form-group" name="detalle">
				  	 <p>Principal/popular/"sin detalle"</p>
				  </div>
				 
				 <button class="btn btn-dark btn-block" type=submit>Agregar</button>
				 <br> <br>
				 <p>${mensaje}</p>
				  <a style="text-decoration:none; font-hegiht:10px;" href="ABMCPeliculaSocio.jsp" class="glyphicon"> Volver</a>
			  </div>
			  </form>
			  </div>
 	</div>
 </div>
 
 	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</body>
</html>