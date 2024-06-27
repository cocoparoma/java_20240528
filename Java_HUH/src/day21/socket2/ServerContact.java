package day21.socket2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerContact {

	public static void main(String[] args) {
		int PORT = 5101;
		String IP = "127.0.0.1";
		String file = "src/day21/socket2/Server.txt";
		ServerSocket serverSocket;
		Socket socket;

		try {
			serverSocket = new ServerSocket(PORT);
			System.out.println("[server On]");
			while (true) {
				socket = serverSocket.accept(); // 클라이언트 대기
				System.out.println("[" + socket.getInetAddress() + " Join] ");

				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

				String type = ois.readUTF();
				
//				switch (type) {
//				case "save":
//					saveServer(ois, file);
//					break;
//				case "load":
//					loadServer(oos, file);
//					break;
//				}
				
				if (type.equals("save"))
					saveServer(ois, file);
				else if (type.equals("load"))
					loadServer(oos, file);

			}
		} catch (IOException e) {
			System.out.println("[Exit]");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private static void saveServer(ObjectInputStream ois, String file) {// 이쪽 스트림은 소켓에서 가져온거
		List<Ccontact> list;
		try {
			list = (List<Ccontact>) ois.readObject(); // 스트링 변경해야함
		} catch (Exception e) {
			return;
		}
		try(ObjectOutputStream foos = new ObjectOutputStream( new FileOutputStream(file));) {
			list = (List<Ccontact>) ois.readObject();
			foos.writeObject(list);
			foos.flush();
		} catch (Exception e) {

		}
		System.out.println("[saved]");
	}

	@SuppressWarnings("unchecked")
	private static void loadServer(ObjectOutputStream oos, String file)  {
		List<Ccontact> list = new ArrayList<Ccontact>();
		try (ObjectInputStream fois = new ObjectInputStream(new FileInputStream(file))){
			list = (List<Ccontact>) fois.readObject();
		} catch (Exception e) {
		}
		try {
			oos.writeObject(list);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("[LOAD]");
	}

}
