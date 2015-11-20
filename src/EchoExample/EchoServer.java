package EchoExample;

import java.rmi.*;
import java.net.*;

// 3. Server Application 제작
public class EchoServer {
	public static void main(String[] args) {
		try{
			EchoImpl echo = new EchoImpl();
			System.out.println("원격객체 생성");
			Naming.rebind("Echo", echo);  // Remote Object를 Naming server에 등록시킴
			System.out.println("네이밍 서버에 등록!!!");
		}catch (RemoteException re){
			System.out.println("원격 객체 생성 실패 or Naming서버 찾지 못함");
		}catch (MalformedURLException me){
			System.out.println("Naming서버의 URL 형식이 다름.");
		}
	}
}