package day20.socket4;

import java.net.Socket;

public class ClientEx04 {

	public static void main(String[] args) {
		int port = 5001;
		String ip = "192.168.30.205";

		try {
			Socket socket = new Socket(ip, port);
			System.out.println("연결성공");
			Client client = new Client(socket);
			client.recive();//쓰레드임
			client.send();//쓰레드임
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
