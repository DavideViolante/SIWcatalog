package azioni;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.FacadeOrdine;
import model.FacadeRigaOrdine;
import model.Ordine;

public class AzioneConfermaInserimentoOrdine extends Azione {

	@Override
	public String esegui(HttpServletRequest request) throws ServletException {
		String esitoAzione = "errore";
		FacadeOrdine facade = new FacadeOrdine();
		FacadeRigaOrdine facadeRiga = new FacadeRigaOrdine();
		HttpSession sessione = request.getSession();
		Ordine ordine = (Ordine)sessione.getAttribute("ordine");

		if (request.getParameter("risposta").equals("No")) {
			facade.rimuoviOrdine(ordine.getId());
			sessione.removeAttribute("ordine");
			esitoAzione = "confermaInserimentoOrdineNO";
			request.setAttribute("info", "Hai annullato l'ordine.");
		} else {
			if(!facadeRiga.findByIDOrdine(ordine.getId()).isEmpty()) {
				ordine.setStato("chiuso");
				facade.updateStatoOrdine(ordine);
				esitoAzione = "confermaInserimentoOrdineSI";
				request.setAttribute("info", "Ordine effettuato.");
			} else {
				request.setAttribute("erroreNoRighe", "Non hai inserito nessuna riga.");
				esitoAzione = "confermaInserimentoOrdineEmpty";
			}

		}
		return esitoAzione;
	}
}
