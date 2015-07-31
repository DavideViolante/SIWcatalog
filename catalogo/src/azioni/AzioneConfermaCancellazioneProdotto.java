package azioni;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.FacadeProdotto;


public class AzioneConfermaCancellazioneProdotto extends Azione {

	@Override
	public String esegui(HttpServletRequest request) throws ServletException {
		String esitoAzione = "errore";
		HttpSession sessione = request.getSession();
		if (request.getParameter("conferma").equals("si")) {
			FacadeProdotto facade = new FacadeProdotto();
			if (facade.cancellaProdottoByID((String)sessione.getAttribute("id"))) {
				esitoAzione = "confermaCancellazioneProdottoSI";
				request.setAttribute("info", "Prodotto cancellato con successo.");
			}
		} else {
			esitoAzione = "confermaCancellazioneProdottoNO";
		}
		return esitoAzione;
	}

}
