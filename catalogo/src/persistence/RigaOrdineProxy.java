package persistence;

import model.Prodotto;
import model.RigaOrdine;

public class RigaOrdineProxy extends RigaOrdine {

	private boolean caricato = false;

	@Override
	public Prodotto getProdotto() {
		if (!this.caricato) {
			ProdottoDAO p = new ProdottoDAO();
			try {
				Prodotto prod = p.findByID(this.getIDprodotto());
				this.setProdotto(prod);
				this.caricato = true;
			} catch (PersistenceException e) {
				e.printStackTrace();
			}
		}
		return super.getProdotto();
	}

}
