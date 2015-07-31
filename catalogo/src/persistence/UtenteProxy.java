package persistence;

import java.util.ArrayList;
import java.util.List;

import model.Ordine;
import model.Utente;

public class UtenteProxy extends Utente {
	
	private boolean caricato = false;
	
	@Override
	public List<Ordine> getElenco_ordini() {
		if(!this.caricato){
			List<Ordine> listaOrdini=new ArrayList<Ordine>();
			OrdineDAO ordinedao=new OrdineDAO();
			try {
				listaOrdini=ordinedao.findByUtente(this);
				this.setElenco_ordini(listaOrdini);
				this.caricato=true;
			} catch (PersistenceException e) {
				e.printStackTrace();
			}
		}
	return super.getElenco_ordini();
	}
}

