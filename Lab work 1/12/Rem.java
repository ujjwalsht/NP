import java.rmi.*;

public interface Rem extends Remote {
    public int addNum(int a, int b) throws RemoteException;
    public int subNum(int a, int b) throws RemoteException;
}
