<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="style.css" />
		<title>Admin Control Panel</title>
	</head>
	<body>
		<h2>Pannello di amministrazione</h2>
		<p>Benvenuto nel pannello di amministrazione: cosa vuoi fare?</p>
		<ul>
			<li><a href="inserimentoProdotto.jsp">Inserimento prodotto</a></li>
			<li><a href="cancellazioneProdotto.jsp">Cancellazione prodotto</a></li>
			<li><a href="inserimentoCliente.jsp">Inserimento cliente</a></li>
			<li><a href="evasioneOrdine.jsp">Evasione ordine</a></li>
			<li><a href="ricercaCliente.jsp">Ricerca cliente dall'ordine</a></li>
		</ul>	
	</body>
</html>