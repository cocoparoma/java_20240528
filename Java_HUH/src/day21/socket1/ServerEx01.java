package day21.socket1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerEx01 {

	public static void main(String[] args) {
		int port = 5001;
		String file = "src/day21/socket1/Server.txt";
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			while (true) {
				Socket socket = serverSocket.accept();

				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

				String type = ois.readUTF();

				switch (type) {
				case "save":
					receive(ois, file);
					break;
				case "load":
					send(oos, file);
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + type);
				}

			}
		} catch (Exception e) {
		}

	}

	private static void send(ObjectOutputStream oos, String file) throws IOException {
		try (FileInputStream fis = new FileInputStream(file); ObjectInputStream fois = new ObjectInputStream(fis);) {
			List<String> list = (List<String>) fois.readObject();
			oos.writeObject(list);
			oos.flush();
		} catch (Exception e) {
			oos.writeObject(new ArrayList<String>());
			oos.flush();
		}
		System.out.println("[클라이언트가 불러오기를 했습니다.]");
	}

	@SuppressWarnings("unchecked")
	private static void receive(ObjectInputStream ois, String file) {// 내부저장
		List<String> list = null;
		try {
			list = (List<String>) ois.readObject();
		} catch (Exception e) {
			// 클라이언트가 저장할 리스트를 전송하지 않으면
			// 강제 종료할 예외가 발생해서
			// 저장할 리스트가 없기 때문에 종료됨
			return;
		}
		// 가지고 온 리스트를 파일에 저장함
		try (FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream foos = new ObjectOutputStream(fos);) {
			foos.writeObject(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("[파일 저장 완료]");
	}

}
