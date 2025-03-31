import java.io.*;
import java.net.*;
import java.util.*;

public class URLFetcher {
    public static void main(String[] args) {
        try {
            // Define URL
            URL url = new URL("https://tufohss.edu.np/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method to HEAD
            connection.setRequestMethod("HEAD");

            // Print last modified date
            System.out.println(url + " was last modified at: " + new Date(connection.getLastModified()));

            // Print the URL of the connection
            System.out.println("\nConnection URL: " + connection.getURL());

        } catch (MalformedURLException e) {
            System.err.println("Invalid URL.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
