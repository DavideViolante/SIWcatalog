package azioni;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.FacadeProdotto;

public class AzioneConfermaInserimentoProdotto extends Azione {

	@Override
	public String esegui(HttpServletRequest request) throws ServletException {
		String esitoAzione = "errore";
		HttpSession sessione = request.getSession();
		if (request.getParameter("conferma").equals("si")) {
			FacadeProdotto facade = new FacadeProdotto();
			if (facade.inserisciProdotto(
					(String)sessione.getAttribute("id"),
					(String)sessione.getAttribute("nome"),
					(String)sessione.getAttribute("descrizione"),
					Double.parseDouble((String)sessione.getAttribute("prezzo")))) {
				esitoAzione = "confermaInserimentoProdottoSI";
				request.setAttribute("info", "Prodotto inserito con successo.");
			}
		} else {
			sessione.removeAttribute("id");
			sessione.removeAttribute("nome");
			sessione.removeAttribute("descrizione");
			sessione.removeAttribute("prezzo");
			esitoAzione = "confermaInserimentoProdottoNO";
		}
		return esitoAzione;
	}
}