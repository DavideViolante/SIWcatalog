<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="style.css" />
		<title>User control panel</title>
	</head>
	<body>
		<h2>Pannello di controllo</h2>
		<p>Benvenuto nel tuo pannello di controllo: cosa vuoi fare?</p>
	
		<form action="inserimentoOrdine.do" method="POST">
		<p>Effettua un nuovo ordine: <input type="submit" value="Inizia Compilazione Ordine"/></p>
		</form>
		
		<form action="consultaOrdini.do" method="POST">
		<p>Consulta gli ordini precedentemente avviati: <input type="submit" value="Consulta Ordini"/></p>
		</form>
		
	</body>
</html>