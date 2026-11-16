import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Conversor extends Remote {
    double aFahrenheit(double celsius) throws RemoteException;
}
