<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="style.css" />
		<title>Cliente inserito</title>
	</head>
	<body>
		<p>${info}</p>
		<table cellspacing="0" cellpadding="0" class="tabellaBella">
			<tr>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Email</th>
				<th>Username</th>
				<th>Password</th>
				<th>Ruolo</th>
			</tr>  
 			<tr>
 				<td>${nome}</td>
 				<td>${cognome}</td>
 				<td>${mail}</td>
 				<td>${username}</td>
 				<td>${password}</td>
 				<td>${ruolo}</td>
 			</tr>
		</table>
		<p><a href="inserimentoCliente.jsp">Inserisci un altro cliente</a><br>
		<a href="index.jsp">Admin Control Panel</a></p>

	</body>
</html>