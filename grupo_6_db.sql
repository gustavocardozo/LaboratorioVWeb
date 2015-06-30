-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-06-2015 a las 03:49:10
-- Versión del servidor: 5.6.24
-- Versión de PHP: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `grupo_6_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `avion`
--

CREATE TABLE IF NOT EXISTS `avion` (
  `ID_AVION` int(11) NOT NULL,
  `NOMBRE` varchar(30) NOT NULL,
  `CAPACIDAD` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `avion`
--

INSERT INTO `avion` (`ID_AVION`, `NOMBRE`, `CAPACIDAD`) VALUES
(1, 'TANGO01', 50),
(2, 'TANGO02', 50),
(3, 'TANGO03', 50);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `ID_CLIENTE` int(11) NOT NULL,
  `DIRECCION` varchar(50) NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `TELEFONO` varchar(30) NOT NULL,
  `DNI` int(11) NOT NULL,
  `NOMBRE` varchar(40) NOT NULL,
  `APELLIDO` varchar(40) NOT NULL,
  `FEC_NACIMIENTO` date NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`ID_CLIENTE`, `DIRECCION`, `EMAIL`, `TELEFONO`, `DNI`, `NOMBRE`, `APELLIDO`, `FEC_NACIMIENTO`) VALUES
(1, 'Calle falsa 123', 'admin@admin.com.ar', '11111111111', 11111111, 'Guillermo', 'Telijo', '1994-04-11'),
(2, 'Av Siempre Viva', 'root@admin.com.ar', '2222222222', 22222222, 'Esteban', 'Quito', '1994-10-18'),
(3, 'dasdasd', 'ddddddddd', '56764565', 56161651, '2752455752', '72272742', '5555-04-11'),
(4, 'ddasdasd', 'asdasdasd', '5616516', 45651561, 'asdasd', 'asdasda', '1111-11-11');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paquete`
--

CREATE TABLE IF NOT EXISTS `paquete` (
  `ID_PAQUETE` int(11) NOT NULL,
  `PRECIO` decimal(8,2) NOT NULL,
  `NOMBRE` varchar(50) NOT NULL,
  `DESDE` varchar(50) NOT NULL,
  `HACIA` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `paquete`
--

INSERT INTO `paquete` (`ID_PAQUETE`, `PRECIO`, `NOMBRE`, `DESDE`, `HACIA`) VALUES
(0, '587.00', 'Supero promo MAster', 'Argentina', 'Bahía Blanca');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paquete_cliente`
--

CREATE TABLE IF NOT EXISTS `paquete_cliente` (
  `ID_CLIENTE` int(11) NOT NULL,
  `ID_PAQUETE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE IF NOT EXISTS `reserva` (
  `ID_RESERVA` int(11) NOT NULL,
  `NRO_TARJETA` int(11) NOT NULL,
  `COD_VERIFICADOR` int(11) NOT NULL,
  `FECHA_VENCIMIENTO` int(11) NOT NULL,
  `TOTAL` decimal(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva_paquete`
--

CREATE TABLE IF NOT EXISTS `reserva_paquete` (
  `ID_RESERVA` int(11) NOT NULL,
  `ID_PAQUETE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vuelo`
--

CREATE TABLE IF NOT EXISTS `vuelo` (
  `ID_VUELO` int(11) NOT NULL,
  `ID_AVION` int(11) DEFAULT NULL,
  `DESDE` varchar(30) NOT NULL,
  `HASTA` varchar(30) NOT NULL,
  `PARTIDA` datetime DEFAULT NULL,
  `LLEGADA` datetime DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `vuelo`
--

INSERT INTO `vuelo` (`ID_VUELO`, `ID_AVION`, `DESDE`, `HASTA`, `PARTIDA`, `LLEGADA`) VALUES
(1, 1, 'Buenos Aires', 'Paris', '2015-07-01 15:00:00', '2015-07-03 19:30:00'),
(2, 3, 'Uruguay', 'Puerto Rico', '2015-06-30 21:15:00', '2015-07-04 04:23:00');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `avion`
--
ALTER TABLE `avion`
  ADD PRIMARY KEY (`ID_AVION`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`ID_CLIENTE`);

--
-- Indices de la tabla `paquete`
--
ALTER TABLE `paquete`
  ADD PRIMARY KEY (`ID_PAQUETE`);

--
-- Indices de la tabla `paquete_cliente`
--
ALTER TABLE `paquete_cliente`
  ADD PRIMARY KEY (`ID_CLIENTE`,`ID_PAQUETE`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`ID_RESERVA`);

--
-- Indices de la tabla `vuelo`
--
ALTER TABLE `vuelo`
  ADD PRIMARY KEY (`ID_VUELO`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `ID_CLIENTE` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `vuelo`
--
ALTER TABLE `vuelo`
  MODIFY `ID_VUELO` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
