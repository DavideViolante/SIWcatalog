<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="style.css" />
		<title>Inserimento Cliente</title>
	</head>
	<body>
		<h2>Inserisci i dati del cliente:</h2>
			<form action="inserimentoCliente.do" method="POST">
			<ul>
				<li>
					Nome: <input type="text" name="nome" value="${param.nome}" />
					<p class="alert">${erroreNome}</p>
				</li>
				<li>
					Cognome: <input type="text" name="cognome" value="${param.cognome}" />
					<p class="alert">${erroreCognome}</p>
				</li>
				<li>
					Email: <input type="text" name="mail" value="${param.mail}" />
					<p class="alert">${erroreMail}</p>
				</li>
				<li>
					Username: <input type="text" name="username" value="${param.username}" />
					<p class="alert">${erroreUsername}</p>
				</li>
				<li>
					Password: <input type="password" name="password" value="${param.password}" />
					<p class="alert">${errorePassword}</p>
				</li>
				<li>Role: <select name="ruolo">
						  	<option>admin</option>
						  	<option selected>user</option>
						  </select>
				</li>
			</ul>
			<p class="alert">${erroreDuplicato}</p><br>
				<input type="submit" name="sumbit" value="Invia" />
			</form>
	</body>
</html>