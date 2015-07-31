package azioni;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.FacadeOrdine;
import model.Ordine;

public class AzioneConfermaEvasioneOrdine extends Azione {

	@Override
	public String esegui(HttpServletRequest request) throws ServletException {
		String esitoAzione = "errore";
		HttpSession sessione = request.getSession();
		String c = request.getParameter("confermaEvasione");
		if (c.equals("si")) {
			FacadeOrdine f = new FacadeOrdine();
			Ordine o = (Ordine) sessione.getAttribute("ordine");
			o.setStato("evaso");
			f.updateStatoOrdine(o);
			esitoAzione = "confermaEvasioneOrdineSI";
			request.setAttribute("info", "Ordine evaso.");
		} else {
			esitoAzione = "confermaEvasioneOrdineNO";
		}
		return esitoAzione;
	}
}