<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="style.css" />
		<title>Righe ordine</title>
	</head>
	<body>
		<h1>Righe dell'ordine scelto:</h1>
		<table cellspacing="0" cellpadding="0" class="tabellaBella">
			<tr>
				<th>ID Prodotto</th>
				<th>Nome prodotto</th>
				<th>Quantita</th>
				<th>Prezzo</th>
			</tr>
			<c:forEach var="riga" items="${righeOrdine}">
			<tr> 
				<td>${riga.IDprodotto}</td>
				<td>${riga.prodotto.nome}</td>
				<td>${riga.quantita}</td>
				<td>${riga.prezzo}&euro;</td>
			</tr>
			</c:forEach>
		</table>
		<br>
		<p><a href="javascript:history.back()">Torna indietro</a></p>
	</body>
</html>