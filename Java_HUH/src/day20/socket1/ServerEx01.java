package day20.socket1;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ServerEx01 {

	public static void main(String[] args) {
		int prot = 5001;
		
		Scanner sc = new Scanner(System.in);
		
		List<String> list = Arrays.asList("홍길동", "임껄정", "둘리", "고길동", "-1");
		try {
			ServerSocket serverSocket = new ServerSocket(prot);

			System.out.println("[대기중] ... ... ...");
			Socket socket = serverSocket.accept();
			System.out.println("[연결 성공]");
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);

			while (true) {
				String str = ois.readUTF();
				if (str.equals("-1")) {
					break;
				}
				System.out.println("클라이언트에서 보낸 문자열 : " + str);
				
			}

			String tmp = ois.readUTF();
			System.out.println("클라이언트 : " + tmp);
			System.out.println("[수신 성공]");

			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);

			String receive = ois.readUTF();
			System.out.println("클라 : " + receive);
			
			
			
			
			for (String tm2p : list) {
				oos.writeUTF(tm2p);
			}

			oos.flush();

			System.out.println("[전송 성공]");
			ois.close();
			is.close();
			oos.close();

//			os.close();

		} catch (Exception e) {
		}

	}

}
