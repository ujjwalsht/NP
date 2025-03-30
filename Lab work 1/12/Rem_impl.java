import java.rmi.*;
import java.rmi.server.*;

public class Rem_impl extends UnicastRemoteObject implements Rem {
    public Rem_impl() throws RemoteException {
        super();
    }

    public int addNum(int a, int b) throws RemoteException {
        return a + b;
    }

    public int subNum(int a, int b) throws RemoteException {
        return a - b;
    }
}
