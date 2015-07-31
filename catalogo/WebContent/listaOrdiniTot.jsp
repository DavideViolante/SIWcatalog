<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="style.css" />
		<title>Ordini</title>
	</head>
	<body>
		<h1>Ordini:</h1>
		<table class="tabellaBella" cellspacing="0" cellpadding="0">
			<tr>
				<th>Id</th>
				<th>Data</th>
				<th>Stato</th>
				<th>ID Cliente</th>
			</tr>
			<c:forEach var="ordine" items="${listaOrdiniTot}">
			<tr> 
				<td>${ordine.id}</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd" value="${ordine.data}" /></td>
				<td>${ordine.stato}</td>
				<td>${ordine.utente.nome}</td>
			</tr>
			</c:forEach>
		</table>
		<p><a href="javascript:history.back()">Torna indietro</a></p>
	</body>
</html>