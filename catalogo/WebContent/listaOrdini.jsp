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
		<h1>Ordini effettuati:</h1>
		<table class="tabellaBella" cellspacing="0" cellpadding="0">
			<tr>
				<th>Id</th>
				<th>Data</th>
				<th>Stato</th>
			</tr>
			<c:forEach var="ordine" items="${listaOrdini}">
			<tr> 
				<td>${ordine.id}</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd" value="${ordine.data}" /></td>
				<td>${ordine.stato}</td>
			</tr>
			</c:forEach>
		</table>
		<br>
		<p class="alert">${ordiniEmpty}</p>
		<br>
		<form action="riprendiOrdine.do" method="POST">
			<p>Inserisci l'ID di un ordine lasciato in sospeso per riprenderlo:</p>
			<ul>
				<li>ID Ordine: <input type="text" name="idOrdine" value="${idOrdine}" />
				<p class="alert">${erroreID2}</p></li>
			</ul>
			<input type="submit" name="sumbit" value="Riprendi" />
		</form>
		<p class="alert">${erroreNonEsiste}</p>
		<br>
		<form action="visualizzaRigheOrdine.do" method="POST">
			<p>Inserisci l'ID di un ordine di cui vuoi visualizzare le righe:</p>
			<ul>
				<li>ID Ordine: <input type="text" name="idOrdine" value="${idOrdine}" />
				<p class="alert">${erroreID}</p></li>
			</ul>
			<input type="submit" name="sumbit" value="Visualizza" />
		</form>
		<p class="alert">${errorNonEsiste}</p>
	</body>
</html>