import java.io.*;
import java.net.*;

public class URLProgram2 {
    public static void main(String[] args) {
        try {
            // Downloading a web page
            URL url = new URL("https://www.example.com");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            System.out.println("Web page content:");
            System.out.println(in.readLine());
            in.close();

            // Demonstrating form encoding
            String form = "name=John+Doe&age=25";
            System.out.println("Decoded form: " + URLDecoder.decode(form, "UTF-8"));

            // Sending a GET request
            URL getRequest = new URL("https://www.example.com?search=java");
            BufferedReader reader = new BufferedReader(new InputStreamReader(getRequest.openStream()));
            System.out.println("Response: " + reader.readLine());
            reader.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
