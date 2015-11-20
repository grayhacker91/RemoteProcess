package Calc;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class CalculatorServer {
	public static void main(String[] args) {
		try {
			Calculator calc = new CalculatorImpl();
			Naming.rebind("rmi://localhost:1099/CalServer", calc);
		}catch(RemoteException re) {
			re.printStackTrace();
		}catch(MalformedURLException murle) {
			murle.printStackTrace();
		}
	}
}
