package ar.edu.unlp.oo1.ejercicio1.app;

import java.io.IOException;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;

import ar.edu.unlp.oo1.ejercicio1.impl.EmailHandler;
import ar.edu.unlp.oo1.ejercicio1.ui.WallPostUI;

public class Ejercicio1ApplicationMail {
	public static void main(String[] args) throws SecurityException, IOException {
		Logger mailLogger = Logger.getLogger("MailLogger");
		mailLogger.setUseParentHandlers(false);
		
		EmailHandler emailHandler = new EmailHandler();
		mailLogger.addHandler(emailHandler);
		
		mailLogger.warning("Prueba de log warning");
		mailLogger.info("Prueba de log info");
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new WallPostUI();
			}
		});
	}
}
