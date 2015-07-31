package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class IdBroker {
	private static Logger logger = Logger.getLogger("it.uniroma3.persistence.jdbc.IdBroker");

	private static final String query = "SELECT nextval('sequenza_id') AS id";

	public static Long getId(Connection connection) throws PersistenceException {
		long id = -1;
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			result.next();
			id = result.getLong("id");
		} catch (SQLException e) {
			logger.severe("Errore SQL: " + e.getMessage());
			throw new PersistenceException(e.getMessage());
		}
		return new Long(id);
	}
}



