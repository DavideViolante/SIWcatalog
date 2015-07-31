package model;

import java.util.List;

import persistence.OrdineProxy;
import persistence.PersistenceException;
import persistence.RigaOrdineDAO;

public class FacadeRigaOrdine {
	private RigaOrdineDAO persistence;
	
	public FacadeRigaOrdine() {
		this.persistence = new RigaOrdineDAO();
	}
	
	public boolean inserisciRiga(long idOrdine, String idProdotto, Double prezzo, int quantita) {
		try {
			this.persistence.insert(idOrdine, idProdotto , prezzo, quantita);
			return true;
		} catch (PersistenceException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<RigaOrdine> findByOrdine(OrdineProxy ordineProxy) {
		try {
			return this.persistence.findByOrdine(ordineProxy);
		} catch (PersistenceException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<RigaOrdine> findByIDOrdine(long id) {
		try {
			return this.persistence.findByIDOrdine(id);
		} catch (PersistenceException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<RigaOrdine> listaRighe() {
		try {
			return this.persistence.findAll();
		} catch (PersistenceException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean deleteByIDOrdine(Long id) {
		try {
			this.persistence.deleteByIDOrdine(id);
			return true;
		} catch (PersistenceException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Prodotto findByIDs(String idProdotto, Long idOrdine) {
		try {
			return this.persistence.findByIDs(idProdotto, idOrdine);
		} catch (PersistenceException e) {
			e.printStackTrace();
			return null;
		}
	}
}
