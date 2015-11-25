package Calc;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

@SuppressWarnings("deprecation")
public class CalculatorServer {
	public static void main(String[] args) {
		try {
			if(System.getSecurityManager() == null) {
				System.setSecurityManager(new RMISecurityManager());
			}
			Calculator calc = new CalculatorImpl();
			Naming.rebind("CalServer", calc);
		}catch(RemoteException re) {
			re.printStackTrace();
		}catch(MalformedURLException murle) {
			murle.printStackTrace();
		}
	}
}
