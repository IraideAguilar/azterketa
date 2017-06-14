<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.sql.*" %>
<%@ page import="eus.azterketa.modelo.*"%>

<% 
if (request.getParameter("nombreApellidoCorredor") !=null){

String nombreApellidoCorredor = request.getParameter("nombreApellidoCorredor");
String[] partes = nombreApellidoCorredor.split(" , ");
String nombre = partes[0];
String apellido = partes[1];

ModeloCorredor modeloCorredor = new ModeloCorredor();
ModeloClasificacion modeloClasificacion = new ModeloClasificacion();

Corredor corredor = modeloCorredor.selectCorredor(nombre,apellido);
int corredorId = corredor.getId();

if (null != corredor) { 
	
	modeloClasificacion.borraClasificacion(corredorId);
	modeloCorredor.borrarCorredor(nombre,apellido);
	
	
	response.sendRedirect("corredorBorrado.jsp");
	
}else{

response.sendRedirect("error.jsp");

}
}

%>
</body>
</html>