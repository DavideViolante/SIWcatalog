package azioni;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.FacadeProdotto;
import model.Prodotto;

public class AzioneMostraListaProdotti extends Azione {

	@Override
	public String esegui(HttpServletRequest request) throws ServletException {
		String esitoAzione = "errore";
		FacadeProdotto f = new FacadeProdotto();
		List<Prodotto> prodotti = f.mostraListaProdotti();
		HttpSession sessione = request.getSession();
		
		if (prodotti != null) {
			esitoAzione = "listaProdottiOK";
		}
		sessione.setAttribute("prodotti", prodotti);
		
		return esitoAzione;
	}
}
