package model;

import java.util.List;

import persistence.OrdineDAO;
import persistence.PersistenceException;

public class FacadeOrdine {

	private OrdineDAO persistence;

	public FacadeOrdine() {
		this.persistence = new OrdineDAO();
	}

	public Ordine trovaOrdine(Long id) {
		try {
			return this.persistence.findById(id);
		} catch (PersistenceException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean updateStatoOrdine(Ordine ordine) {
		try {
			this.persistence.update(ordine);
			return true;
		} catch (PersistenceException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean inserisciOrdine(Ordine ordine) {
		try {
			this.persistence.saveOrdine(ordine);
			return true;
		} catch (PersistenceException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean rimuoviOrdine (Long id){
		try {
			this.persistence.delete(id);
			return true;
		} catch (PersistenceException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Ordine> ListaOrdini(Utente utente){
		try {
			return this.persistence.findByUtente(utente);
		} catch (PersistenceException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Ordine> findAll() {
		try {
			return this.persistence.findAll();
		} catch (PersistenceException e) {
			e.printStackTrace();
			return null;
		}
	}
}
