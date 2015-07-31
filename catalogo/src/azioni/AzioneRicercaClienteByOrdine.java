package azioni;

import helper.FormOrdineHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import model.FacadeOrdine;
import model.Ordine;

public class AzioneRicercaClienteByOrdine extends Azione {

	@Override
	public String esegui(HttpServletRequest request) throws ServletException {
		String esitoAzione = "errore";
		FormOrdineHelper helper = new FormOrdineHelper(request);
		FacadeOrdine facade = new FacadeOrdine();
		
		if (helper.convalida()) {
			Ordine ordine = facade.trovaOrdine(Long.parseLong(request.getParameter("idOrdine")));
			if (ordine != null) {
				request.setAttribute("utente", ordine.getUtente());
				esitoAzione = "ricercaClienteOK";
				request.setAttribute("info", "Ricerca effettuata: ");
			} else {
				request.setAttribute("errore", "L'ordine non esiste.");
				esitoAzione = "ricercaClienteKO";
			}
		} else {
			esitoAzione = "ricercaClienteKO"; 
		}
		return esitoAzione;
	}

}
