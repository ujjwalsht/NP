import java.net.*;

public class URLProgram1 {
    public static void main(String[] args) {
        try {
            // Splitting URL parts
            URL url = new URL("https://www.example.com:8080/path/to/resource?query=java#fragment");
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());
            System.out.println("Path: " + url.getPath());

            // Checking protocol support
            if ("https".equals(url.getProtocol())) {
                System.out.println("HTTPS is supported!");
            }

            // Resolving relative URI
            URI baseURI = new URI("https://www.example.com/path/");
            System.out.println("Resolved URI: " + baseURI.resolve("resource.html"));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
