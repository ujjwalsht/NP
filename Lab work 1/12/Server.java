import java.rmi.*;
import java.rmi.registry.*;

public class Server {
    public static void main(String args[]) {
        try {
            Rem_impl obj = new Rem_impl();
            Registry reg = LocateRegistry.createRegistry(8888);
            reg.rebind("Rem", obj);

            System.out.println("Server is ready...");
        } catch (RemoteException e) {
            System.out.println(e);
        }
    }
}
