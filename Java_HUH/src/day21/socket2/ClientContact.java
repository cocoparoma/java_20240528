package day21.socket2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import program.makingFiled;

public class ClientContact implements makingFiled {
	Scanner sc = new Scanner(System.in);
	List<Ccontact> list = new ArrayList<Ccontact>();
	int PORT = 5101;
	String IP = "192.168.30.205";

	@Override
	public void init() {
		load();
		while (true) {
			save();
			System.out.print("[메뉴]\n[1]연락처 추가\n[2]연락처 수정\n[3]연락처 삭제\n[4]연락처 확인\n[5]프로그램 종료\n>>");

			String M = sc.nextLine();

			if (M.equals("1")) insert();
			else if (M.equals("2")) update();
			else if (M.equals("3")) delete();
			else if (M.equals("4")) check();
			else if (M.equals("5")) break;
			else if (M.equals("show")) showAll();
			else System.out.println("잘못된 입력입니다.");

		}

	}

	@Override
	public void insert() {
		System.out.print("[이름]\n>>");
		String nametmp = sc.nextLine();
		System.out.print("[번호]\n>>");
		String phoneNumbertmp = sc.nextLine();
		if(finById(phoneNumbertmp).equals("1")) {
			System.out.println("[중복된 번호]");
			return;
		}
		list.add(new Ccontact(nametmp, phoneNumbertmp));
		System.out.println("[번호 추가 완료]");
	}



	@Override
	public void update() {
		System.out.print("[이름]\n>>");
		String searchName = sc.nextLine();
		List<Ccontact> tmpList = list.stream().filter(p->p.getName().contains(searchName)).toList();
		if (tmpList.size() == 0) {
			System.out.println("[검색 결과 없음]");
			return;
		}
		for (int i = 0; i < tmpList.size(); i++) {
			System.out.println(   "["  +(i+1) + "]" + tmpList.get(i));
		}
		int idx = 0;
		try {
			System.out.println("[번호 입력]");
			idx = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			System.out.println("[숫자를 입력하세요.]");
			return;
		}
		System.out.print("[이름]\n>>");
		String nametmp = sc.nextLine();
		System.out.print("[번호]\n>>");
		String phoneNumbertmp = sc.nextLine();
		if(finById(phoneNumbertmp).equals("1")) {
			System.out.println("[중복된 번호]");
			return;
		}
		tmpList.get(idx-1).setName(nametmp);
		tmpList.get(idx-1).setPhoneNumber(phoneNumbertmp);
		System.out.println("[수정 완료]");
	}

	@Override
	public void delete() {
		System.out.print("[이름]\n>>");
		String searchName = sc.nextLine();
		List<Ccontact> tmpList = list.stream().filter(p->p.getName().contains(searchName)).toList();
		if (tmpList.size() == 0) {
			System.out.println("[검색 결과 없음]");
			return;
		}
		for (int i = 0; i < tmpList.size(); i++) {
			System.out.println(   "["  +(i+1) + "]" + tmpList.get(i));
		}
		int idx = 0;
		try {
			System.out.println("[번호 입력]");
			idx = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			System.out.println("[숫자를 입력하세요.]");
			return;
		}
		list.remove(tmpList.get(idx-1));
		System.out.println("[삭제 완료]");
	}

	public void check() {
		System.out.print("[이름]\n>>");
		String searchName = sc.nextLine();
		List<Ccontact> tmpList = list.stream().filter(p->p.getName().contains(searchName)).toList();
		if (tmpList.size() == 0) {
			System.out.println("[검색 결과 없음]");
			return;
		}
		for (int i = 0; i < tmpList.size(); i++) {
			System.out.println(   "["  +(i+1) + "]" + tmpList.get(i));
		}
	}
	@Override
	public String finById(String id) {
		if (list.stream().filter(p->p.getPhoneNumber().equals(id)).count() == 0) return "0";
		return "1";
	}

	@Override
	public void showAll() {
		System.out.println(list);
	}

	@Override
	public void save(String file) {

	}

	@Override
	public void load(String file) {

	}

	public void save() {
		try {
			Socket socket = new Socket(IP, PORT);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeUTF("save");
			oos.writeObject(list);
			oos.flush();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[저장 오류 발생]");
		}
	}

	@SuppressWarnings("unchecked")
	public void load() {
		try {
			Socket socket = new Socket(IP, PORT);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			oos.writeUTF("load");
			oos.flush();
			
			list = (List<Ccontact>) ois.readObject();
			System.out.println(list);// 디버깅용
		} catch (Exception e) {
			System.out.println("[불러오기 오류 발생]");
		}

	}

}
