package ar.edu.unlp.oo1.ejercicio1.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;

import ar.edu.unlp.oo1.ejercicio1.impl.FilterHandler;
import ar.edu.unlp.oo1.ejercicio1.impl.JsonFormatter;
import ar.edu.unlp.oo1.ejercicio1.impl.UpperCaseFormatter;
import ar.edu.unlp.oo1.ejercicio1.ui.WallPostUI;

public class Ejercicio1Application {
	public static void main(String[] args) throws SecurityException, IOException {
		Logger modelLogger = Logger.getLogger("WallPostImpl"); // toma el log de WallPostImpl 
		FileHandler fileHandler = new FileHandler("wallpost-log.txt", true); // creacion de handler
		modelLogger.addHandler(fileHandler); // agrega el handler
		fileHandler.setFormatter(new java.util.logging.SimpleFormatter()); // formato simple
		
		Logger uiLogger = Logger.getLogger("WallPostUI"); // Contiene unicamente los logs de INFO
		FileHandler uiFileHandler = new FileHandler("wallpost-ui-log.txt", true);
		uiLogger.addHandler(uiFileHandler);
		uiFileHandler.setFormatter(new java.util.logging.SimpleFormatter());
		
		uiLogger.info("Inicio de la aplicación WallPost.");
		
		//---------------------- PARTE B i)
		
		FileHandler jsonHandler = new FileHandler("json-log.txt", true);
		FileHandler upperHandler = new FileHandler("upper-log.txt", true);
		
		uiLogger.addHandler(jsonHandler);
		uiLogger.addHandler(upperHandler);
		
		jsonHandler.setFormatter(new JsonFormatter());
		upperHandler.setFormatter(new UpperCaseFormatter());
		
		//---------------------- PARTE B ii)
		Logger filteredLogger = Logger.getLogger("FilteredLogger");
		filteredLogger.setUseParentHandlers(false);

		FileHandler baseHandler = new FileHandler("filtered-log.txt", true);
		baseHandler.setFormatter(new java.util.logging.SimpleFormatter());
		
		ArrayList<String> words = new ArrayList<>();
		words.add("switch-statements");
		words.add("goto");
		FilterHandler filterHandler = new FilterHandler(baseHandler, words);

		filteredLogger.addHandler(filterHandler);

		filteredLogger.info("I love switch-statements but hate goto");
		
		// ---

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new WallPostUI();
			}
		});
	}

}
