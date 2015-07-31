package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Utente;

public class UtenteDAO implements UtenteRepository {
	private DataSource ds;
	private Connection connection;
	private PreparedStatement statement;
	private ResultSet result;

	public UtenteDAO() {
		this.ds = new DataSource();
		this.connection = null;
		this.statement = null;
		this.result = null;
	}

	@Override
	public void insert(Utente cliente) throws PersistenceException {
		try {
			connection = ds.getConnection();
			long id = IdBroker.getId(connection);
			cliente.setId(id);
			String insert = "INSERT INTO cliente(id, nome, cognome, email, username, password, ruolo) VALUES (?,?,?,?,?,?,?)";
			statement = connection.prepareStatement(insert);
			statement.setLong(1, id);
			statement.setString(2, cliente.getNome());
			statement.setString(3, cliente.getCognome());
			statement.setString(4, cliente.getEmail());
			statement.setString(5, cliente.getUsername());
			statement.setString(6, cliente.getPassword());
			statement.setString(7, cliente.getRuolo());
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
	public List<Utente> findAll() throws PersistenceException {
		List<Utente> utenti = new ArrayList<Utente>();
		Utente utente = null;
		String query = "SELECT * FROM cliente";
		try {
			connection = ds.getConnection();
			statement = connection.prepareStatement(query);
			result = statement.executeQuery();
			while (result.next()) {// true se c'e' un altra riga
				utente = new Utente();
				utente.setId(result.getLong("id"));
				utente.setNome(result.getString("nome"));
				utente.setCognome(result.getString("cognome"));
				utente.setEmail(result.getString("email"));
				utente.setUsername(result.getString("username"));
				utente.setPassword(result.getString("password"));
				utente.setRuolo(result.getString("ruolo"));
				utenti.add(utente);
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
		return utenti;
	}
	
	
	@Override
	public Utente findById(Long id) throws PersistenceException {
		Utente utente = null;
		try {
			connection = ds.getConnection();
			String select = "SELECT * FROM cliente WHERE id=?";
			statement = connection.prepareStatement(select);
			statement.setLong(1, id);
			result = statement.executeQuery();
			if (result.next()) {
				utente = new Utente();
				utente.setId(result.getLong("id"));
				utente.setNome(result.getString("nome"));
				utente.setCognome(result.getString("cognome"));
				utente.setEmail(result.getString("email"));
				utente.setUsername(result.getString("username"));
				utente.setPassword(result.getString("password"));
				utente.setRuolo(result.getString("ruolo"));
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
		return utente;
	}
	
	@Override
	public Utente findByUsername(String username) throws PersistenceException {
		Utente utente = null;
		try {
			connection = ds.getConnection();
			String select = "SELECT * FROM cliente WHERE username=?";
			statement = connection.prepareStatement(select);
			statement.setString(1, username);
			result = statement.executeQuery();
			if (result.next()) {
				utente = new Utente();
				utente.setId(result.getLong("id"));
				utente.setNome(result.getString("nome"));
				utente.setCognome(result.getString("cognome"));
				utente.setEmail(result.getString("email"));
				utente.setUsername(result.getString("username"));
				utente.setPassword(result.getString("password"));
				utente.setRuolo(result.getString("ruolo"));
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
		return utente;
	}

	@Override
	public void delete(Long id) throws PersistenceException {
		try {
			connection = ds.getConnection();
			String query = "DELETE FROM cliente WHERE id=?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
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
