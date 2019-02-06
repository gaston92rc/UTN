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
				<form action="Busqueda" method="post">
					<input type="text" name="buscar" placeholder="Buscar" required="">
					<input type="submit" value="Ir"><br><br>
				<% 
					if((request.getSession(false).getAttribute("socio")== null) )
						{
						%>
						<jsp:forward page="Index.jsp"></jsp:forward>
						<%}else if(request.getAttribute("nombreUsuario")!=null){ %>
						<div class="alert alert-success alert-dismissible">
    						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    						Bienvenido <strong><%=request.getAttribute("nombreUsuario") %></strong>.
    					</div>	
    						
    					<%}%>
				</form>
			</div>
			<div class="w3l_sign_in_register">
				<ul>
					<li><a href="PeliculasSocios.jsp" name="AdminPeliculas">Mis películas</a></li><a href="<%=request.getContextPath()%>/SalirController">Salir</a><br><br>
				</ul>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
<!-- //header -->
<!-- bootstrap-pop-up -->
	<div class="modal video-modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModal">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					Registro
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>						
				</div>
				<section>
					<div class="modal-body">
						<div class="w3_login_module">
							<div class="module form-module">
							  <div class="toggle"><i class="fa fa-times fa-pencil"></i>
								<div class="tooltip">Click Me</div>
							  </div>
							  <div class="form">
								<h3>Loguear tu cuenta</h3>
								<form id="formulario" action="Login" method="post">
								  <input type="text" name="Username" placeholder="Username" required="">
								  <input type="password" name="Password" placeholder="Password" required="">
								  <input type="submit"  id="btn-login" value="Login">
								  <div id="resp"></div>
								</form>
							  </div>
							  <div class="form">
								<h3>Crear una cuenta</h3>
								<form action="Register" method="post">
								  <input type="text" name="Username" placeholder="Username" required="">
								  <input type="password" name="Password" placeholder="Password" required="">
								  <input type="email" name="Email" placeholder="Email" required="">
								  <input type="text" name="Name" placeholder="Nombre" required="">
								   <input type="text" name="LastName" placeholder="Apellido" required="">
								  <input type="submit" value="Registro">
								</form>
							  </div>
							  <div class="cta"><a href="#">He olvidado mi clave</a></div>
							</div>
						</div>
					</div>
				</section>
			</div>
		</div>
	</div>
    
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
<!-- banner -->
	<div id="slidey" style="display:none;">
		<ul>
		
		 <% 
		 			ArrayList<Pelicula> p;
					p = dataPel.getByDetalle("principal"); 
			            
					for(Pelicula pel: p){
						
		 %>
			<li><img src="<%= request.getContextPath()%>/images/<%= pel.getImagen() %>" alt=" "><p class='title'><%= pel.getTitulo() %></p><p class='description'> <%= pel.getDescripcion() %></p></li>
		<% }
	   	%>
		</ul>   	
    </div>
    <script src="js/jquery.slidey.js"></script>
    <script src="js/jquery.dotdotdot.min.js"></script>
	   <script type="text/javascript">
			$("#slidey").slidey({
				interval: 8000,
				listCount: 5,
				autoplay: false,
				showList: true
			});
			$(".slidey-list-description").dotdotdot();
		</script>
<!-- //banner -->
<!-- banner-bottom -->
	<div class="banner-bottom">
		<div class="container">
			<form class="w3_agile_banner_bottom_grid" action="Alquiler" method="POST">
				<h2>RECIENTES</h2>
				<br><br>
				<div id="owl-demo" class="owl-carousel owl-theme">
				
				 <% 
			        	ArrayList<Pelicula> p1;
						p1 = dataPel.getByDetalle("reciente"); 
						for(Pelicula pel1: p1){
							
			        %>
					<div class="item">
						<div class="w3l-movie-gride-agile w3l-movie-gride-agile1">
							<form action="single.jsp" method="GET" class="hvr-shutter-out-horizontal">
							<a href="single.jsp">
								<img src="<%= request.getContextPath()%>/images/<%= pel1.getImagen() %>" title="album-name" class="img-responsive" alt=" " />
							</a>
							<div class="mid-1 agileits_w3layouts_mid_1_home">
								<div class="w3l-movie-text">
									<h4><%= pel1.getTitulo() %></h4>						
								</div>
								<div class="mid-2 agile_mid_2_home">
									
									<input type="hidden" name="titulo" value="<%= pel1.getTitulo() %>">
									<div class="clearfix"></div>
								</div>
							</div>
							<div class="ribben">
								<p>Nueva</p>
							</div>
							<br>
						</div>
					</div>
					  <% }
	   			      %>	
				</div>
				
				<br><br>
				<h2>MEJOR VALORADAS</h2>
				<br>
				<div id="owl-demo1" class="owl-carousel owl-theme">
				
				 <% 
			        	ArrayList<Pelicula> p2;
						p2 = dataPel.getByDetalle("valorada"); 
			            
						for(Pelicula pel2: p2){
						
			        %>
					<div class="item">
						<div class="w3l-movie-gride-agile w3l-movie-gride-agile1">
							<a href="single.jsp" class="hvr-shutter-out-horizontal"><img src="<%= request.getContextPath()%>/images/<%= pel2.getImagen() %>" title="album-name" class="img-responsive" alt=" " />
							</a>
							<div class="mid-1 agileits_w3layouts_mid_1_home">
								<div class="w3l-movie-text">
									<h6><a href="single.jsp"><%= pel2.getTitulo() %></a></h6>							
								</div>
								<div class="mid-2 agile_mid_2_home">
								   <input type="hidden" name="titulo" value="<%= pel2.getTitulo() %>">
									<div class="clearfix"></div>
								</div>
							</div>
						</div>
					</div>
					  <% }
	   			      %>	
				</div>
				
				<br><br>
				<h2>POPULARES</h2>
				<br>
				<div id="owl-demo2" class="owl-carousel owl-theme">
				
				 <% 
			        	ArrayList<Pelicula> p3;
						p3 = dataPel.getByDetalle("popular"); 
			            
						for(Pelicula pel3: p3){
						
			        %>
					<div class="item">
						<div class="w3l-movie-gride-agile w3l-movie-gride-agile1">
							<a href="single.jsp" class="hvr-shutter-out-horizontal"><img src="<%= request.getContextPath()%>/images/<%= pel3.getImagen() %>" title="album-name" class="img-responsive" alt=" " />
							</a>
							<div class="mid-1 agileits_w3layouts_mid_1_home">
								<div class="w3l-movie-text">
									<h6><a href="single.jsp"><%= pel3.getTitulo() %></a></h6>							
								</div>
								<div class="mid-2 agile_mid_2_home">
							<input type="hidden" name="titulo" value="<%= pel3.getTitulo() %>">
								
									<div class="clearfix"></div>
								</div>
							</div>
						</div>
					</div>
					  <% }
	   			      %>	
				</div>			
				<br>
			</form>		
		</div>
	</div>
<!-- //banner-bottom -->
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

<!-- Latest-tv-series -->
	<div class="Latest-tv-series">
		<h4 class="latest-text w3_latest_text w3_home_popular">Proximas peliculas</h4>
		<div class="container">
			<section class="slider">
				<div class="flexslider">
					<ul class="slides">
						<% 
						        	ArrayList<Pelicula> p4;
									p4 = dataPel.getByDetalle("popular"); 
						            
									for(Pelicula pel4: p4){
									
						        %>
						<li>
							<div class="agile_tv_series_grid">
								<div class="col-md-6 agile_tv_series_grid_left">
									<div class="w3ls_market_video_grid1 d-flex flex-md-wrap">
								
										<iframe width="560" height="315" src="<%= pel4.getTrailer()%>" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
										<a class="w3_play_icon" href="#small-dialog">
										</a>
									</div>
								</div>
								<div class="col-md-6 agile_tv_series_grid_right">
								
							
									<p class="fexi_header"><%= pel4.getTitulo() %></p>
									<p class="fexi_header_para"><span class="conjuring_w3">Descripcion<label>:</label></span><%=pel4.getDescripcion() %> <p>
									<p class="fexi_header_para"><span>Fecha<label>:</label></span> <%=pel4.getAnio() %> </p>
									<p class="fexi_header_para">
									<span>Genero<label>:&nbsp;&nbsp;&nbsp; <%=   pel4.getGenero().getDenominacion().substring(0,1).toUpperCase() +  pel4.getGenero().getDenominacion().substring(1) %></label> </span>
										<a href="ListaPeliculas.jsp"></a> <br> 							
									</p>
									<p class="fexi_header_para">
									<span>Pais<label>:&nbsp;&nbsp;&nbsp; <%=   pel4.getPais().substring(0,1).toUpperCase() +  pel4.getPais().substring(1) %></label> </span>
										<a href="ListaPeliculas.jsp"></a> <br><br><br> 							
									</p>
										
								</div>								
							</div>
						</li>
					 <% }
	   			    %>
					</ul>
				</div>
			</section>
			<!-- flexSlider -->
				<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" property="" />
				<script defer src="js/jquery.flexslider.js"></script>
				<script type="text/javascript">
				$(window).load(function(){
				  $('.flexslider').flexslider({
					animation: "slide",
					start: function(slider){
					  $('body').removeClass('loading');
					}
				  });
				});
			  </script>
			<!-- //flexSlider -->
		</div>
	</div>
	<!-- pop-up-box -->  
		<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
	<!--//pop-up-box -->
	<div id="small-dialog" class="mfp-hide">
		<iframe src="https://player.vimeo.com/video/164819130?title=0&byline=0"></iframe>
	</div>
	<div id="small-dialog1" class="mfp-hide">
		<iframe src="https://player.vimeo.com/video/148284736"></iframe>
	</div>
	<div id="small-dialog2" class="mfp-hide">
		<iframe src="https://player.vimeo.com/video/165197924?color=ffffff&title=0&byline=0&portrait=0"></iframe>
	</div>
	<script>
		$(document).ready(function() {
		$('.w3_play_icon,.w3_play_icon1,.w3_play_icon2').magnificPopup({
			type: 'inline',
			fixedContentPos: false,
			fixedBgPos: true,
			overflowY: 'auto',
			closeBtnInside: true,
			preloader: false,
			midClick: true,
			removalDelay: 300,
			mainClass: 'my-mfp-zoom-in'
		});
																		
		});
	</script>
<!-- //Latest-tv-series -->
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
					<a href="IndexSocio.jsp"><h2>One<span>Movies</span></h2></a>
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