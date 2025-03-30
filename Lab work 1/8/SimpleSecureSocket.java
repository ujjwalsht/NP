import java.io.*;
import javax.net.ssl.*;
import java.util.concurrent.CountDownLatch;

public class SimpleSecureSocket {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(1);
        new Thread(() -> {
            startServer();
            latch.countDown();
        }).start(); // Start Server

        try {
            latch.await(); // Wait for server to start
            startClient(); // Start Client
            connectToTufohss(); // Connect to tufohss.edu.np
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted: " + e.getMessage());
        }
    }

    // Secure Server
    public static void startServer() {
        try (SSLServerSocket server = (SSLServerSocket) SSLServerSocketFactory.getDefault().createServerSocket(9999)) {
            System.out.println("Server started...");
            try (SSLSocket client = (SSLSocket) server.accept();
                 PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {
                out.println("Hello from Server!");
            }
        } catch (IOException e) {
            System.err.println("Server Error: " + e.getMessage());
        }
    }

    // Secure Client
    public static void startClient() {
        try (SSLSocket socket = (SSLSocket) SSLSocketFactory.getDefault().createSocket("localhost", 9989);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            System.out.println("Server says: " + in.readLine());
        } catch (IOException e) {
            System.err.println("Client Error: " + e.getMessage());
        }
    }

    // Connect to tufohss.edu.np
    public static void connectToTufohss() {
        try (SSLSocket socket = (SSLSocket) SSLSocketFactory.getDefault().createSocket("tufohss.edu.np", 443);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            out.println("GET / HTTP/1.1\r\nHost: tufohss.edu.np\r\n\r\n");
            System.out.println("Response: " + in.readLine());
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}