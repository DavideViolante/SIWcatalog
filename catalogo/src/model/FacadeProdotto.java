package model;

import java.util.ArrayList;
import java.util.List;

import persistence.PersistenceException;
import persistence.ProdottoDAO;

public class FacadeProdotto {
	
	private ProdottoDAO persistence;
	
	public FacadeProdotto(){
		this.persistence = new ProdottoDAO();
	}
	public boolean inserisciProdotto(String codice, String nome, String descrizione, double prezzo) {
	    try {
		    this.persistence.insert(codice, nome, descrizione, prezzo);
		    return true;
		} catch (PersistenceException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean cancellaProdotto(String nome){
		try {
			this.persistence.delete(this.persistence.findByNome(nome));
			return true;
		} catch (PersistenceException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean cancellaProdottoByID(String id){
		try {
			this.persistence.delete(id);
			return true;
		} catch (PersistenceException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Prodotto trovaProdotto(String id){
		try {
			return this.persistence.findByID(id);
		} catch (PersistenceException e) {		
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Prodotto> mostraListaProdotti(){
		List<Prodotto> lista = new ArrayList<Prodotto>();
		try {
			lista = this.persistence.findAll();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return lista;
	}	

}
