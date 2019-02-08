<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language='java' contentType='text/html;charset=iso-8859-1'%>
<%@ page import='java.util.*' %>
<%@ page import='java.sql.Date ' %>
<%@ page import='java.text.SimpleDateFormat' %>
<%@ page import='models.Genero' %>
<%@ page import='models.Tarjeta' %>
<%@ page import='models.Pelicula' %>
<%@ page import='data.DataGenero' %>
<%@ page import='data.DataPelicula' %>
<%@ page import='data.DataTarjeta' %>
<!DOCTYPE html>
<html lang="es">
<head>
<title>One Movies an Entertainment Category Flat Bootstrap Responsive Website Template | Home :: w3layouts</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
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

<script>
	$(document).ready(function() { 
		$("#owl-demo1").owlCarousel({
	 
		  autoPlay: 3000, //Set AutoPlay to 3 seconds
	 
		  items : 5,
		  itemsDesktop : [640,4],
		  itemsDesktopSmall : [414,3]
	 
		});
	 
	}); 
</script>

<script>
	$(document).ready(function() { 
		$("#owl-demo2").owlCarousel({
	 
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
	<div class="header">
		<div class="container">
			<div class="w3layouts_logo">
				<a href="IndexSocio.jsp"><h1>One<span>Movies</span></h1></a>
			</div>
			<div class="w3_search">
			<% 
			if((request.getSession(false).getAttribute("socio")== null) )
			{
			%>
			<jsp:forward page="/LoginParaAlquilar.jsp"></jsp:forward>
			<%} %>
			
				<form action="Busqueda" method="post">
					<input type="text" name="buscar" placeholder="Buscar" required="">
					<input type="submit" value="Ir">
				</form>
				
				<div class="w3l_sign_in_register">
					<ul>
						<li><a href="PeliculasSocios.jsp" style="text-align:center;" name="AdminPeliculas">Mis peliculas</a></li><a href="<%=request.getContextPath()%>/SalirController">Salir</a><br><br>				
					</ul>
				</div>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
<!-- //header -->
<!-- bootstrap-pop-up -->

    
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
							<li class="active"><a href="IndexSocio.jsp">Inicio</a></li>
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
<div class="general_social_icons">
	<nav class="social">
		<ul>
			<li class="w3_twitter"><a href="#">Twitter <i class="fa fa-twitter"></i></a></li>
			<li class="w3_facebook"><a href="#">Facebook <i class="fa fa-facebook"></i></a></li>
			<li class="w3_dribbble"><a href="#">Dribbble <i class="fa fa-dribbble"></i></a></li>
			<li class="w3_g_plus"><a href="#">Google+ <i class="fa fa-google-plus"></i></a></li>				  
		</ul>
  </nav>
</div>
<!-- single -->
<div class="single-page-agile-main">
<div class="container">
		<!-- /w3l-medile-movies-grids -->
			<div class="agileits-single-top">
				<ol class="breadcrumb">
				  <li><a href="IndexSocio.jsp">Inicio</a></li>
				  <li class="active">Single</li>
				</ol>
			</div>
			<div class="single-page-agile-info">
                   <!-- /movie-browse-agile -->
                           <div class="show-top-grids-w3lagile">
				<div class="col-sm-8 single-left">
					<div class="song">
						<div class="song-info">
						<%
						String titulo = request.getParameter("titulo");
					    DataPelicula dataP = new DataPelicula();	
						Pelicula p;
						p = dataP.getByTitulo(titulo);  

						
						%>
					</div>
						<h3><strong><%=p.getTitulo() %></strong></h3><br>
							<div class="embed-responsive embed-responsive-16by9">
 								 <iframe class="embed-responsive-item" src="<%=p.getTrailer() %>" allowfullscreen></iframe>
							</div>
 
					</div>

					<div class="all-comments">
						<div class="all-comments-info">
							<a href="#">Alquiler</a>
							<div class="agile-info-wthree-box">
								<form action="AlquilerController" method="POST">
									<%
									    DataTarjeta data = new DataTarjeta();	
										ArrayList<Tarjeta> t;
										t = data.getAll();  
										String username = request.getParameter("username");
										%>
									  <img src="images/tarjetas.jpg" style="width:30%; height: 30%; " alt=""><br><br>
									  <div class="form-group">
									  
									  	Tarjeta <br>
									  			
					
										<select name="tarjeta">
					                            <option>Elegir...
					 								<% for(Tarjeta tar:t){%>
					 									
 													<option value="<%= tar.getId() %>"><%= tar.getNombre() %></option>
					 								<%
					 								    }
					 								%>     
					                    </select>	
					                 </div>	
					                 <%
					                 java.util.Date fecha=new java.util.Date();
								        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM-dd-yyyy");
								        String f = DATE_FORMAT.format(fecha);
					                 
					                 %>	
					                 <br>
					                 Fecha de Alquiler<br>           					   
									<input type="text" disabled value="<%=f %>" name="fechaAlquiler"><br><br>
									<p>Cantidad: 1</p> <br>
									<input type="hidden" name="titulo" value="<%= titulo%>">
									<input type="hidden" name="username" value="<%= username%>">﻿﻿
									<input type="submit" value="Alquilar"><br>  
									<div class="clearfix"> </div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
					
					</div>
				</div>
			</div>
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
					<a href="index.jsp"><h2>One<span>Movies</span></h2></a>
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