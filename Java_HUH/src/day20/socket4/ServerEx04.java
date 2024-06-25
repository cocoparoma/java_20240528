package day20.socket4;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx04 {

	public static void main(String[] args) {
		int port = 5001;
		try{
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("[waiting]");
			Socket socket = serverSocket.accept();
			System.out.println("[connected]");
			Client client = new Client(socket);
			client.send();
			client.recive();
		} catch (Exception e) {
		}
	}

}
