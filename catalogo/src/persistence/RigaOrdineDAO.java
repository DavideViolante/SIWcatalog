package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Prodotto;
import model.RigaOrdine;


public class RigaOrdineDAO implements RigaOrdineRepository {
	private DataSource ds;
	private Connection connection;
	private PreparedStatement statement;
	private ResultSet result;

	public RigaOrdineDAO() {
		this.ds = new DataSource();
		this.connection = null;
		this.statement = null;
		this.result = null;
	}

	@Override
	public List<RigaOrdine> findByOrdine(OrdineProxy ordineProxy) throws PersistenceException {
		List<RigaOrdine> righe = new ArrayList<RigaOrdine>();
		String query = "SELECT * FROM ordine o JOIN riga_ordine r WHERE r.id_ordine=?";
		try {
			connection = ds.getConnection();
			statement = connection.prepareStatement(query);
			statement.setLong(1, ordineProxy.getId());
			result = statement.executeQuery();
			while (result.next()) {// true se c'e' un altra riga
				RigaOrdine r = new RigaOrdineProxy();
				r.setPrezzo(result.getDouble("prezzo"));
				r.setQuantita(result.getInt("quantita"));
				r.setIDprodotto(result.getString("nome_prodotto"));
				r.setIDordine(result.getLong("id_ordine"));
				righe.add(r);
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
		return righe;
	}
	
	@Override
	public List<RigaOrdine> findByIDOrdine(long id) throws PersistenceException {
		List<RigaOrdine> righe = new ArrayList<RigaOrdine>();
		//String query = "SELECT * FROM ordine o JOIN riga_ordine r WHERE r.id_ordine=?";
		String query = "SELECT * FROM riga_ordine WHERE id_ordine=?";
		try {
			connection = ds.getConnection();
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			result = statement.executeQuery();
			while (result.next()) {// true se c'e' un altra riga
				RigaOrdine riga = new RigaOrdine();
				riga.setPrezzo(result.getDouble("prezzo"));
				riga.setQuantita(result.getInt("quantita"));
				riga.setIDprodotto(result.getString("nome_prodotto"));
				riga.setIDordine(result.getLong("id_ordine"));
				
				ProdottoDAO pdao = new ProdottoDAO();
				Prodotto p = pdao.findByID(result.getString("nome_prodotto"));
				riga.setProdotto(p);
				
				righe.add(riga);
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
		return righe;
	}

	@Override
	public void deleteByIDOrdine(Long id) throws PersistenceException {
		String update = "DELETE FROM riga_ordine WHERE id_ordine=?";
		try {
			connection = ds.getConnection();
			statement = connection.prepareStatement(update);
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

	@Override
	public void insert(Long id, String nomeProdotto, double prezzo, int quantita) throws PersistenceException {
		String update = "INSERT INTO riga_ordine(prezzo, quantita, nome_prodotto, id_ordine) VALUES (?,?,?,?)";
		try {
			connection = ds.getConnection();
			statement = connection.prepareStatement(update);
			statement.setDouble(1, prezzo);
			statement.setLong(2, quantita);
			statement.setString(3, nomeProdotto);
			statement.setLong(4, id);
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
	public List<RigaOrdine> findAll() throws PersistenceException {
		List<RigaOrdine> righe = new ArrayList<RigaOrdine>();
		RigaOrdine riga = null;
		String query = "SELECT * FROM riga_ordine";
		try {
			connection = ds.getConnection();
			statement = connection.prepareStatement(query);
			result = statement.executeQuery();
			while (result.next()) {// true se c'e' un altra riga
				riga = new RigaOrdine();
				riga.setIDordine(result.getLong("id_ordine"));
				riga.setIDprodotto(result.getString("nome_prodotto"));
				riga.setPrezzo(result.getDouble("prezzo"));
				riga.setQuantita(result.getInt("quantita"));
				righe.add(riga);
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
		return righe;
	}

	@Override
	public Prodotto findByIDs(String idProdotto, Long idOrdine) throws PersistenceException {
		Prodotto p = null;
		String query = "SELECT nome_prodotto FROM riga_ordine WHERE nome_prodotto=? AND id_ordine=?";
		try {
			connection = ds.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, idProdotto);
			statement.setLong(2, idOrdine);
			result = statement.executeQuery();
			while (result.next()) {// true se c'e' un altra riga
				p = new Prodotto();
				p.setId(result.getString("nome_prodotto"));
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
		return p;
	}

}
