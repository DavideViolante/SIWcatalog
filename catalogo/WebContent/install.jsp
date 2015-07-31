<%@ page import="model.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%
	FacadeUtente f = new FacadeUtente();
   if(f.listaUtenti().size() > 0) {
	   out.clear();
	   RequestDispatcher rd = application.getRequestDispatcher("/index.jsp");
   	   rd.forward(request, response);
	   return;
   }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="style.css" />
		<title>Installazione</title>
	</head>
	<body>
		<h3>Grazie per aver installato la <b>MAD</b> Dynamic Web Application</h3>
		<p>La seguente procedura ti guiderà nella creazione dell'utente di amministrazione</p>
		<p>Verrà inoltre creata automaticamente una utenza base di testing con username: "user" e password: "user".</p>
			<form action="installazione.do" method="POST">
			<ul>
				<li>
					Nome Admin: <input type="text" name="nome" value="${param.nome}" />
					<p class="alert">${erroreNome}</p>
				</li>
				<li>
					Cognome Admin: <input type="text" name="cognome" value="${param.cognome}" />
					<p class="alert">${erroreCognome}</p>
				</li>
				<li>
					Email Admin: <input type="text" name="mail" value="${param.mail}" />
					<p class="alert">${erroreMail}</p>
				</li>
				<li>
					Username Admin: <input type="text" name="username" value="${param.username}" />
					<p class="alert">${erroreUsername}</p>
				</li>
				<li>
					Password Admin: <input type="password" name="password" value="${param.password}" />
					<p class="alert">${errorePassword}</p>
				</li>
			</ul>
				<input type="submit" name="sumbit" value="Invia" />
			</form>
	</body>
</html>