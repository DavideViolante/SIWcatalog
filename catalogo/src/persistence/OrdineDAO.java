package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Ordine;
import model.Utente;


public class OrdineDAO implements OrdineRepository {

	private DataSource ds;
	private Connection connection;
	private PreparedStatement statement;
	private ResultSet result;

	public OrdineDAO() {
		this.ds = new DataSource();
		this.connection = null;
		this.statement = null;
		this.result = null;
	}
	
	@Override
	public List<Ordine> findAll() throws PersistenceException {
		List<Ordine> lista = new ArrayList<Ordine>();
		String query = "SELECT * FROM ordine";
		try {
			connection = ds.getConnection();
			statement = connection.prepareStatement(query);
			result = statement.executeQuery();
			while (result.next()) { // true se c'e' un altra riga
				Ordine ordine = new OrdineProxy();
				ordine.setId(result.getLong("id"));
				java.util.Date data = new Date(result.getDate("data").getTime());
				ordine.setData(data);
				ordine.setStato(result.getString("stato"));

				UtenteDAO udao = new UtenteDAO(); 
				Utente u = udao.findById(result.getLong("id_cliente"));
				ordine.setUtente(u);

				lista.add(ordine);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)	statement.close();
				if (connection != null)	connection.close();
				if (result != null) result.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return lista;
	}

	@Override
	public Ordine findById(Long id) throws PersistenceException {
		Ordine ordine = null;
		String query = "SELECT * FROM ordine WHERE id=?";
		try {
			connection = ds.getConnection();
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			result = statement.executeQuery();
			if (result.next()) {
				ordine = new OrdineProxy();
				ordine.setId(result.getLong("id"));
				// eager load
				UtenteDAO r = new UtenteDAO(); 
				Utente u = r.findById(result.getLong("id_cliente"));
				ordine.setUtente(u);

				java.util.Date data = new Date(result.getDate("data").getTime());
				ordine.setData(data);
				ordine.setStato(result.getString("stato"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)	statement.close();
				if (connection != null)	connection.close();
				if (result != null) result.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return ordine;
	}

	@Override
	public void delete(Long id) throws PersistenceException {
		String update = "DELETE FROM ordine WHERE id=?";
		try {
			connection = ds.getConnection();
			statement = connection.prepareStatement(update);
			statement.setLong(1, id);
			statement.executeUpdate();

			RigaOrdineDAO r = new RigaOrdineDAO();
			// cascade delete
			r.deleteByIDOrdine(id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)	statement.close();
				if (connection != null)	connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}

	@Override
	public List<Ordine> findByUtente(Utente u) throws PersistenceException {
		Ordine ordine = null;
		String query = "SELECT * FROM ordine WHERE id_cliente=?";
		List<Ordine> lista = new ArrayList<Ordine>();
		try {
			connection = ds.getConnection();
			statement = connection.prepareStatement(query);
			statement.setLong(1, u.getId());
			result = statement.executeQuery();
			while (result.next()) {
				ordine = new OrdineProxy();
				ordine.setId(result.getLong("id"));
				java.util.Date data = new Date(result.getDate("data").getTime());
				ordine.setData(data);
				ordine.setStato(result.getString("stato"));
				lista.add(ordine);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)	statement.close();
				if (connection != null)	connection.close();
				if (result != null) result.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return lista;
	}
	
	@Override
	public void update(Ordine ordine) throws PersistenceException {
		String update = "UPDATE ordine SET stato=? WHERE id=? ";
		try {
			connection = ds.getConnection();
			statement = connection.prepareStatement(update);
			statement.setString(1, ordine.getStato());
			statement.setLong(2, ordine.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)	statement.close();
				if (connection != null)	connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}

	@Override
	public void saveOrdine(Ordine ordine) throws PersistenceException {
		java.util.Date now = new java.util.Date();
		java.sql.Date data = new java.sql.Date(now.getTime());
		// cosi prende anche l'ora solo che poi nel db la perde...
		//java.util.Date now = new java.util.Date();
		//java.sql.Timestamp data = new java.sql.Timestamp(now.getTime());
		String update = "INSERT INTO ordine(id, data, id_cliente, stato) VALUES (?,?,?,?)";
		try {
			connection = ds.getConnection();
			long id = IdBroker.getId(connection);
			ordine.setId(id);
			statement = connection.prepareStatement(update);
			statement.setLong(1, id);
			statement.setDate(2, data);
			statement.setLong(3, ordine.getUtente().getId());
			statement.setString(4, "aperto");
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)	statement.close();
				if (connection != null)	connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}

}

