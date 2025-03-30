import java.net.*;
import java.util.*;

public class NetworkInfo {
    public static void main(String[] args) {
        try {
            // 9. List all network interfaces
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface ni = interfaces.nextElement();
                System.out.println("Network Interface: " + ni.getName());
            }

            // 10. Use network interface getter methods
            NetworkInterface netInt = NetworkInterface.getByName("eth0");
            if (netInt != null) {
                System.out.println("Interface Display Name: " + netInt.getDisplayName());
            }

            // 11. Check if a remote system is reachable
            InetAddress remote = InetAddress.getByName("www.google.com");
            System.out.println("Is Google reachable? " + remote.isReachable(2000));

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
