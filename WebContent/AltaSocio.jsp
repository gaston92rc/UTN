<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language='java' contentType='text/html;charset=iso-8859-1'%>
<%@ page import='java.util.*' %>
<%@ page import='models.Tarjeta' %>
<%@ page import='models.Socio' %>
<%@ page import='data.DataSocio' %>
<!DOCTYPE html>
<html lang="es">
<head> 
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">    
    <title>AMBC Socio Administrador</title>
</head>
<body>
  
  <div class="container" style="padding-top:20px; padding-bottom:20px;">

  	<div class="row">
	  	<div class="col-sm-4" style="margin:auto;">
	  		  <h1 style="font-weight: bold; margin-button:100px;">Alta sancionados</h1>
	  		   <hr>
	  		  <br><br>
			  <form  action="ABMCSocio" method="POST" role=form id="formulario">			  
				  
				  <%
				    DataSocio data = new DataSocio();	
					ArrayList<Socio> s;
					s = data.getSancionado();  
					
					%>
				  <div class="form-group">
				  	<label>Usuarios sancionados</label><br>
				  			

					<select name="id">
                            <option>Elegir...
 								<% for(Socio soc:s){
 									  
 									  if(!soc.getRol().equals("admin") && soc.getEstado().equalsIgnoreCase("sancionado")){
 								 %>
 									
 									<option value= "<%= soc.getIdSocio() %>"><%= soc.getUsername() %></option>
 								<%
 								    }}
 								%>     
                    </select>
				  
				  </div>
				  
				  <div class="form-group">
				  	<label>Estado usuario</label><br>
				  	 <input type="text" class="form-group" id="estado" name="estado" value="activo">
				  </div>
				 
				 <button class="btn btn-dark btn-block" type=submit name="sancionar">Alta</button>
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