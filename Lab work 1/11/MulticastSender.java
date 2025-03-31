import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MulticastSender {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress group = InetAddress.getByName("230.0.0.1");
        String message = "Hello Multicast!";
        byte[] buffer = message.getBytes();
        
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, 4446);
        socket.send(packet);
        socket.close();
        
        System.out.println("Message Sent!");
    }
}
