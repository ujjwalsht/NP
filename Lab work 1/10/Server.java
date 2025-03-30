import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(12345);
        byte[] buffer = new byte[1024];
        
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        System.out.println("Server is waiting for data...");
        socket.receive(packet);

        String received = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Received message: " + received);
        
        socket.close();
    }
}
