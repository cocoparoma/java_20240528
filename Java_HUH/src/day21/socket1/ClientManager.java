package day21.socket1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import program.makingFiled;

//속담을 관리하는 프로그램
public class ClientManager implements makingFiled {
	private Scanner sc = new Scanner(System.in);
	private String file = "src/day21/socket1/Client1.txt";
	private List<String> list = new ArrayList<String>();
	private String ip = "127.0.0.1";
	private int port = 5001;

	@Override
	public void init() {
		load();
		while (true) {
			save();
			System.out.println("메뉴\n[1]속담추가\n[2]속담삭제\n[3]속담전체보기\n[4]종료\n>>");

			String M = sc.nextLine();

			if (M.equals("1"))
				insert();
			else if (M.equals("2"))
				delete();
			else if (M.equals("3"))
				update();
			else if (M.equals("4"))
				break;
			else if (M.equals("show"))
				showAll(); // 디버깅용
			else
				System.out.println("잘못된 입력입니다.");

		} // while done
	}

	@Override
	public void insert() {
		System.out.print("속담 :");
		String contents = sc.nextLine();
		if (!list.contains(contents.trim())) {
			list.add(contents.trim());
		}
	}
	@Override
	public void delete() {
		update();
		System.out.print("삭제할 속담 선택\n>>");
		try {
			int idx = Integer.parseInt(sc.nextLine()) - 1;
			list.remove(idx);
			System.out.println("속담을 삭제하였습니다.");
		}catch (NumberFormatException e) {
			System.out.println("숫자를 입력해 주세요.");
		}
		catch (Exception e) {
			System.out.println("잘못된 속담 입니다.");
		}
	}
	@Override
	public void update() {//프린트로 사용하세용 수정이나 업데이트가 해당 프로그램에는 없습니당
		if (list.size() == 0) {
			System.out.println("등록된 속담이 없습니다.");
			return;
		}
		for (int i = 0; i < list.size()	; i++) {
			System.out.println( (i+1) + ". "  + list.get(i));
		}
	}

	@Override
	public String finById(String id) {
		
		return null;
	}

	@Override
	public void showAll() {
		System.out.println(list);
	}

	@Override
	public void save(String file) {// 내부저장
		try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(list);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void save() {
		try {
			Socket socket = new Socket(ip, port);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeUTF("save");
			oos.writeObject(list);
			
			oos.flush();
		} catch (Exception e) {
		} finally {
			save(file);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void load(String file) {
		try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis);) {
			list = (List<String>) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public void load() {// 통신에 문제가 생기면 내부저장하도록
		try {
			Socket socket = new Socket(ip, port);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeUTF("load");
			oos.flush();
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			list = (List<String>) ois.readObject();
			System.out.println(list);// 디버깅용
		} catch (Exception e) {
			load(file);
		}
	}

}
