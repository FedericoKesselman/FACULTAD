package tcp.server.reply;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PasswordHandler implements IMessageHandler {

	@Override
	public void handleMessage(String message, PrintWriter out) {
		String[] args = message.split(" ");
		
		if (args.length != 3) {
	        out.println("Error: Se deben enviar 3 parámetros.");
	        return;
	    }
		
		String caracteres = args[0];
		String numeros = args[1];
		String especiales = args[2];
		
		if (caracteres.isEmpty() || numeros.isEmpty() || especiales.isEmpty()) {
		    out.println("Error: Ningún parámetro puede estar vacío.");
		    return;
		}
		
		out.println("Constraseña: " + passwordLogic(caracteres, numeros, especiales));
	}
	
	private String passwordLogic(String letras, String numeros, String especiales) {
	    Random random = new Random();
	    StringBuilder password = new StringBuilder();

	    // 1 número random
	    char numero = numeros.charAt(random.nextInt(numeros.length()));
	    
	    // 1 carácter especial random
	    char especial = especiales.charAt(random.nextInt(especiales.length()));
	    
	    // Seleccionar 6 letras random 
	    List<Character> chars = new ArrayList<>();
	    for (int i = 0; i < 6; i++) {
	        chars.add(letras.charAt(random.nextInt(letras.length())));
	    }

	    chars.add(numero);
	    chars.add(especial);

	    // mezcla de caracteres
	    Collections.shuffle(chars);
	    
	    for (char c : chars) {
	        password.append(c);
	    }

	    return password.toString();
	}
}
