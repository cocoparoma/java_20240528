package day20.socket1;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ClientEx01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ip = "192.168.30.205";
		int port = 5001;
		
		List<String> list = Arrays.asList("23", "100", "23","-1");
		System.out.println("[서버 연결 요청]");
		try (Socket socket = new Socket(ip, port)){
			System.out.println("[서버 연결 완료]");
			
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			
			System.out.print("전송할 내용 : ");
			String send = sc.nextLine();
			oos.writeUTF(send);
			
			for (String tmp : list) {
				oos.writeUTF(tmp);
			}
			oos.flush();


			
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			
			String receive = ois.readUTF();
			System.out.println("서버 : " + receive);
			
			while (true) {
				String tmp = ois.readUTF();
				if (tmp.equals("-1")) {
					break;
				}
				System.out.println("서버에서 보낸 문자열 : " + tmp);
			}
			System.out.println("[수신 완료]");
			oos.close();
			ois.close();
//			os.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
 	
	
	}
	
}
