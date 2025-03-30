import java.rmi.registry.*;
import java.util.*;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first number:");
        int a = sc.nextInt();

        System.out.println("Enter second number:");
        int b = sc.nextInt();

        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 8888);
            Rem remoteObj = (Rem) reg.lookup("Rem");

            System.out.println("Sum: " + remoteObj.addNum(a, b));
            System.out.println("Difference: " + remoteObj.subNum(a, b));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
