import java.io.PrintWriter;

public class RepeatServer extends SingleThreadTCPServer{

	@Override
	public void handleMessage(String message, PrintWriter out) {
		String[] args = message.split(" ");
		
		if (args.length < 2) {
	        out.println("Error: Faltan argmunetos.");
	        return;
	    } 
		
		if (args[0] == null) {
	        out.println("Error: El string a repetir no puede ser vacio.");
	        return;
	    } 
		
		String cadena = args[0];
		String cantVeces = args[1];
		String delimitador = (args.length == 3) ? args[2] : " ";
		
		
		out.println("String repetido: " + stringLogic(cadena, cantVeces, delimitador));
	}
	
	private String stringLogic(String cadena, String cantVeces, String delimitador) {
		int repeticiones;
		
		try {
			repeticiones = Integer.parseInt(cantVeces);
			
			if (repeticiones <= 0) 
				return "Error: la cantidad de repeticiones debe ser mayor a 0";
		} catch (NumberFormatException e) {
			return "Error: El segundo argumento debe ser un numero";
		}
		
		StringBuilder resultado = new StringBuilder();
		
		for (int i=0; i<repeticiones; i++) {
			resultado.append(cadena);
			 
			if(i < repeticiones-1)
				resultado.append(delimitador);
		}
		return resultado.toString();
	}

	public static void main(String[] args) {
        new RepeatServer().startLoop(args);
    }
}
