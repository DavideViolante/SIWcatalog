package persistence;

import java.util.ArrayList;
import java.util.List;

import model.Ordine;
import model.RigaOrdine;

public class OrdineProxy extends Ordine {
	
	private boolean caricato = false;
	
	@Override
	public List<RigaOrdine> getRigheOrdine() {
		if(!this.caricato){
			List<RigaOrdine> righeOrdine = new ArrayList<RigaOrdine>();
			RigaOrdineDAO rigaOrdineDAO = new RigaOrdineDAO();
			try {
				righeOrdine = rigaOrdineDAO.findByOrdine(this);
				this.setRigheordine(righeOrdine);
				this.caricato=true;
			} catch (PersistenceException e) {
				e.printStackTrace();
			}
		}
		return super.getRigheOrdine();
	}
	
}