

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorImpl extends UnicastRemoteObject implements Calculator{
	public CalculatorImpl() throws RemoteException {}
	public int add(int valueA, int valueB) {
		return valueA+valueB;
	}
	public int subtract(int valueA, int valueB) {
		return valueA-valueB;
	}
	public int multiply(int valueA,int valueB) {
		return valueA*valueB;
	}
	public int divide(int valueA, int valueB) {
		return valueA/valueB;
	}
}
