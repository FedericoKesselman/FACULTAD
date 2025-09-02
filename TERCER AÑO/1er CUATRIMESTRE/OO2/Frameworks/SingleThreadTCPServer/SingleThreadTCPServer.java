import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class SingleThreadTCPServer {

    public abstract void handleMessage(String message, PrintWriter out);

    public final void startLoop(String[] args) {
        checkArguments(args);

        int portNumber = Integer.parseInt(args[0]);

    
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            displaySocketInformation(portNumber);
            while (true) {
                Socket clientSocket = acceptAndDisplaySocket(serverSocket);
                handleClient(clientSocket);
            }
        } catch (IOException e) {
            displayAndExit(portNumber);
        }
    }

    protected void displayAndExit(int portNumber) {
        System.err.println("Could not listen on port " + portNumber);
        System.exit(-1);
    }

    protected Socket acceptAndDisplaySocket(ServerSocket serverSocket) throws IOException {
        Socket clientSocket = serverSocket.accept();
        displaySocketData(clientSocket);
        return clientSocket;
    }

    protected void displaySocketData(Socket clientSocket) {
        System.out.println("Client connected from: " + clientSocket.getInetAddress().getHostAddress() + ":"
                + clientSocket.getPort());
    }

    protected void displaySocketInformation(int portNumber) {
        System.out.println(this.getClass().getName() + " server listening on port: " + portNumber);
    }

    protected void checkArguments(String[] args) {
        if (args.length != 1) {
            displayUsage();
            System.exit(1);
        }
    }

    protected void displayUsage() {
        System.err.println("Usage: java"+this.getClass().getName() +"<port number>");
    }

    

    private final void handleClient(Socket clientSocket) {
        
        try (
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        	)
        	{
        	
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
            	messageReceived(clientSocket, inputLine); // Hook
                
                if (shouldCloseConnection(inputLine, clientSocket)) {
                    break;
                }
                handleMessage(inputLine, out);
            }
            
            closeConnection(clientSocket); // Hook
        } 
        
        catch (IOException e) {
        	errorMessageClient(clientSocket, e); // Hook
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
            	errorMessageSocket(clientSocket, e); // Hook
            }
        }
    }

	protected void messageReceived(Socket clientSocket, String inputLine) {
		System.out.println("Received message: " + inputLine + " from "
                + clientSocket.getInetAddress().getHostAddress() + ":" + clientSocket.getPort());
	}
	
	protected void closeConnection(Socket clientSocket) {
		System.out.println("Connection closed with " + clientSocket.getInetAddress().getHostAddress() + ":"
                + clientSocket.getPort());
	}
	
	protected void errorMessageClient(Socket clientSocket, IOException e) {
		System.err.println("Problem with communication with client: " + e.getMessage());
	}
	
	private void errorMessageSocket(Socket clientSocket, IOException e) {
		System.err.println("Error closing socket: " + e.getMessage());
	}
	
	protected boolean shouldCloseConnection(String message, Socket clientSocket) {
	    return message.equalsIgnoreCase(this.disconnectWord());
	}
	
	protected String disconnectWord() {
	    return "";
	}
}
