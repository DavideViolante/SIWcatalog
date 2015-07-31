<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="style.css" />
		<title>Inserisci Riga</title>
	</head>
	<body>
	    <h2>Inserimento prodotti nell'ordine</h2>
	    <br />
		<form action="listaProdotti.do" id="listaProdotti" method="POST">
			<p><a href="#" onclick="javascript:document.getElementById('listaProdotti').submit();">Consulta catalogo</a></p>
		</form>
		<form action="inserimentoRigaOrdine.do" id="riga" method="POST">
			<ul>
				<li>ID Prodotto: <input type="text" name="idProdotto" value="${idProdotto}" />
				<p class="alert">${erroreID}</p></li>
				<li>Quantita:  <input type="text" name="quantita" value="${quantita}" />
				<p class="alert">${erroreQuantita}</p></li>
			</ul>
			<p class="alert">${errore}</p><br>
			<input type="submit" name="sumbit" value="Aggiungi riga" />
		</form>

		<p>${info}</p>
		<c:choose>
            <c:when test="${righe != null}">
			<table cellspacing="0" cellpadding="0" class="tabellaBella">
				<tr>
					<th>ID prodotto</th>
					<th>Nome prodotto</th>
					<th>Prezzo</th>
					<th>Quantita</th>
				</tr>
	 			<c:forEach var="riga" items="${righe}">  
	 			<tr>
	 				<td>${riga.IDprodotto}</td>
	 				<td>${riga.prodotto.nome}</td>
	 				<td>${riga.prezzo}&euro;</td>
	 				<td>${riga.quantita}</td>
	 			</tr>
	 			</c:forEach>
			</table>
            </c:when>
        </c:choose>		
		<form action="confermaOrdine.do" method="POST">
			<p>Vuoi confermare l'ordine? (cliccando su "No" l'ordine verrà rimosso)</p>
  			<input type="submit" name="risposta" value="Si"/>
 			<input type="submit" name="risposta" value="No"/>
		</form>
		<p class="alert">${erroreNoRighe}</p>
		<br>
		<a href="index.jsp" >Lascia in sospeso l'ordine</a>
	</body>
</html>