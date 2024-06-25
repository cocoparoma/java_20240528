package day20.socket5;

import java.net.Socket;
import java.util.Scanner;

public class ClientEx05 {

	public static void main(String[] args) {
		int port = 5001;
//		String ip = "192.168.30.205";
		String ip = "192.168.30.199";//교수님 아이피
		try {
			System.out.println("아이디 입력");
			Scanner sc = new Scanner(System.in);
			String id = sc.next();
			Socket socket = new Socket(ip, port);
			System.out.println("연결성공");
			Client client = new Client(id, socket);
			client.recive();//쓰레드임
			client.send();//쓰레드임
		} catch (Exception e) {
			System.out.println("서버가 종료됨");
			e.printStackTrace();
		}

	}

}