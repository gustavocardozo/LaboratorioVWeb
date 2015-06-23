<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Cliente" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script language="javascript"> 

function AgregarCliente(){ 
  
  var id = document.getElementById("select").value;
  <% Cliente clie = new Cliente();
  	clie.setId(1);
  %>
} 

</script> 

<body>

<h2>Modificar Reserva</h2>
<form action="" >
<p>
<span>Seleccione un cliente</span>
<select id="clientes" name="clientes">
	<c:foreach items= "${ clientes }" var="cliente">
		<option value="${ cliente.id }"> ${ cliente.nombre } </option>
	</c:foreach>
</select>

</p>
<p>
<span>Seleccione un paquete</span>
<select id="paquetes" name ="paquetes">
	<c:foreach items= "${ paquetes }" var="paquete">
		<option value="${ paquete.id }"> ${ paquete.nombre } </option>
	</c:foreach>
</select>
</p>
<p>
<span>Seleccione un vuelo</span>
<select id="vuelos" name="vuelos">
<c:foreach items= "${vuelos}" var="vuelo">
<option value="${ vuelo.id}"> ${ vuelo.nombre } </option>
</c:foreach>
</select>
</p>

<p>
<span>Observaciones:</span>
<input type="text" name="observaciones">
</p>
<input type= "submit" name= "aceptar" value="Agregar">
 

</form>


</body>
</html>