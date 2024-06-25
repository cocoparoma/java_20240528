package day20.socket3;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerEx03 {

	public static void main(String[] args) {
		// 포트설정
		int port = 5001;
		String ip = "192.168.30.205";
		try {
			// 서버용 소켓 객체 생성
			ServerSocket serverSocket = new ServerSocket(port);
			// 대기 및 연결 요청 수락 후 소켓 객체 생성
			Socket socket = serverSocket.accept();
			System.out.println("[연결됨]");
			// 클라가 보낸 문자열 읽어와서 출력
			Thread reveiveThread = new Thread(() -> {
				try {
					InputStream is = socket.getInputStream();
					ObjectInputStream ois = new ObjectInputStream(is);
					while (true) {
						String chat = ois.readUTF();
						System.out.println(chat);
						if (chat.equals("-1")) {
							System.out.println("클라이언트가 전송을 중단함");
							break;
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
				}

			});
			reveiveThread.start();
			// 서버에서 콘솔창에 값 입력 >클라로 전송

		} catch (Exception e) {
			System.out.println("예외발생");
		}

		try {
			Socket socket = new Socket(ip, port);
			System.out.println("<연결 성공>");
			// 서버로 콘솔에서 입력한 내용을 전달하는 쓰레드
			Thread sendThread = new Thread(() -> {
				try {
					OutputStream os = socket.getOutputStream();
					ObjectOutputStream oos = new ObjectOutputStream(os);

					Scanner sc = new Scanner(System.in);

					while (true) {
						String str = sc.nextLine();
						oos.writeUTF(str);
						oos.flush();
						if (str.equals("-1")) {
							System.out.println("전송기능 중단");
							break;
						}
					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			});
			sendThread.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
