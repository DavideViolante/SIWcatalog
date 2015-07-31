package azioni;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import model.FacadeProdotto;
import model.Prodotto;

public class AzioneMostraProdotto extends Azione {

	@Override
	public String esegui(HttpServletRequest request) throws ServletException {
		String esitoAzione = "errore";
		FacadeProdotto facade = new FacadeProdotto();
		Prodotto p = facade.trovaProdotto(request.getParameter("id"));
		if (p != null) {
			request.setAttribute("id", p.getId());
			request.setAttribute("nome", p.getNome());
			request.setAttribute("descrizione", p.getDescrizione());
			request.setAttribute("prezzo", String.valueOf(p.getPrezzo()));
			
			request.setAttribute("info", "Informazioni sul prodotto selezionato: ");
			esitoAzione = "mostraProdottoOK";
		}
		return esitoAzione;
	}

}
