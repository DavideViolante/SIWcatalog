package azioni;

import helper.FormOrdineHelper;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.FacadeProdotto;
import model.FacadeRigaOrdine;
import model.Ordine;
import model.Prodotto;
import model.RigaOrdine;

public class AzioneInserimentoRigaOrdine extends Azione {
	@Override
	public String esegui(HttpServletRequest request) throws ServletException {
		String esitoAzione = "inserimentoRigaOK";
		
		FormOrdineHelper helper = new FormOrdineHelper(request);
		FacadeProdotto facadeProdotto = new FacadeProdotto();
		FacadeRigaOrdine facadeRiga = new FacadeRigaOrdine();
		HttpSession session = request.getSession();
		
		String idProdotto = request.getParameter("idProdotto");
		String quantita = request.getParameter("quantita");
		Ordine ordine = (Ordine) session.getAttribute("ordine");
		Prodotto p = facadeProdotto.trovaProdotto(idProdotto);
		
		if(helper.convalidaRiga()) {
			if (p != null) {
				if (facadeRiga.findByIDs(idProdotto, ordine.getId()) == null &&
					facadeRiga.inserisciRiga(ordine.getId(), idProdotto, p.getPrezzo(), Integer.parseInt(quantita))) {
					request.setAttribute("info", "Riga inserita con successo: ");
				} else {
					request.setAttribute("errore", "Hai già scelto tale prodotto.");
				}
			} else {
				request.setAttribute("errore", "Il prodotto non esiste.");
			}
		}
		// trova le righe di quell'ordine
		List<RigaOrdine> righe = facadeRiga.findByIDOrdine(ordine.getId());
		request.setAttribute("righe", righe);
		
		return esitoAzione;
	}

}