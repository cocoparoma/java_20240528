package day20.socket4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Client {

	private Socket socket;
	public final static String EXIT = "-1";

	// 소켓에서 보내온 문자열을 받아서 출력하는 쓰레드를 생성하고 실행하는 메소드
	public void recive() {
		Thread t = new Thread(() -> {
			try {
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				while (true) {
					String chat = ois.readUTF();
					if (chat.equals(EXIT))  break;
					System.out.println("▶" + chat);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		t.start();
	}
	//문자열을 입력해서 소켓으로 전송하는 쓰레드를 생성하고 실행하는 메소드
	
	public void send() {
		Thread t = new Thread(()->{
			try {
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				Scanner sc = new Scanner(System.in);
				while (true) {
					String str = sc.nextLine();
					oos.writeUTF(str);
					oos.flush();//입력버퍼 있던 없던 비워라는 뜻
					if (str.equals(EXIT)) break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		t.start();
	}
	
	
	
	
}

