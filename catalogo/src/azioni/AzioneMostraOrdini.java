package azioni;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import model.FacadeOrdine;
import model.Ordine;
import model.Utente;

public class AzioneMostraOrdini extends Azione {
	
	@Override
	public String esegui(HttpServletRequest request) throws ServletException {
		String esitoAzione = "errore";
		FacadeOrdine facade = new FacadeOrdine();
		HttpSession sessione = request.getSession();
		Utente u = (Utente)sessione.getAttribute("utente");
		List<Ordine> ordini = facade.ListaOrdini(u);
		
		if(ordini.isEmpty()) {
			esitoAzione="listaOrdiniOK";
			request.setAttribute("ordiniEmpty", "Non hai effettuato nessun ordine.");
		} else {
			esitoAzione="listaOrdiniOK";
		}
		sessione.setAttribute("listaOrdini", ordini);
		return esitoAzione;
	}

}
