<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="style.css" />
		<title>Conferma cancellazione prodotto</title>
	</head>
	<body>
		<form action="confermaCancellazioneProdotto.do" method="post">
	
			Sei sicuro di voler cancellare il prodotto?
			<input type="submit" name="conferma" value="si" />
			<input type="submit" name="conferma" value="no" />
		</form>
	</body>
</html>