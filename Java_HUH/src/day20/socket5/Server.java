package day20.socket5;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Server {
	private List<ObjectOutputStream> list = new ArrayList<ObjectOutputStream>();
	private Socket socket;

	public void recive() {
		Thread t = new Thread(() -> {
			String id = "";
			try {
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				list.add(oos);
				while (true) {
					id = ois.readUTF();
					String chat = ois.readUTF();
					System.out.println(id + "▶" + chat);
					for (ObjectOutputStream tmp : list) {
						// 메세지를 보낸 소켓을 제외한 다른 소켓에 메세지를 전송한다.
						if (tmp != oos) {
							send(tmp, id, chat);
						}
					}
				}
			} catch (IOException e) {
				System.out.println(id + "이/가 퇴장함");
			} catch (Exception e) {
//				e.printStackTrace();
				System.out.println("오류");
			}

		});
		t.start();
	}

	public void send(ObjectOutputStream oos, String id, String message) {
		if (oos == null) {
			return;
		}
		try {
			synchronized (oos) {
				oos.writeUTF(id);
				oos.writeUTF(message);
				oos.flush();
			}

		} catch (IOException e) {
			list.remove(oos);
		}

	}
}
