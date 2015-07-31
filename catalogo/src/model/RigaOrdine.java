package model;

public class RigaOrdine {
	
	private int quantita;
	private double prezzo;
	private Prodotto prodotto;
	private String id_prodotto;
	private Long id_ordine;
	
	public RigaOrdine(){}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public Prodotto getProdotto() {
		return prodotto;
	}

	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}

	public String getIDprodotto() {
		return id_prodotto;
	}

	public void setIDprodotto(String id_prodotto) {
		this.id_prodotto = id_prodotto;
	}

	public Long getIDordine() {
		return id_ordine;
	}

	public void setIDordine(Long id_ordine) {
		this.id_ordine = id_ordine;
	}
	
	

}
