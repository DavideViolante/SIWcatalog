<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="style.css" />
	<title>Ricerca cliente dall'ordine</title>
	</head>
	<body>
		<h2>Ricerca cliente dall'ordine:</h2>
		<form action="ricercaCliente.do" method="POST">
			<ul>
			<li>ID Ordine: <input type="text" name="idOrdine" />
			<p class="alert">${erroreID}</p></li>
			</ul>
			<input type="submit" value="Cerca" name="findByOrdine" />
			<p class="alert">${errore}</p>
			<br><br>
			<p>${info}</p>
			<c:choose>
	            <c:when test="${info != null}">
				<table class="tabellaBella" cellspacing="0" cellpadding="0">
					<tr>
						<th>Codice</th>
						<th>Nome</th>
						<th>Cognome</th>
						<th>Email</th>
					</tr>
					<tr>
						<td>${utente.id}</td>
						<td>${utente.nome}</td>
						<td>${utente.cognome}</td>
						<td>${utente.email}</td>
					</tr>
				</table>
	            </c:when>
        	</c:choose>	

		</form>
	</body>
</html>