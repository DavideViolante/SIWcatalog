package persistence;

import java.util.List;
import model.Utente;

public interface UtenteRepository {
	public List<Utente> findAll() throws PersistenceException;
	public Utente findById(Long id) throws PersistenceException;
	public Utente findByUsername(String username) throws PersistenceException;
	public void insert(Utente ordine) throws PersistenceException;
	public void delete(Long id) throws PersistenceException;
}
