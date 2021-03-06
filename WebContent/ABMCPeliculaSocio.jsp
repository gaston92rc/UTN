<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language='java' contentType='text/html;charset=iso-8859-1'%>
<%@ page import='java.util.*' %>
<%@ page import='models.Genero' %>
<%@ page import='models.Pelicula' %>
<%@ page import='models.Socio' %>
<%@ page import='models.Tarjeta' %>
<%@ page import='data.DataGenero' %>
<%@ page import='data.DataPelicula' %>
<%@ page import='data.DataSocio' %>
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
			  </form>
			  </div>
			   <div class="col-sm-8" style="margin:auto">
			   <h1 style="font-weight: bold; margin-button:100px;"> Películas</h1>
			    <table class="table">
			        <tbody>
			       
			          <tr>
			    	    <td>
			    	      <p style="font-weight:bold;"></p><a href="AltaPelicula.jsp" class="btn btn-primary" role="button" name="actualizar">Alta</a>
			    	       <a href="BajaPelicula.jsp" class="btn btn-danger" role="button" name="baja">Baja</a>
				    	  <a href="ModificarPelicula.jsp" class="btn btn-success" role="button" name="actualizar">Modificación</a>
				    	  <a href="ConsultarPelicula.jsp" class="btn btn-info" role="button" name="baja">Consulta</a>
			    	  </td>
			    	  </tr>
	   			      
	   			     
			        </tbody>
			    </table>
			  </div>
			  
 		
 	</div>
 </div>
 
   
  <div class="container" style="padding-top:20px; padding-bottom:20px;">

  	<div class="row">
			  </form>
			  </div>
			   <div class="col-sm-8" style="margin:auto">
			   <h1 style="font-weight: bold; margin-button:100px;"> Socios</h1>
			    <table class="table">
			        <tbody>		     
			          <tr>
			    	    <td>
			    	      <p style="font-weight:bold;"></p><a href="AltaSocio.jsp" class="btn btn-primary" role="button" name="actualizar">Alta</a>
			    	      <a href="BajaSocio.jsp" class="btn btn-danger" role="button" name="baja">Baja</a>
				    	  <a href="SancionarSocio.jsp" class="btn btn-success" role="button" name="actualizar">Modificación</a>
				    	  <a href="ConsultarSocio.jsp" class="btn btn-info" role="button" name="consultar">Consulta</a>
			    	  </td>
			    	  </tr>
			        </tbody>
			    </table>
			  </div>
 	</div>
 </div>
 
 <div class="container" style="padding-top:20px; padding-bottom:20px;">

  	<div class="row">
			  </form>
			  </div>
			   <div class="col-sm-8" style="margin:auto">
			   <h1 style="font-weight: bold; margin-button:100px;"> Alquiler</h1>
			    <table class="table">
			        <tbody>		     
			          <tr>
			    	    <td>
			    	      <p style="font-weight:bold;"></p><a href="AltaAlquiler.jsp" class="btn btn-primary" role="button" name="actualizar">Alta estado</a>
			    	      <a href="BajaAlquiler.jsp" class="btn btn-danger" role="button" name="baja">Baja</a>
				    	  <a href="ModificarAlquiler.jsp" class="btn btn-success" role="button" name="actualizar">Modificación</a>
				    	  <a href="ConsultarAlquiler.jsp" class="btn btn-info" role="button" name="consultar">Consulta</a>
			    	  </td>
			    	  </tr>
			        </tbody>			        
			    </table>
			    			        			   <a style="text-decoration:none; font-hegiht:10px; text-align:center;" href="IndexAdmin.jsp" class="glyphicon"> Volver</a>
			    
			  </div>
			</div>
 </div>

 
 
 	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</body>
</html>