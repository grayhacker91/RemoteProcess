package EchoExample;

import java.net.*;
import java.rmi.*;

//4. Client Application 제작
public class EchoClient
{
	public static void main(String[] args) 
	{
		try{
			Echo echo = (Echo)Naming.lookup("Echo");
			// 리턴타입은 Object이기 때문에 Echo로 캐스팅
			System.out.println("네이밍 서버로부터 원격객체 리턴");
			String result = echo.sayEcho("Distributed Computing");
			System.out.println(result);
		}catch (NotBoundException ne){
			System.out.println("Naming 서버에 원격객체 등록 되지 않음.");
		}catch (MalformedURLException me){
			System.out.println("URL 형식이 RMI 호출 형식이 아님.");
		}catch (RemoteException re){
			System.out.println("원격 객체를 호출하지 못함.");
		}
	}
}
