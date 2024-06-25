package day20.socket3;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientEx03 {

	public static void main(String[] args) {
		int port = 5001;
		String ip = "192.168.30.205";

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
