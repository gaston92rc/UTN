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
  	
			  </form>
			  </div>
			   <div class="col-sm-8" style="margin:auto">
			   <h1 style="font-weight: bold; margin-button:100px;">Lista de socios</h1>
			   <hr>
	  		   <br><br>
			    <table class="table">
			    	<thead>
			    	  <tr>
			    	    <th>Nombre</th>
			    	    <th>Apellido</th>
			    	    <th>Usuario</th>
			    	    <th>Contraseña</th>
			    	    <th>E-mail</th>
			    	    <th>Estado</th>
			    	    <th>Tarjeta</th>
			    	  </tr>
			    	</thead>
			        <tbody>
			        <% DataSocio dataSoc= new DataSocio();
			        	ArrayList<Socio> s;
						s = dataSoc.getAll(); 
			            
						
						for(Socio sol: s){
							if(!sol.getRol().equals("admin")){	
			        %>
			          <tr>
			    	    <td><%= sol.getNombre() %></td>
			    	    <td><%= sol.getApellido() %></td>
			    	    <td><%= sol.getUsername() %></td>
			    	    <td><%= sol.getPassword() %></td>
			    	    <td><%= sol.getMail() %></td>
			    	    <td><%= sol.getEstado() %></td>
			    	    <td><%= sol.getTarjeta().getNombre() %></td>
			    	  </tr>
			    	  	<% }
						}
	   			      %>
	   			      <p>${mensaje}</p>
			        </tbody>
			    </table>
			    <a style="text-decoration:none; font-hegiht:10px;" href="ABMCPeliculaSocio.jsp" class="glyphicon"> Volver</a>
			    
			  </div>
			  
 		
 	</div>
 </div>
 
 	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</body>
</html>
