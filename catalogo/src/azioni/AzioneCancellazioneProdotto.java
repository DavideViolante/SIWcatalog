package azioni;

import helper.FormProdottoHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.FacadeProdotto;

public class AzioneCancellazioneProdotto extends Azione {

	@Override
	public String esegui(HttpServletRequest request) throws ServletException {
		String esitoAzione = "errore";
		FormProdottoHelper helper = new FormProdottoHelper(request);
		FacadeProdotto facade = new FacadeProdotto();
		String id = request.getParameter("id");
		if (helper.convalidaPerCancellazione()) {
			if(facade.trovaProdotto(id) != null) {
				HttpSession sessione = request.getSession();
				sessione.setAttribute("id", id);
				esitoAzione = "cancellazioneProdottoOK";
			} else {
				esitoAzione = "cancellazioneProdottoKO";
				request.setAttribute("erroreNonEsiste", "Il prodotto non esiste.");
			}
		} else {
			esitoAzione = "cancellazioneProdottoKO";
		}
		return esitoAzione;
	}
}