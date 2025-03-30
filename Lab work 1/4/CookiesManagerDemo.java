import java.net.*;
import java.util.*;

public class CookiesManagerDemo {
    public static void main(String[] args) {
        CookieManager cookieManager = new CookieManager();
        CookieStore cookieStore = cookieManager.getCookieStore();

        // Creating cookies and URI
        HttpCookie cookieA = new HttpCookie("First", "1");
        HttpCookie cookieB = new HttpCookie("Second", "2");
        URI uri = URI.create("https://www.ambition.edu.np/");

        // Method 1 - add(URI uri, HttpCookie cookie)
        cookieStore.add(uri, cookieA);
        cookieStore.add(null, cookieB);
        System.out.println("Cookies successfully added\n");

        // Method 2 - get(URI uri)
        List<HttpCookie> cookiesWithURI = cookieStore.get(uri);
        System.out.println("Cookies associated with URI in CookieStore: " + cookiesWithURI + "\n");

        // Method 3 - getCookies()
        List<HttpCookie> cookieList = cookieStore.getCookies();
        System.out.println("Cookies in CookieStore: " + cookieList + "\n");

        // Method 4 - getURIs()
        List<URI> uriList = cookieStore.getURIs();
        System.out.println("URIs in CookieStore: " + uriList + "\n");

        // Method 5 - remove(URI uri, HttpCookie cookie)
        System.out.println("Removal of Cookie: " + cookieStore.remove(uri, cookieA));
        List<HttpCookie> remainingCookieList = cookieStore.getCookies();
        System.out.println("Remaining Cookies: " + remainingCookieList + "\n");

        // Method 6 - removeAll()
        System.out.println("Removal of all Cookies: " + cookieStore.removeAll());
        List<HttpCookie> emptyCookieList = cookieStore.getCookies();
        System.out.println("Empty CookieStore: " + emptyCookieList);
    }
}