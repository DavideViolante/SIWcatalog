package persistence;

import java.util.List;

import model.Prodotto;
import model.RigaOrdine;

public interface RigaOrdineRepository {
	public List<RigaOrdine> findByOrdine(OrdineProxy ordineProxy) throws PersistenceException;
	public List<RigaOrdine> findByIDOrdine(long id) throws PersistenceException;
	public void insert(Long id, String nomeProdotto, double prezzo, int quantita) throws PersistenceException;
	public void deleteByIDOrdine(Long id) throws PersistenceException;
	public List<RigaOrdine> findAll() throws PersistenceException;
	public Prodotto findByIDs(String idProdotto, Long idOrdine) throws PersistenceException;
}

