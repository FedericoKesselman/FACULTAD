package ar.edu.unlp.info.oo2.accesobd;
import java.util.logging.Level;


import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

public class DatabaseAccessProxy implements DatabaseAccess{
	private static final Logger logger = Logger.getLogger("DatabaseAccessProxy Log");

	private DatabaseAccess realDatabase;
	private int password;
	private boolean isLoggedIn;
	
	public DatabaseAccessProxy (DatabaseAccess realDatabase, int password) {
		this.realDatabase = realDatabase;
		this.password = password;
		this.isLoggedIn = false;
	}
	
	@Override
	public Collection<String> getSearchResults(String queryString) {
		if (this.isLoggedIn) {
			logger.log(Level.INFO, "Acceso válido a búsqueda con query: " + queryString);
			return this.realDatabase.getSearchResults(queryString);
		}
		else {
			logger.log(Level.SEVERE, "Usuario no logueado.");
			return null;
		}
	}

	@Override
	public int insertNewRow(List<String> rowData) {
		if (this.isLoggedIn) {
			logger.log(Level.WARNING, "Inserción realizada correctamente: " + rowData);
			return this.realDatabase.insertNewRow(rowData);
		}
		else {
			logger.log(Level.SEVERE, "Usuario no logueado.");
			return 0;
		}
	}
	
	public void logIn(int password) {
		if (password == this.password) 
			this.isLoggedIn = true;
	}
}
