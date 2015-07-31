<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="style.css" />
		<title>Home</title>
	</head>
	<body>
		<form action="cancellazioneProdotto.do" method="post">
			<h2>Cancellazione prodotto</h2>
			<ul>
				<li>ID: <input type="text" name="id" value="${param.id}"/>
				<p class="alert">${erroreID}</p></li>
			</ul>
	 		<input type="submit" name="submit" value="Rimuovi" />
	 		<p class="alert">${erroreNonEsiste}</p><br>
	 	</form>
		
		<form action="listaProdotti.do" id="listaProdotti" method="post">
			<a href="javascript:document.getElementById('listaProdotti').submit();">Visualizza catalogo</a>
		</form>
	</body>
</html>