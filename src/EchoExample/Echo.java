package EchoExample;

import java.rmi.*;

public interface Echo extends Remote{
	public String sayEcho(String str) throws RemoteException;
}
