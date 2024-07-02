package day20.socket5;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerEx05 {

	public static void main(String[] args) {
		int port = 5001;
		List<ObjectOutputStream> list = new ArrayList<ObjectOutputStream>();
		ServerSocket serverSocket ;
		try {
			serverSocket = new ServerSocket(port);
			while (true) {
				
				Socket socket = serverSocket.accept();
				System.out.println("[connected]");
				Server server = new Server(list, socket);
				server.recive();
			}
		} catch (Exception e) {
		}

	}

}
