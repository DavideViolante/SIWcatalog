package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List; 

import model.Prodotto;

public class ProdottoDAO implements ProdottoRepository {

	private DataSource ds;
	private Connection connection;
	private PreparedStatement statement;
	private ResultSet result;

	public ProdottoDAO() {
		this.ds = new DataSource();
		this.connection = null;
		this.statement = null;
		this.result = null;
	}

	@Override
	public void insert(String codice, String nome, String descrizione, double prezzo) throws PersistenceException {
		String update = "INSERT INTO prodotto(id, nome, descrizione, prezzo) VALUES (?,?,?,?)";
		try {
			connection = ds.getConnection();
			statement = connection.prepareStatement(update);
			statement.setString(1, codice);
			statement.setString(2, nome);
			statement.setString(3, descrizione);
			statement.setDouble(4, prezzo);
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
	public void delete(Prodotto prodotto) throws PersistenceException {
		String update = "DELETE FROM prodotto WHERE id=?";
		try {
			connection = ds.getConnection();
			statement = connection.prepareStatement(update);
			statement.setString(1, prodotto.getId());
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
	public void delete(String id) throws PersistenceException {
		String update = "DELETE FROM prodotto WHERE id=?";
		try {
			connection = ds.getConnection();
			statement = connection.prepareStatement(update);
			statement.setString(1, id);
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
	public void update(Prodotto prodotto) throws PersistenceException {
		String update = "UPDATE prodotto SET nome=?, descrizione=?, prezzo=? WHERE id=?";
		try {
			connection = ds.getConnection();
			statement = connection.prepareStatement(update);
			statement.setString(1, prodotto.getDescrizione());
			statement.setDouble(2, prodotto.getPrezzo());
			statement.setString(3, prodotto.getNome());
			statement.setString(4, prodotto.getId());
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
	public Prodotto findByNome(String nome) throws PersistenceException {
		Prodotto prodotto = null;
		String query = "SELECT id, nome, descrizione, prezzo FROM prodotto WHERE nome=?";
		try {
			connection = ds.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, nome);
			result = statement.executeQuery();
			if(result.next()) {// true se c'e' un altra riga
				prodotto = new Prodotto();
				prodotto.setId(result.getString("id"));
				prodotto.setNome(result.getString("nome"));
				prodotto.setDescrizione(result.getString("descrizione"));
				prodotto.setPrezzo(result.getDouble("prezzo"));
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
		return prodotto;
	}

	@Override
	public Prodotto findByID(String id) throws PersistenceException {
		Prodotto prodotto = null;
		String query = "SELECT id, nome, descrizione, prezzo FROM prodotto WHERE id=?";
		try {
			connection = ds.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, id);
			result = statement.executeQuery();
			if(result.next()) {// true se c'e' un altra riga
				prodotto = new Prodotto();
				prodotto.setId(result.getString("id"));
				prodotto.setNome(result.getString("nome"));
				prodotto.setDescrizione(result.getString("descrizione"));
				prodotto.setPrezzo(result.getDouble("prezzo"));
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
		return prodotto;
	}

	@Override
	public List<Prodotto> findAll() throws PersistenceException {
		List<Prodotto> lista = new ArrayList<Prodotto>();
		String query = "SELECT id, nome, descrizione, prezzo FROM prodotto";
		try {
			connection = ds.getConnection();
			statement = connection.prepareStatement(query);
			result = statement.executeQuery();
			while (result.next()) {// true se c'e' un altra riga
				Prodotto prodotto = new Prodotto();
				prodotto.setId(result.getString("id"));
				prodotto.setNome(result.getString("nome"));
				prodotto.setDescrizione(result.getString("descrizione"));
				prodotto.setPrezzo(result.getDouble("prezzo"));
				lista.add(prodotto);
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
}
