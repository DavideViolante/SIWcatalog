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

public class AzioneRiprendiCompilazioneOrdine extends Azione{
	
	@Override
	public String esegui(HttpServletRequest request) throws ServletException {
		HttpSession session = request.getSession();
		String esitoAzione = "errore";
       
		FacadeRigaOrdine facadeRiga = new FacadeRigaOrdine();
		FacadeOrdine facade = new FacadeOrdine();
		FormOrdineHelper helper = new FormOrdineHelper(request);
		Utente utenteCorrente = (Utente)session.getAttribute("utente");
		List<Ordine> ordini = facade.ListaOrdini(utenteCorrente);
		String idOrdine = request.getParameter("idOrdine");
		
		if(helper.convalida2()) {
			for(Ordine ordine : ordini) {
				if(ordine.getId() == Long.parseLong(idOrdine) && ordine.getStato().equals("aperto")) {
					    session.setAttribute("ordine", ordine);
					    List<RigaOrdine> righe = facadeRiga.findByIDOrdine(Long.parseLong(idOrdine));
						request.setAttribute("righe", righe);
						return esitoAzione = "inserimentoRigaOK";
//					} else {
//				        request.setAttribute("erroreChiuso", "L'ordine è chiuso.");		
//					}
				} else {
					esitoAzione = "listaOrdiniOK";
					request.setAttribute("erroreNonEsiste", "L'ordine non esiste o non è aperto.");
				}
			}
		} else {
			esitoAzione="listaOrdiniOK";
		}
		
		return esitoAzione;
	}

}
