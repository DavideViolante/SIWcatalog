package model;

import java.util.List;

import persistence.PersistenceException;
import persistence.UtenteDAO;

public class FacadeUtente {
	
	private UtenteDAO persistence;
	
	public FacadeUtente() {
		this.persistence = new UtenteDAO();
	}
	
	public boolean inserisciUtente(String nome, String cognome, String email,
								   String username, String password, String ruolo) {
		Utente utente = new Utente();
		utente.setNome(nome);
		utente.setCognome(cognome);
		utente.setEmail(email);
		utente.setUsername(username);
		utente.setPassword(password);
		utente.setRuolo(ruolo);
	    try {
			this.persistence.insert(utente);
			return true;
		} catch (PersistenceException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean cancellaUtente(long id){
		try {
			this.persistence.delete(id);
			return true;
		} catch (PersistenceException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Utente trovaUtente(long id){
		try {
			return this.persistence.findById(id);
		} catch (PersistenceException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Utente trovaUtente(String username){
		try {
			return this.persistence.findByUsername(username);
		} catch (PersistenceException e) {
			e.printStackTrace();
			return null;
		}
	}
		
	public List<Utente> listaUtenti() {
		try {
			return this.persistence.findAll();
		} catch (PersistenceException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Utente login(String username, String password) {
		Utente utente = null;
		List<Utente> utenti = this.listaUtenti();	
		
		for(Utente u : utenti) {
			if(u.getUsername().equals(username) && u.getPassword().equals(password)){
				utente = new Utente();
				utente = u;
			}
		}
		return utente;
	}


}
