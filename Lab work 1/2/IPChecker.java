import java.net.*;

public class IPChecker {
    public static void main(String[] args) {
        try {
            // 6. Check if IP is IPv4 or IPv6
            InetAddress ip = InetAddress.getByName("2607:f8b0:4005:80a::200e"); // Example IPv6
            if (ip.getHostAddress().contains(":")) {
                System.out.println("It is an IPv6 address.");
            } else {
                System.out.println("It is an IPv4 address.");
            }

            // 7. Test IP characteristics
            System.out.println("Is Loopback? " + ip.isLoopbackAddress());

            // 8. Compare domain names
            InetAddress domain1 = InetAddress.getByName("www.google.com");
            InetAddress domain2 = InetAddress.getByName("www.facebook.com");
            System.out.println("Are domains same? " + domain1.equals(domain2));

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
