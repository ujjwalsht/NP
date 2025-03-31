import java.io.*;
import java.net.*;

public class SocketChat {
    public static void main(String[] args) {
        new Thread(() -> startServer()).start(); // Start server in a separate thread
        startClient(); // Start client
    }

    public static void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(8888)) {
            System.out.println("Server START...");
            Socket socket = serverSocket.accept();
            System.out.println("Client Connected...");
            DataInputStream din = new DataInputStream(socket.getInputStream());
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            String msg;
            do {
                msg = din.readUTF();
                System.out.println("Client Message: " + msg);
                dout.writeUTF("Server received: " + msg);
                dout.flush();
            } while (!msg.equalsIgnoreCase("stop"));
        } catch (Exception e) {
            System.out.println("Server Error: " + e);
        }
    }

    public static void startClient() {
        try (Socket socket = new Socket("127.0.0.1", 8888);
             DataInputStream din = new DataInputStream(socket.getInputStream());
             DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Server Connected...");
            String msg;
            do {
                msg = br.readLine();
                dout.writeUTF(msg);
                dout.flush();
                System.out.println("Server Message: " + din.readUTF());
            } while (!msg.equalsIgnoreCase("stop"));
        } catch (Exception e) {
            System.out.println("Client Error: " + e);
        }
    }
}