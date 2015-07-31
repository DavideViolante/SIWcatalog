package azioni;

import helper.FormProdottoHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.FacadeProdotto;

public class AzioneInserimentoProdotto extends Azione {

	@Override
	public String esegui(HttpServletRequest request) throws ServletException {

		String esitoAzione = "errore";
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String descrizione = request.getParameter("descrizione");
		String prezzo = request.getParameter("prezzo");
		
		FacadeProdotto facade = new FacadeProdotto();
		FormProdottoHelper helper = new FormProdottoHelper(request);
		
		if (helper.convalida()) {
			if(facade.trovaProdotto(id) == null) {
				HttpSession sessione = request.getSession();
				sessione.setAttribute("id", id);
				sessione.setAttribute("nome", nome);
				sessione.setAttribute("descrizione", descrizione);
				sessione.setAttribute("prezzo", prezzo);
				esitoAzione = "inserimentoProdottoOK";
			} else {
				esitoAzione = "inserimentoProdottoKO";
				request.setAttribute("erroreDuplicato", "Codice già esistente.");
			}
		} else {
			esitoAzione = "inserimentoProdottoKO";
		}
		return esitoAzione;
	}
}