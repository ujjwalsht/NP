import java.net.*;

public class InetAddressInfo {
    public static void main(String[] args) {
        try {
            // 1. Get IP address of a website
            InetAddress address1 = InetAddress.getByName("www.tufohss.edu.np");
            System.out.println("IP Address of www.tufohss.edu.np: " + address1.getHostAddress());

            // 2. Get local machine address
            InetAddress localAddress = InetAddress.getLocalHost();
            System.out.println("Local IP Address: " + localAddress.getHostAddress());

            // 3. Get canonical hostname
            System.out.println("Canonical Hostname: " + localAddress.getCanonicalHostName());

            // 4. Get IP and Hostname of local machine
            System.out.println("Local Hostname: " + localAddress.getHostName());

            // 5. Get IPv4 and IPv6 addresses of a website
            InetAddress[] addresses = InetAddress.getAllByName("www.google.com");
            for (InetAddress addr : addresses) {
                System.out.println("Google Address: " + addr);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
