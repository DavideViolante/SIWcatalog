<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="style.css" />
		<title>Evasione di un ordine</title>
	</head>
	<body>
		<h2>Inserisci l'ID dell'ordine da evadere:</h2>
		<form action="evasioneOrdine.do" method="POST">
			<ul>
			<li>ID Ordine: <input type="text" name="idOrdine"/>
			<p class="alert">${erroreID}</p></li>
			</ul>
			<p class="alert">${errore}</p><br>
			<input type="submit" value="Evadi" name="findOrdine" />
		</form>
		<br>
		<a href="index.jsp">Torna all'indice.</a>
	</body>
</html>