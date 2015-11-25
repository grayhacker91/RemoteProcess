

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient {
	public static void main(String[] args) {
		if(args.length != 3) {
			System.err.println(">>> Syntax : java CalculatorClient operand1 operator operand2");
		}
		if(System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}
		int valueA = Integer.parseInt( args[ 0 ] );
		int valueB = Integer.parseInt( args[ 2 ] );
		char operator = args[ 1 ].charAt( 0 );

		int result = 0;
		Calculator calc = null;
		try {
			calc = ( Calculator )Naming.lookup( "rmi://192.168.10.124:1099/CalServer" );

		} catch( NotBoundException nbe ) {

			nbe.printStackTrace();

		} catch( MalformedURLException murle ) {

			murle.printStackTrace();

		} catch( RemoteException re ) {

			re.printStackTrace();

		} // end try~catch
		
		try {
			switch( operator ) {
				case '+' :
					result = calc.add( valueA, valueB );
					break;
				case '-' :
					result = calc.subtract( valueA, valueB );
					break;
				case '*' :
					result = calc.multiply( valueA, valueB );
					break;
				case '/' :
					result = calc.divide( valueA, valueB );
			} // end switch

		} catch( RemoteException re ) {
			re.printStackTrace();
		} // end try~catch

		// 3. 출력
		System.out.println( ">>> " + valueA + " " + operator + " " + valueB + " = " + result );

	}
}
