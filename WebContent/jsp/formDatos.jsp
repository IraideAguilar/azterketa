<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulario de resultados</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">


</head>
<body>
	<%@ page import="eus.azterketa.modelo.*"%>
	<%@ page import="java.util.ArrayList"%>
	
	<% 
		ModeloCorredor modeloCorredor = new ModeloCorredor();
		ArrayList<Corredor> corredores = modeloCorredor.selectAll();//denak aterateko

		ModeloEtapa modeloEtapa = new ModeloEtapa();
		ArrayList<Etapa> etapas = modeloEtapa.selectAllEtapa();
		
	    ModeloClasificacion modeloClasificacion = new ModeloClasificacion();
		 
		//lortu beharreko gauzak
		    int id_corredor = Integer.parseInt(request.getParameter("id_corredor"));
			int id_etapa = Integer.parseInt(request.getParameter("id_etapa"));
			int posicion = Integer.parseInt(request.getParameter("posicion"));
		//submit-eri emtoten digunean 
		if ((request.getParameter("id_corredor") != null ) && (request.getParameter("id_etapa") !=null) && (request.getParameter("posicion") != null)){

			Clasificacion clasificacion = new Clasificacion();
			clasificacion.setId_etapa(id_etapa);
			clasificacion.setId_corredor(id_corredor);
			clasificacion.setPosicion(posicion);

			modeloClasificacion.insertPosicion(clasificacion);
			
		}
		//submitari emonda gero taula agertzea, beti agertuko da subitari emon ala ez
		ArrayList<Clasificacion> clasificaciones = modeloClasificacion.selectClasificacion();
		
		%>	


	<div class="container">
		<br> <br>
		<div class="row">
			<div class="col-md-12">
				<div class="jumbotron">
					<h1>Resultados de etapa</h1>
					<h6>Formulario para introducir posiciones de corredores en
						etapas</h6>
				</div>

			</div>
		</div>
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<form action="">
					<div class="form-group">
						<h3>
							<span class="label label-default">Corredor</span>
						</h3>
						<select class="form-control" name="id_corredor">

							<%
								for (Corredor corredor : corredores) {
							%>

							<option value="<%=corredor.getId()%>">
								<%
									out.println(corredor.getNombre() + " " + corredor.getApellido());
								%>
							</option>
							<%
								}
							%>

						</select>
					</div>

					<div class="form-group">
						<h3>
							<span class="label label-default">Etapa</span>
						</h3>
						<%
							for (Etapa etapa : etapas) {
						%>
						<div class="radio">
							<input type="radio" name="id_etapa" id=""
								value="<%=etapa.getId()%>">
							<%
								out.println(etapa.getPueblo_salida() + " - " + etapa.getPueblo_llegada());
							%>

						</div>
						<%
							}
						%>
					</div>

					<div class="form-group">
						<h3>
							<span class="label label-default">Posicion</span>
						</h3>
						<input type="text" class="form-control" id="" name="posicion"
							size="5" />
					</div>

					<div class="form-group">
						<button type="submit" value="guardar" class="btn btn-default">Guardar</button>
					</div>
				</form>
			</div>

		</div>
		<div class="row">
			<div class="col-md-10 col-md-offset-1">
				<h2>Posicion de todos los corredores</h2>
				<table class="table">
					<tr>
						<th>id etapa</th>
						<th>id corredor</th>
						<th>posicion</th>
					</tr>
					<%
							for (Clasificacion clasificacion : clasificaciones) {
								
						%>
					<tr>
						<td><%out.println(clasificacion.getId_etapa());%></td>
						<td><%out.println(clasificacion.getId_corredor());%></td>
						<td><%out.println(clasificacion.getPosicion());%></td>
					</tr>
					<%}%>
				</table>
			</div>
		</div>
		
		<!-- row bukaera -->
	</div>
</body>
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
</html>