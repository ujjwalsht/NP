import java.io.*;
import java.net.*;

public class WebPageFetcher {
    public static void main(String[] args) {
        try {
            // Define URL
            URL url = new URL("https://www.bing.com/");
            URLConnection connection = url.openConnection();

            // Print the entire HTTP header
            System.out.println("=== HTTP Headers ===");
            for (int i = 0; ; i++) {
                String key = connection.getHeaderFieldKey(i);
                String value = connection.getHeaderField(i);
                if (key == null && value == null) break;
                System.out.println((key != null ? key + ": " : "") + value);
            }

            // Print webpage source code
            System.out.println("\n=== Webpage Source Code ===");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }

        } catch (MalformedURLException e) {
            System.err.println("Invalid URL.");
        } catch (IOException e) {
            System.err.println("Error reading data: " + e.getMessage());
        }
    }
}
