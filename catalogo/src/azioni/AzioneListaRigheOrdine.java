package azioni;

import helper.FormOrdineHelper;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.FacadeOrdine;
import model.FacadeRigaOrdine;
import model.Ordine;
import model.RigaOrdine;
import model.Utente;

public class AzioneListaRigheOrdine extends Azione {

	@Override
	public String esegui(HttpServletRequest request) throws ServletException {
		String esitoAzione = "errore";
		FacadeOrdine facadeOrdine = new FacadeOrdine();
		FacadeRigaOrdine facadeRiga = new FacadeRigaOrdine();
		FormOrdineHelper helper = new FormOrdineHelper(request);
		HttpSession sessione = request.getSession();
		Utente u = (Utente) sessione.getAttribute("utente");
		String idOrdine = request.getParameter("idOrdine");
		
		List<Ordine> ordini = facadeOrdine.ListaOrdini(u);
		
		if(helper.convalida()) {
			for (Ordine ordine : ordini) {
				if(ordine.getId() == Long.parseLong(idOrdine)) {
					List<RigaOrdine> righeOrdine = facadeRiga.findByIDOrdine(Long.parseLong(idOrdine));
					if (righeOrdine != null) {
						sessione.setAttribute("righeOrdine", righeOrdine);
						return esitoAzione = "listaRigheOrdineOK";
					}
				} else {
					esitoAzione = "listaRigheOrdineKO";
					request.setAttribute("errorNonEsiste", "L'ordine non esiste.");
				}
			}
		} else {
			esitoAzione = "listaRigheOrdineKO";
		}
		return esitoAzione;
	}

}
