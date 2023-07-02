import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("New connection accepted");
            System.out.println("Server started on port " + PORT);

            Socket clientSocket = serverSocket.accept();
            System.out.println("New connection accepted from port " + clientSocket.getPort());

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String receivedMessage = in.readLine();
            System.out.println("Received message: " + receivedMessage);

            out.println("Message received successfully!");

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}