<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="style.css" />
		<title>Prodotto inserito</title>
	</head>
	<body>
		<p>${info}</p>
		<table cellspacing="0" cellpadding="0" class="tabellaBella">
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Descrizione</th>
				<th>Prezzo</th>
			</tr>  
 			<tr>
 				<td>${id}</td>
 				<td>${nome}</td>
 				<td>${descrizione}</td>
 				<td>${prezzo}&euro;</td>
 			</tr>
		</table>
		<p><a href="inserimentoProdotto.jsp">Inserisci un altro prodotto</a><br>
		<a href="index.jsp">Admin Control Panel</a></p>
	</body>
</html>