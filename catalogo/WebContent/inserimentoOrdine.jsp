<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,java.util.LinkedList,model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserimento nuovo ordine</title>
</head>
<body>
	<h3>Seleziona un prodotto ed una quantità relativa per inserirlo nell' ordine:</h3>

		<h2>Catalogo</h2>
		<form action="inserisciProdottoNellOrdine.do" method="post">
		<table>
			<tr>
				<th>Codice</th>
				<th>Nome</th>
				<th>Descrizione</th>
				<th>Prezzo</th>
			</tr>

			  	<c:forEach var="prodotto" items="${prodotti}">
 			<tr>
 				<td>${prodotto.id} </td>
 				<td>${prodotto.nome} </td>
 				<td>${prodotto.descrizione} </td>
 				<td>${prodotto.prezzo} </td>
 				<td> <input type="submit" name="id" value="${prodotto.id}" /> </td>
 				<td> <input name="quantita" type="text" value="" size="5" maxlength="3" /></td>
 			</tr>
 			</c:forEach>
		</table>
		</form>



	<form action="inserimentoOrdine.do" method="post">

	
	</form>

	<a href="indexCliente.jsp">Torna al pannello di amministrazione.</a>

	</body>
</html>