<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="style.css" />
		<title>Conferma Evasione</title>
	</head>
	<body>
		<form action="confermaEvasioneOrdine.do" method="post">
			Sei sicuro di voler evadere l'ordine?
			<input type="submit" name="confermaEvasione" value="si" />
			<input type="submit" name="confermaEvasione" value="no" />
		</form>
	</body>
</html>