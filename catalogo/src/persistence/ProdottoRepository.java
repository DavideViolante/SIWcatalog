package persistence;

import java.util.List;

import model.Prodotto;


public interface ProdottoRepository {	
	public void insert(String codice,String nome, String descrizione, double prezzo) throws PersistenceException;
	public void delete(Prodotto prodotto) throws PersistenceException;
	public void delete(String id) throws PersistenceException;
	public void update(Prodotto prodotto) throws PersistenceException;
	public Prodotto findByNome(String nome) throws PersistenceException;
	public List<Prodotto> findAll() throws PersistenceException;
	public Prodotto findByID(String id) throws PersistenceException;
}
