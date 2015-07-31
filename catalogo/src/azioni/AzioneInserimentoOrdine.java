package azioni;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.FacadeOrdine;
import model.Ordine;
import model.Utente;

public class AzioneInserimentoOrdine extends Azione {

	@Override
	public String esegui(HttpServletRequest request) throws ServletException {
		HttpSession session = request.getSession();
		String esito = "errore";
		Ordine ordine = new Ordine();
		Utente utenteCorrente = (Utente)session.getAttribute("utente");
		ordine.setUtente(utenteCorrente);
		FacadeOrdine facade = new FacadeOrdine();
		
		if (facade.inserisciOrdine(ordine)) {
//			String codice = request.getParameter("codice");
//			String quantita = request.getParameter("quantita");
//			session.setAttribute("codice", codice);
//			session.setAttribute("quantita", quantita);
			session.setAttribute("ordine", ordine);
			esito = "inserimentoOrdineOK";
		} else {
			request.setAttribute("ErroreInserimentoOrdine",	"L'ordine non è stato inserito");
			esito = "inserimentoOrdineKO";
		}
		return esito;
	}

}
