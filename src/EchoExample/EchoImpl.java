package EchoExample;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class EchoImpl extends UnicastRemoteObject implements Echo{
	public EchoImpl() throws RemoteException {
		System.out.println("EchoImpl()호출");
	}
	public String sayEcho(String str) throws RemoteException {
		return "Hello~" + str;
	}
}
