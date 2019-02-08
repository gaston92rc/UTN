<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language='java' contentType='text/html;charset=iso-8859-1'%>
<%@ page import='java.util.*' %>
<%@ page import='models.Alquiler' %>
<%@ page import='data.DataAlquiler' %>
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
	  		  <h1 style="font-weight: bold; margin-button:100px;">Registrar Devolución</h1>
	  		  <br><br>
			  <form  action="BajaAlquiler" method="POST" role=form>
				  
				<div class="form-group">
				  	<label>Lista de Alquileres</label><br>
				  	  <%
				  	DataAlquiler data = new DataAlquiler();	
					ArrayList<Alquiler> a;
					a = data.getAlquilerByFechaDevolucion();  
					ArrayList<Alquiler> b=a;
					%>
				  <div class="form-group">
				
					<select name="titulo">
 								<% for(Alquiler alq:a){
 									
 								%>
 									
 									<option value="<%=alq.getId() %>"><%=alq.getPelicula().getTitulo()%></option>
 					
 								<%
 								   }
 								%>     
                    </select>
                    <% for(Alquiler alq:b){%>
                    <br><br>
                    <div class="form-group">
				  		<label>Socio:</label>
				  		<strong><%=alq.getSocio().getUsername()%></strong>
				  	</div>
                    <% }%>
 					
				  </div>
                    <div class="form-group">
				  		<label>Fecha devolución</label>
				  	 	<input type="text" class="form-group" name="fechaDevolucion" placeholder="YYYY/mm/dd">
				  	</div>
				  	
				  </div><br>
				 <button class="btn btn-dark btn-block" type=submit>Registrar</button>
			  </form> <br><br>
			  <p>${mensaje}</p>
			  <a style="text-decoration:none; font-hegiht:10px;" href="ABMCPeliculaSocio.jsp" class="glyphicon"> Volver</a>
			  </div>
 	</div>
 </div>
 
 	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</body>
</html>