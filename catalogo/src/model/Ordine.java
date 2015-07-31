package model;

import java.util.Date;
import java.util.List;

public class Ordine {
	
	private Long id;
	private Date data;
	private Utente utente;
	private List<RigaOrdine> righeOrdine;
	private String stato;
	
	public Ordine() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<RigaOrdine> getRigheOrdine() {
		return righeOrdine;
	}

	public void setRigheordine(List<RigaOrdine> righeordine) {
		this.righeOrdine = righeordine;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

}
