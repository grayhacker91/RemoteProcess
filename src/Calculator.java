

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
	public int add(int valueA, int valueB) throws RemoteException;
	public int subtract(int valueA, int valueB) throws RemoteException;
	public int multiply(int valueA, int valueB) throws RemoteException;
	public int divide(int valueA, int valueB) throws RemoteException;
}
