package model;

import java.util.List;

public class Utente {
	
	private long id;
	private String nome;
	private String cognome;
	private String email;
	private String username;
	private String password;
	private String ruolo;
		
	private List<Ordine> elenco_ordini;
		
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Ordine> getElenco_ordini() {
		return elenco_ordini;
	}
	public void setElenco_ordini(List<Ordine> elenco_ordini) {
		this.elenco_ordini = elenco_ordini;
	}
	
	@Override
	public String toString(){
		return this.nome+" "+this.cognome+" "+this.email+" "+
			   this.username+" "+this.password+" "+this.ruolo;
	}
	//definire equals ed hash

}
