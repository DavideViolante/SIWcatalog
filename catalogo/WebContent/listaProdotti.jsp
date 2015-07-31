<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="style.css" />
		<title>Catalogo prodotti</title>
	</head> 
	<body>
		<h2>Catalogo prodotti</h2>
			<table cellspacing="0" cellpadding="0" class="tabellaBella">
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Azioni</th>
				</tr>
				<c:forEach var="prodotto" items="${prodotti}">  
	 			<tr>
	 				<td>${prodotto.id}</td>
	 				<td>${prodotto.nome}</td>
	 				<td><form action="mostraProdotto.do" id="mostraProdotto" method="POST">
	 						<input type="hidden" name="id" value="${prodotto.id}"/>
	 						<input type="submit" class="dettagli" name="id" value="Dettagli" />
	 					</form></td>
	 			</tr>
	 			</c:forEach>
			</table>
			<p>${info}</p>
		<c:choose>
            <c:when test="${info != null}">
            <table cellspacing="0" cellpadding="0" class="tabellaBella">
				<tr>
					<th width="20%">ID</th>
					<th width="30%">Nome</th>
					<th width="30%">Descrizione</th>
					<th width="20%">Prezzo</th>
				</tr>
	 			<tr>
	 				<td>${id}</td>
	 				<td>${nome}</td>
	 				<td>${descrizione}</td>
	 				<td>${prezzo}&euro;</td>
	 			</tr>
			</table>
            </c:when>
        </c:choose>
		<br>
		<a href="index.jsp">Torna all'indice</a><br>
		<a href="javascript:history.back()">Torna indietro</a>
		
	</body>
</html>