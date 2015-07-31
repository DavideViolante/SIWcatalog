package persistence;

import java.util.List;
import model.Ordine;
import model.Utente;

public interface OrdineRepository {
	public List<Ordine> findAll() throws PersistenceException;
	public Ordine findById(Long id) throws PersistenceException;
	public List<Ordine> findByUtente(Utente u) throws PersistenceException;
	public void saveOrdine(Ordine ordine) throws PersistenceException;
	public void delete(Long id) throws PersistenceException;
	public void update(Ordine ordine) throws PersistenceException;
}
