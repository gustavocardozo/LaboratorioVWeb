<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@ page import="model.Cliente" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar reserva - Travel Sistems</title>
<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
</head>

<body>
<header>
<div><img src="img/icono.png"></div>
<ul class="menu">
<li><a href="">Home</a></li>
<li><a href="AgregarReserva">Agregar reserva</a></li>
<li><a href="UpdateReserva">Modificar reserva</a></li>
</ul>
</header>
<section class="contenedor">
<h2>Agregar Reserva</h2>
<form action="" >

<p>${string}</p>
<p>
<span>Seleccione un cliente</span>
<select id="clientes" name="clientes">
	<c:forEach items= "${clientes}" var="cliente">
		<option value="${cliente.id}"> ${cliente.nombre} </option>
	</c:forEach>
</select>

</p>
<p>
<span>Seleccione un paquete</span>
<select id="paquetes" name ="paquetes">
	<c:forEach items= "${paquetes}" var="paquete">
		<option value="${paquete.idPaquete}"> ${ paquete.nombre} </option>
	</c:forEach>
</select>
</p>
<p>
<span>Seleccione un vuelo</span>
<select id="vuelos" name="vuelos">
<c:forEach items= "${vuelos}" var="vuelo">
<option value="${ vuelo.idVuelo}"> ${ vuelo.avion.getNombre } </option>
</c:forEach>
</select>
</p>

<p>
<span>Observaciones:</span>
<input type="text" name="observaciones">
</p>
<input type= "submit" name= "aceptar" value="Agregar">
 

</form>

</section>
</body>
</html>