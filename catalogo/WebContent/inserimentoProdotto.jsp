<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="style.css" />
		<title>Inserimento Prodotto</title>
	</head>
	<body>
		<h2>Inserisci i dati del prodotto:</h2>
			<form action="inserimentoProdotto.do" method="POST">
				<ul>
					<li>
						Codice: <input type="text" name="id" value="${param.id}" />
						<p class="alert">${erroreID}</p>
					</li>
					<li>
						Nome: <input type="text" name="nome" value="${param.nome}" />
						<p class="alert">${erroreNome}</p>
					</li>
					<li>
						Descrizione: <input type="text" name="descrizione" value="${param.descrizione}" />
						<p class="alert">${erroreDescrizione}</p>
					</li>
					<li>
						Prezzo: <input type="text" name="prezzo" value="${param.prezzo}"/>
						<p class="alert">${errorePrezzo}</p>
					</li> 
				</ul>
			<p class="alert">${erroreDuplicato}</p><br>
			<input type="submit" name="sumbit" value="Invia" />
			</form>

	</body>
</html>