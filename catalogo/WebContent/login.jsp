<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="style.css" />
		<title>Login</title>
	</head>
	<body>
  		<h2>Login</h2>
		<form action="login.do" method="POST">
			<ul>
				<li>
					Username: <input type="text" name="username" value="${param.username}" />
					<p class="alert">${erroreUsername}</p>
				</li>
				<li>
					Password: <input type="password" name="password" />
					<p class="alert">${errorePassword}</p>
				</li>
			</ul>
			<p class="alert">${erroreLogin}</p><br>
			<input type="submit" value="Login" name="login" />
		</form>
  </body>
</html>