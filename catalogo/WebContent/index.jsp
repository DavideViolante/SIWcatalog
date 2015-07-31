<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List,model.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	FacadeUtente f = new FacadeUtente();
    if(f.listaUtenti().size() == 0) {
	   out.clear();
	   RequestDispatcher rd = application.getRequestDispatcher("/install.jsp");
   	   rd.forward(request, response);
	   return;
   }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="style.css" />
		<title>Homepage</title>
	</head>
	<body>
		<h2 class="welcomeText">Benvenuto.<br>
		<c:if test="${utente.ruolo != null}">Sei loggato come <b>${utente.username}</b> <i>(${utente.ruolo})</i>.</c:if></h2>
		<ol>
			<c:choose>
  				<c:when test="${utente.username != null}">
			  		<li><form action="logout.do" id="logout" method="POST">
  							<a href="#" onclick="javascript:document.getElementById('logout').submit();">Logout</a> (${utente.ruolo})
  						</form>
  					</li>
  					<c:choose>
	  					<c:when test="${utente.ruolo == 'admin'}">
							<li><a href="inserimentoProdotto.jsp">Inserimento Prodotto</a></li>
							<li><a href="cancellazioneProdotto.jsp">Cancellazione Prodotto</a></li>
							<li><a href="inserimentoCliente.jsp">Inserimento Cliente</a></li>
							<li><form action="listaOrdiniTot.do" id="listaOrdiniTot" method="POST">
							<a href="javascript:document.getElementById('listaOrdiniTot').submit();">Mostra tutti gli ordini</a>
							</form>
							</li>
							<li><a href="evasioneOrdine.jsp">Evasione ordine</a></li>
							<li><a href="ricercaCliente.jsp">Ricerca cliente dall'ordine</a></li>
	 					</c:when>
	 					<c:when test="${utente.ruolo == 'user'}">
							<li><form action="inserimentoOrdine.do" id="inserimentOrdine" method="POST">
							<a href="javascript:document.getElementById('inserimentOrdine').submit();">Effettua ordine</a>
							</form></li>
							<li><form action="listaOrdini.do" id="listaOrdini" method="POST">
							<a href="javascript:document.getElementById('listaOrdini').submit();">Consulta ordini</a>
							</form></li>
	 					</c:when>
 					</c:choose>
 				</c:when>
 				<c:otherwise>
  					<li><a href="login.jsp">Login</a></li>
  					<li><a href="register.jsp">Registrati</a></li>
   				</c:otherwise> 
			</c:choose>
			<li><form action="listaProdotti.do" id="listaProdotti" method="POST">
					<a href="#" onclick="javascript:document.getElementById('listaProdotti').submit();">Mostra catalogo</a>
				</form>
			</li>
		</ol>
		<p>${info}</p>
	</body>
</html>