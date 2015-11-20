package Calc;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class CalculatorClient {
	public static void main(String[] args) {
		if(args.length != 3) {
			System.err.println(">>> Syntax : java CalculatorClient operand1 operator operand2");
		}
		int valueA = Integer.parseInt( args[ 0 ] );
		int valueB = Integer.parseInt( args[ 2 ] );
		char operator = args[ 1 ].charAt( 0 );

		int result = 0;
		Calculator calc = null;
		try {

			calc = ( Calculator )Naming.lookup( "rmi://localhost:1099/CalServer" );

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
