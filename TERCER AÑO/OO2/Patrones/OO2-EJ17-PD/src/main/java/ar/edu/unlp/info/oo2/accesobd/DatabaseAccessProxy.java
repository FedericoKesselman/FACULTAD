package ar.edu.unlp.info.oo2.accesobd;

import java.util.Collection;
import java.util.List;

public class DatabaseAccessProxy implements DatabaseAccess{
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
		if (this.isLoggedIn) 
			return this.realDatabase.getSearchResults(queryString);
		else
			return null;
	}

	@Override
	public int insertNewRow(List<String> rowData) {
		if (this.isLoggedIn) 
			return this.realDatabase.insertNewRow(rowData);
		else
			return 0;
	}
	
	public void logIn(int password) {
		if (password == this.password) 
			this.isLoggedIn = true;
	}
}
