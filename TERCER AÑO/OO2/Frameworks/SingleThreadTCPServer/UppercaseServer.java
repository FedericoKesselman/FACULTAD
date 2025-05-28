import java.io.PrintWriter;
import java.net.Socket;

// Clase de prueba para extender el Framework
public class UppercaseServer extends SingleThreadTCPServer {

	@Override
	public void handleMessage(String message, PrintWriter out) {
		out.println(message.toUpperCase());
	}

	public static void main(String[] args) {
        new UppercaseServer().startLoop(args);
    }
	
	@Override
	protected String disconnectWord() {
		return "UP close";
	} 
	/*
	 *  Implemento la opcion 3, ya que considero que es muy simple de aplicar, aprovechando el método hook shouldCloseConnection().
	 *  Es fácil de utilizar para otros programadores (simplemente redefinir el método disconnectWord(). No es tan flexible
	 *  como un Strategy, pero la considero adecuada para este Framework.
	 */
}

