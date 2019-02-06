
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import='models.Genero' %>
<%@ page import='models.Tarjeta' %>
<%@ page import='models.Pelicula' %>
<%@ page import='data.DataGenero' %>
<%@ page import='data.DataPelicula' %>
<%@ page import='data.DataTarjeta' %>
<%@ page import='java.util.*' %>
<!DOCTYPE html>
<html lang="es">
<head>
<title>One Movies an Entertainment Category Flat Bootstrap Responsive Website Template | Home :: w3layouts</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
 <meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="One Movies Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="css/contactstyle.css" type="text/css" media="all" />
<link rel="stylesheet" href="css/faqstyle.css" type="text/css" media="all" />
<link href="css/single.css" rel='stylesheet' type='text/css' />
<link href="css/medile.css" rel='stylesheet' type='text/css' />
<!-- banner-slider -->
<link href="css/jquery.slidey.min.css" rel="stylesheet">
<!-- //banner-slider -->
<!-- pop-up -->
<link href="css/popuo-box.css" rel="stylesheet" type="text/css" media="all" />
<!-- //pop-up -->
<!-- font-awesome icons -->
<link rel="stylesheet" href="css/font-awesome.min.css" />
<!-- //font-awesome icons -->
<!-- js -->
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<!-- //js -->
<!-- banner-bottom-plugin -->
<link href="css/owl.carousel.css" rel="stylesheet" type="text/css" media="all">
<script src="js/owl.carousel.js"></script>
<script>
	$(document).ready(function() { 
		$("#owl-demo").owlCarousel({
	 
		  autoPlay: 3000, //Set AutoPlay to 3 seconds
	 
		  items : 5,
		  itemsDesktop : [640,4],
		  itemsDesktopSmall : [414,3]
	 
		});
	 
	}); 
</script> 
<!-- //banner-bottom-plugin -->
<link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,700italic,700,400italic,300italic,300' rel='stylesheet' type='text/css'>
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
<!-- start-smoth-scrolling -->
</head>
	
<body>
<!-- header -->
	<% 
			String link;
			if((request.getSession(false).getAttribute("admin")== null) ){
				link="IndexSocio.jsp";
			}else{
				link="IndexAdmin.jsp";
			}
	%>
	<div class="header">
		<div class="container">
			<div class="w3layouts_logo">
				<a href="<%=link%>"><h1>One<span>Movies</span></h1></a>
			</div>
			<div class="w3_search">
				<form action="ResultadoBusquedaGeneral.jsp">
					<input type="text" name="buscar" placeholder="Buscar" required="">
					<input type="submit" value="Ir">
				</form>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
<!-- //header -->
    
	<script>
		$('.toggle').click(function(){
		  // Switches the Icon
		  $(this).children('i').toggleClass('fa-pencil');
		  // Switches the forms  
		  $('.form').animate({
			height: "toggle",
			'padding-top': 'toggle',
			'padding-bottom': 'toggle',
			opacity: "toggle"
		  }, "slow");
		});
	</script>
<!-- //bootstrap-pop-up -->
<!-- nav -->
<div class="movies_nav">
		<div class="container">
			<nav class="navbar navbar-default">
				<div class="navbar-header navbar-left">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
					<nav>
						<ul class="nav navbar-nav">
							<li class="active"><a href="<%=link%>">Inicio</a></li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">Generos <b class="caret"></b></a>
								<ul class="dropdown-menu multi-column columns-3">
									<li>
									
									 <% 
										    	DataGenero dataGen= new DataGenero();
										        ArrayList<Genero> g;
												g = dataGen.getAll(); 
										            
												for(Genero gen: g){
													
									 %>
									<div class="col-sm-4">
										<ul class="multi-column-dropdown">
											<li><a href="ListaPeliculas.jsp"><%=gen.getDenominacion().substring(0,1).toUpperCase() +  gen.getDenominacion().substring(1) %></a></li>
										</ul>
									</div>
									<% }
	   								%>
									<div class="clearfix"></div>
									</li>
								</ul>
							</li>
							<li><a href="ListaPeliculas.jsp">Nuevas</a></li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">Pais <b class="caret"></b></a>
								<ul class="dropdown-menu multi-column columns-3">
									<li>
									<% 
							 			DataPelicula dataPel= new DataPelicula();
							 			ArrayList<Pelicula> p0;
										p0 = dataPel.getByPaisPelicula(); 
								            
										for(Pelicula pel0: p0){
										
						 			%>
										<div class="col-sm-4">
											<ul class="multi-column-dropdown">
												<li><a href="ListaPeliculas.jsp"> <%=   pel0.getPais().substring(0,1).toUpperCase() +   pel0.getPais().substring(1) %></a></li>
											</ul>
										</div>
										<% }
	   									%>
										<div class="clearfix"></div>
									</li>
								</ul>
							</li>
							<li><a href="list.jsp">Lista A - z</a></li>
							<li><a href="contact.jsp">Contacto</a></li>
						</ul>
					</nav>
				</div>
			</nav>	
		</div>
	</div>
<!-- //nav -->
<!-- banner -->
	<% 
		String busqueda=request.getParameter("buscar");	
		ArrayList<Pelicula> lista=null;
		DataPelicula dp=new DataPelicula();
		lista=dp.getByQuery(busqueda);
		int i=1;
	if(lista.size()!=0){
		for(Pelicula p: lista){	
 %>
  		<br><br>
		<table class="table table-striped">
		  <tbody>
		  	<tr>
		  		<th scope="row"></th>
		  		<p style="padding:0 20px;"> Resultados: <%=lista.size()%></p>
		  	</tr>
		  	<tr>
		      <th scope="row"><%=i++%></th>
		      <td><strong><%=p.getTitulo()%></strong></td>
		    </tr>
		    <tr>
		      <th scope="row"></th>
		      <td><a href="single.jsp"><img src="<%= request.getContextPath()%>/images/<%= p.getImagen() %>" alt=" "></a></td>
		    </tr>
		     <tr>
		      <th scope="row"></th>
		      <td>Duracion: <%=p.getDuracion() %></td>
		    </tr>
		    <tr>
		      <th scope="row"></th>
		      <td><%=p.getDescripcion() %></td>
		    </tr>	
		  </tbody>
		</table>
		<%}%>
		<%}else{%>
			<br><br>
			<h4 style="text-align:center;">No se han encontrado resultados.</h4>
			<br><br>
		<%}%>
  

<!-- footer -->
<div class="footer">
		<div class="container">
			<div class="w3ls_footer_grid">
				<div class="col-md-6 w3ls_footer_grid_left">
					<div class="w3ls_footer_grid_left1">
						<h2>Subscribirse</h2>
						<div class="w3ls_footer_grid_left1_pos">
							<form action="Subscripcion" method="post">
								<input type="email" name="subscripcion" placeholder="Tu email..." required="">
								<input type="submit" value="Enviar">
							</form>
						</div>
					</div>
				</div>
				<div class="col-md-6 w3ls_footer_grid_right">
					<a href="<%=link%>"><h2>One<span>Movies</span></h2></a>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="col-md-5 w3ls_footer_grid1_left">
				<p>&copy; 2016 One Movies. All rights reserved | Design by <a href="http://w3layouts.com/">W3layouts</a></p>
			</div>
			<div class="col-md-7 w3ls_footer_grid1_right">
				<ul>
					<li>
						<a href="ListaPeliculas.jsp">Peliculas</a>
					</li>
					<li>
						<a href="ListaPeliculas.jsp">Horror</a>
					</li>
					<li>
						<a href="ListaPeliculas.jsp">Aventura</a>
					</li>
					<li>
						<a href="ListaPeliculas.jsp">Comedia</a>
					</li>
					<li>
						<a href="contact.jsp">Contacto</a>
					</li>
				</ul>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
<!-- //footer -->
<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>
<script>
$(document).ready(function(){
    $(".dropdown").hover(            
        function() {
            $('.dropdown-menu', this).stop( true, true ).slideDown("fast");
            $(this).toggleClass('open');        
        },
        function() {
            $('.dropdown-menu', this).stop( true, true ).slideUp("fast");
            $(this).toggleClass('open');       
        }
    );
});
</script>
<!-- //Bootstrap Core JavaScript -->
<!-- here stars scrolling icon -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
			*/
								
			$().UItoTop({ easingType: 'easeOutQuart' });
								
			});
	</script>
<!-- //here ends scrolling icon -->
</body>
</html>