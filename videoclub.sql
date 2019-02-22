-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 22-02-2019 a las 21:08:04
-- Versión del servidor: 5.7.24
-- Versión de PHP: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `videoclub`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alquileres`
--

DROP TABLE IF EXISTS `alquileres`;
CREATE TABLE IF NOT EXISTS `alquileres` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `importePorDia` double NOT NULL DEFAULT '1000',
  `fechaAlquiler` date DEFAULT NULL,
  `fechaDevolucion` date DEFAULT NULL,
  `id_socio` int(11) NOT NULL,
  `id_pelicula` int(11) NOT NULL,
  `estado` varchar(1000) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_socio` (`id_socio`),
  KEY `id_pelicula` (`id_pelicula`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `alquileres`
--

INSERT INTO `alquileres` (`id`, `importePorDia`, `fechaAlquiler`, `fechaDevolucion`, `id_socio`, `id_pelicula`, `estado`) VALUES
(6, 1000, '2019-02-15', '2002-08-12', 1, 21, 'finalizado'),
(7, 1000, '2019-02-15', NULL, 1, 2, 'activo'),
(8, 1000, '2019-02-15', NULL, 1, 2, 'activo'),
(9, 1000, '2019-02-15', '2002-12-31', 1, 15, 'finalizado'),
(10, 1000, '2019-02-15', NULL, 1, 5, 'activo'),
(11, 1000, '2019-02-18', '2019-02-06', 1, 21, 'finalizado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `generos`
--

DROP TABLE IF EXISTS `generos`;
CREATE TABLE IF NOT EXISTS `generos` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `denominacion` varchar(250) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `generos`
--

INSERT INTO `generos` (`id`, `denominacion`) VALUES
(1, 'accion'),
(2, 'biografia'),
(3, 'crimen'),
(4, 'familia'),
(5, 'horror'),
(6, 'romance'),
(7, 'deportes'),
(8, 'guerra'),
(9, 'aventura'),
(10, 'comedia'),
(11, 'documental'),
(12, 'fantasia'),
(13, 'suspenso'),
(14, 'animacion'),
(15, 'vestuario'),
(16, 'drama'),
(17, 'historia'),
(18, 'musical'),
(19, 'psicologica');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `peliculas`
--

DROP TABLE IF EXISTS `peliculas`;
CREATE TABLE IF NOT EXISTS `peliculas` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `duracion` varchar(250) COLLATE utf8_spanish_ci NOT NULL,
  `titulo` varchar(250) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(1000) COLLATE utf8_spanish_ci NOT NULL,
  `id_genero` int(100) NOT NULL,
  `imagen` varchar(1000) COLLATE utf8_spanish_ci DEFAULT NULL,
  `anio` int(100) NOT NULL,
  `pais` varchar(1000) COLLATE utf8_spanish_ci NOT NULL,
  `trailer` varchar(1000) COLLATE utf8_spanish_ci NOT NULL,
  `detalle` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_genero` (`id_genero`)
) ENGINE=MyISAM AUTO_INCREMENT=677 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `peliculas`
--

INSERT INTO `peliculas` (`id`, `duracion`, `titulo`, `descripcion`, `id_genero`, `imagen`, `anio`, `pais`, `trailer`, `detalle`) VALUES
(1, '140 minutos', 'Central Intelligence', 'Un agente de la CIA que solía sufrir acoso escolar se reencuentra con sus compañeros en una reunión de antiguos alumnos, aunque ahora él es musculoso y fuerte. ', 3, '4.jpg', 2006, 'USA', 'https://www.youtube.com/embed/MxEw3elSJ8M', 'principal'),
(2, '120 minutos', 'X-Men', 'El profesor Xavier lidera a Wolverine y otros superhéroes contra Magneto, un mutante que dominará a la humanidad.', 1, 'm11.jpg', 1999, 'USA', 'https://www.youtube.com/embed/kyQKi5-k0UU', ''),
(4, '90 minutos', 'Citizen Soldier', 'Cuenta la verdadera historia de un grupo de Soldados y su gira de servicio en Afganistán que les cambia la vida.', 1, 'm13.jpg', 2017, 'Francia', 'https://www.youtube.com/embed/-d-BcfRGl7c', 'popular'),
(5, '80 minutos', 'The BFG', 'Una niña de 10 años, con la ayuda de la reina Victoria de Inglaterra y de un gigante bondadoso, tratará de arruinar el propósito de unos gigantes malvados, quienes quieren comerse a todos los niños.', 12, 'm8.jpg', 2013, 'USA', 'https://www.youtube.com/embed/GZ0Bey4YUGI', 'popular'),
(6, '120 minutos', 'Tarzan', 'Tarzán regresa al Congo engañado, pensando que va a servir de emisario; sin saber que en realidad es un peón del malévolo plan que ha trazado un capitán belga que pretende entregar a Tarzán a cambio de diamantes.', 9, '5.jpg', 2006, 'Inglaterra', 'https://www.youtube.com/embed/Aj7ty6sViiU', 'principal'),
(7, '90 minutos', 'Maximum Ride', 'Seis niños, genéticamente modificados con ADN aviar, vuelan alrededor del país para descubrir sus orígenes.', 19, '2.jpg', 2000, 'USA', 'https://www.youtube.com/embed/lhQiwVi3jdo', 'principal'),
(8, '145 minutos', 'Dia de la Independencia', 'Han pasado veinte años desde la última invasión alienígena, y el temor de las naciones de la Tierra al regreso de los invasores extraterrestres ha dado lugar a la elaboración de un programa de defensa a escala global, que utiliza tecnología anlienígena recuperada para proteger al planeta y prepararse para un posible contraataque. ', 13, '3.jpg', 2000, 'USA', 'https://www.youtube.com/embed/y6SIy4fgwQE', 'principal'),
(9, '80 minutos', 'Greater', 'Greater es una película deportiva biográfica estadounidense de 2016 dirigida por David Hunt y protagonizada por Christopher Severio como el jugador de fútbol americano Brandon Burlsworth.', 2, 'm12.jpg', 2015, 'USA', 'https://www.youtube.com/embed/v0Ow6lhvPNk', 'destacado'),
(10, '100 minutos', 'Light B/t Oceans', 'Un farero y su esposa que viven en la costa de Australia Occidental crían a un bebé que rescatan de un bote de remos a la deriva.\r\n', 6, 'm7.jpg', 2018, 'USA', 'https://www.youtube.com/embed/g3uULkvZh1w', 'reciente'),
(11, '122 minutos', 'Central Intelligence', 'Un agente de la CIA que solía sufrir acoso escolar se reencuentra con sus compañeros en una reunión de antiguos alumnos, aunque ahora él es musculoso y fuerte. ', 3, 'm9.jpg', 2014, 'USA', 'https://www.youtube.com/embed/MxEw3elSJ8M', 'popular'),
(12, '130 minutos', 'Don\'t Think Twice', 'Un grupo de humoristas de improvisación de Nueva York se soprende cuando uno de sus miembros anuncia que protagonizará un programa de televisión. Los demás comediantes tienen miedo de nunca alcanzar el éxito.', 10, 'm10.jpg', 1998, 'USA', 'https://www.youtube.com/embed/9RFTpObS95U', 'valorada'),
(13, '85 minutos', 'Pedro', 'Pedro pasa su vida atormentado después de haber negado la existencia de Cristo, él enfrenta la ejecución a manos de Nerón y está decidido a no desfallecer de nuevo.', 16, 'm17.jpg', 1990, 'España', 'https://www.youtube.com/embed/-V9KUpPprTk', 'valorada'),
(14, '89 minutos', 'God’s Compass', 'En la noche en que Suzanne Waters celebra su retiro, se enfrenta a una serie de crisis que no podría haber imaginado.', 16, 'm15.jpg', 2018, 'USA', 'https://www.youtube.com/embed/qLtD4orE2r4', 'reciente'),
(15, '80 minutos', 'Bad Moms', 'Parece que la vida de Amy es perfecta en todos los sentidos. Madre ejemplar, con un gran marido y unos hijos maravillosos. Sin embargo, harta de tantas responsabilidades, decide explorar el lado salvaje de la vida, y arrastra en su aventura a otras dos mamás saturadas de todo.', 10, 'm2.jpg', 2003, 'USA', 'https://www.youtube.com/embed/iKCw-kqo3cs', 'destacado'),
(16, '150 minutos', 'Rezort', 'Despúes de dominar a los zombis, los humanos los envían a un resort de lujo. Será muy divertido hasta que falle el sistema de seguridad.', 5, 'm16.jpg', 2014, 'China', 'https://www.youtube.com/embed/Hdos6JaXcBo', 'popular'),
(17, '100 minutos', 'Jason Bourne', 'Han pasado 10 años desde que Jason Bourne desapareciera, pero ahora deberá luchar contra una organización que utiliza la tecnología para sembrar el terror. ', 5, 'm5.jpg', 2014, 'Italia', 'https://www.youtube.com/embed/v71ce1Dqqns', 'popular'),
(18, '156 minutos', 'ISRA 88', 'Un científico y un piloto voluntario viajan en una misión de alto peligro para alcanzar el fin del universo. Después de 13 años, la nave se estrella hasta el final del universo y lo desconocido.', 12, 'm18.jpg', 2014, 'Francia', 'https://www.youtube.com/embed/u4prn8EXG3k', 'popular'),
(19, '146 minutos', 'War Dogs', 'Con la guerra en Irak en toda su furia, un joven ofrece a su amigo de la infancia la oportunidad de ganar mucho dinero al convertirse en un vendedor internacional de armas.', 16, 'm1.jpg', 2018, 'USA', 'https://www.youtube.com/embed/Rwh9c_E3dJk', 'reciente'),
(20, '80 miunutos', 'The Other Side', 'Hace 20 años, Vesna se mudó con su familia a Zagreb, lejos de los eventos que casi destruyeron sus vidas. Sin embargo, una llamada inesperada le devolverá el recuerdo de un viejo secreto.', 11, 'm14.jpg', 2010, 'USA', 'https://www.youtube.com/embed/YErbLF5Q09o', 'destacado'),
(21, '97 minutos', 'Civil War', 'Después de que otro incidente internacional, en el que se ven envueltos los Vengadores, produzca daños colaterales, la presión política obliga a poner en marcha un sistema para depurar responsabilidades.', 13, 'm19.jpg', 2018, 'USA', 'https://www.youtube.com/embed/FkTybqcX-Yo', 'reciente'),
(22, '133 minutos', 'The Secret Life of Pets', 'Max es un terrier malcriado que disfruta de una vida cómoda en un edificio de Nueva York hasta que su dueño adopta a Duke, un perro gigante y rebelde.', 14, 'm20.jpg', 1996, 'USA', 'https://www.youtube.com/embed/UZ4WBlveGfw', 'valorada'),
(23, '110 minutos', 'The Jungle Book', 'Después de ser rescatado por la pantera Bagheera en la selva, una manada de lobos cría al recién nacido Mowgli. La vida feliz y apacible de Mowgli junto a su familia adoptiva se rompe en mil pedazos cuando llega el peligroso tigre Shere Khan.', 14, 'm21.jpg', 2005, 'USA', 'https://www.youtube.com/embed/HcgJRQWxKnw', 'valorada'),
(24, '82 minutos', 'Assassin\'s Creed 3', 'Cuenta la historia de Callum Lynch, un criminal encerrado en prisión y condenado a ser ejecutado por sus delitos. Pero Lynch recibirá una nueva oportunidad de la organización Abstergo (Caballeros templarios actuales), entidad dirigida por Alan Rikkin.', 1, 'm22.jpg', 2009, 'USA', 'https://www.youtube.com/embed/YS8-Rd4NDdA', 'destacado'),
(25, '130 minutos', 'Dead Island 2', 'La historia continúa después de que los sobrevivientes escapan de la isla de Banoi y llegan a la isla de Palanai, en donde la infección se expandió.', 1, 'm23.jpg', 2011, 'Inglaterra', 'https://www.youtube.com/embed/AWFaj4IQ4ro', 'popular'),
(26, '87 minutos', 'Ice Age', 'Manny el mamut comienza a preocuparse cuando su hija Morita anuncia su compromiso y Sid, el perezoso se voluntariza para planificar la boda. ', 9, '6.jpg', 2013, 'Inglaterra', 'https://www.youtube.com/embed/Ohq6NmKMja8', 'principal'),
(27, '150 minutos', 'X - Man', 'El profesor Xavier lidera a Wolverine y otros superhéroes contra Magneto, un mutante que dominará a la humanidad.', 1, '7.jpg', 2009, 'USA', 'https://www.youtube.com/embed/N0io2w_6vT8', 'principal'),
(671, '120 minutos', 'Tarzan', 'Tarzán regresa al Congo engañado, pensando que va a servir de emisario; sin saber que en realidad es un peón del malévolo plan que ha trazado un capitán belga que pretende entregar a Tarzán a cambio de diamantes.', 9, 'm3.jpg', 2006, 'Inglaterra', 'https://www.youtube.com/embed/Aj7ty6sViiU', 'destacado'),
(672, '90 minutos', 'El Conjuro', 'Supuesto hecho paranormal, real, basado en la pareja Warren.', 5, 'conjuro.jpg', 2016, 'USA', 'https://www.youtube.com/embed/chAT_cFcQk0?controls=0', 'popular'),
(673, '90 minutos', 'El Conjuro', 'Supuesto hecho real basado en la pareja Warren.', 5, '7.jpg', 2016, 'USA', 'https://www.youtube.com/embed/chAT_cFcQk0?controls=0', 'principal'),
(674, '87 minutos', 'Ice Age', 'Manny el mamut comienza a preocuparse cuando su hija Morita anuncia su compromiso y Sid, el perezoso se voluntariza para planificar la boda. ', 9, 'hielo.jpg', 2013, 'Inglaterra', 'https://www.youtube.com/embed/Ohq6NmKMja8', 'popular'),
(675, '90 minutos', 'Maximum Ride', 'Seis niños, genéticamente modificados con ADN aviar, vuelan alrededor del país para descubrir sus orígenes.', 19, 'maximum.jpg', 2000, 'USA', 'https://www.youtube.com/embed/lhQiwVi3jdo', 'popular');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `socios`
--

DROP TABLE IF EXISTS `socios`;
CREATE TABLE IF NOT EXISTS `socios` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `apellido` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `usuario` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `estado` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `correo` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `rol` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `id_tarjeta` int(100) NOT NULL,
  `subscripcion` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_tarjeta` (`id_tarjeta`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `socios`
--

INSERT INTO `socios` (`id`, `nombre`, `apellido`, `usuario`, `password`, `estado`, `correo`, `rol`, `id_tarjeta`, `subscripcion`) VALUES
(1, 'nestor', 'amichetti', 'nestorami', '1234', 'activo', 'unemialcualquiera@gmail.com', 'socio', 2, 1),
(2, 'Juan', 'Perez', 'juan1234', '1234', 'activo', 'jperez@gmail.com', 'admin', 1, 0),
(5, 'Pedro', 'Pepe', 'pepe1234', '1234', 'activo', 'sadas@gmail.com', 'socio', 4, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarjetas`
--

DROP TABLE IF EXISTS `tarjetas`;
CREATE TABLE IF NOT EXISTS `tarjetas` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `tarjetas`
--

INSERT INTO `tarjetas` (`id`, `nombre`) VALUES
(1, ''),
(2, 'Visa'),
(3, 'Mastercard'),
(4, 'Cabal'),
(5, 'Maestro'),
(6, '');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `socios`
--
ALTER TABLE `socios`
  ADD CONSTRAINT `socios_ibfk_1` FOREIGN KEY (`id_tarjeta`) REFERENCES `tarjetas` (`id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
