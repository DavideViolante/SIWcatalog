package azioni;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.FacadeOrdine;
import model.Ordine;

public class AzioneListaOrdini extends Azione {
	
	@Override
	public String esegui(HttpServletRequest request) throws ServletException {
		String esitoAzione = "errore";
		FacadeOrdine facade = new FacadeOrdine();
		HttpSession sessione = request.getSession();
		List<Ordine> ordini = facade.findAll();
		
		if(ordini != null)
			esitoAzione="listaOrdiniTotOK";
		sessione.setAttribute("listaOrdiniTot", ordini);
		return esitoAzione;
	}

}
