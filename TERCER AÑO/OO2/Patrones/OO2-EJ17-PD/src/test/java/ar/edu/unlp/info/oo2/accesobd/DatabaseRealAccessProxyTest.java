package ar.edu.unlp.info.oo2.accesobd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DatabaseRealAccessProxyTest {
	private DatabaseAccess database;
	private DatabaseAccessProxy databaseProxy;
	
	@BeforeEach
    void setUp() throws Exception {
		this.database = new DatabaseRealAccess();
        this.databaseProxy = new DatabaseAccessProxy(database, 5555);
    }
	
	@Test
    void testGetSearchResultsLoggedIn() {
		this.databaseProxy.logIn(5555);
        assertEquals(Arrays.asList("Spiderman", "Marvel"), this.databaseProxy.getSearchResults("select * from comics where id=1"));
        assertEquals(Collections.emptyList(), this.databaseProxy.getSearchResults("select * from comics where id=10"));
    }
	
	@Test
    void testGetSearchResultsNotLoggedIn() {
        assertEquals(null, this.databaseProxy.getSearchResults("select * from comics where id=1"));
        assertEquals(null, this.databaseProxy.getSearchResults("select * from comics where id=10"));
    }

    @Test
    void testInsertNewRowLoggedIn() {
    	this.databaseProxy.logIn(5555);
        assertEquals(3, this.databaseProxy.insertNewRow(Arrays.asList("Patoruzú", "La flor")));
        assertEquals(Arrays.asList("Patoruzú", "La flor"), this.databaseProxy.getSearchResults("select * from comics where id=3"));
    }	
    
    @Test
    void testInsertNewRowNotLoggedIn() {
        assertEquals(0, this.databaseProxy.insertNewRow(Arrays.asList("Patoruzú", "La flor")));
        assertEquals(null, this.databaseProxy.getSearchResults("select * from comics where id=3"));
    }	
}
