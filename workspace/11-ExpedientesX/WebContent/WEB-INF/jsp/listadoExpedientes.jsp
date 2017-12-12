<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value='/css/estilos.css'/>"	type="text/css" />
<title>Expedientes X</title>
</head>

<body>

	<div id="content">

		<h1>
			Expedientes X para
			<sec:authentication property="principal.username" />
		</h1>
		<a href="<c:url value='/index.jsp'/>">Inicio</a><br>
		<br>

		<table>
			<tr>
				<td><b>ID</b></td>
				<td align="center"><b>Imagen</b></td>
				<td align="right"><b>Titulo</b></td>
				<td width="40%"><b>Informe</b></td>
				<td align="right"><b>Investigador</b></td>
				<td align="center"><b>Clasificado</b></td>
				<td><b>Operaciones</b></td>
			</tr>
			<c:forEach var="expediente" items="${expedientes}">
				<tr valign="top">
					<td>${expediente.id}</td>
					<td align="center"><img src="<c:url value='/${expediente.imagen}'/>" height="100px" /></td>
					<td align="right"><b>${expediente.titulo}</b></td>
					<td width="40%"><font size="-1">${expediente.informe}</font></td>
					<td align="right"><b>${expediente.investigador}</b></td>
					<td align="center"><b>${expediente.clasificado}</b></td>
					<td>
						<a href="<c:url value='/expedientesx/mostrar/${expediente.id}'/>">mostrar</a>
						<sec:authorize access="hasAnyRole(['ROLE_AGENTE_ESPECIAL','ROLE_DIRECTOR'])">
							<a href="<c:url value='/expedientesx/clasificar?id=${expediente.id}'/>">clasificar</a>
						</sec:authorize>
						<sec:authorize access="hasRole('ROLE_DIRECTOR') or #expediente.investigador == authentication.name">
							<a href="<c:url value='/expedientesx/desclasificar?id=${expediente.id}'/>">desclasificar</a>
						</sec:authorize>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>













