package azioni;

import helper.FormOrdineHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.FacadeOrdine;
import model.Ordine;

public class AzioneEvasioneOrdine extends Azione {

	@Override
	public String esegui(HttpServletRequest request) throws ServletException {
		String esitoAzione = "errore";
		HttpSession sessione = request.getSession();
		FacadeOrdine facade = new FacadeOrdine();
		FormOrdineHelper helper = new FormOrdineHelper(request);
		
		if(helper.convalida()) {
			Ordine ordine = facade.trovaOrdine(Long.parseLong(request.getParameter("idOrdine")));
			if (ordine != null) {
				if (ordine.getStato().equals("chiuso")) {
					sessione.setAttribute("ordine", ordine);
					esitoAzione = "evasioneOrdineOK";
				} else {
					request.setAttribute("errore", "L'ordine non è evadibile.");
					esitoAzione = "evasioneOrdineKO";
				}
			} else {
				request.setAttribute("errore", "L'ordine non esiste.");
				esitoAzione = "evasioneOrdineKO";
			}
		} else {
			esitoAzione = "evasioneOrdineKO";
		}
		return esitoAzione;
	}
}
