package day17.contact;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import program.program;

public class ContactManager implements program {
	private List<Contact> list = new ArrayList<Contact>();
	private Scanner sc = new Scanner(System.in);
	public static final String REGEXP_PHONE = "^[\\d]{11}+$";
	private final int INSERT = 1;
	private final int UPDATE = 2;
	private final int DELETE = 3;
	private final int SEARCH = 4;
	private final int EXIT = 5;

	@Override
	public void printMenu() {
		System.out.println("** ** ** ** ** **");
		System.out.print("메뉴\n1. 연락처 추가" + "\n2.연락처 수정" + "\n3.연락처 삭제" + "\n4.연락처 검색" + "\n5.종료" + "\n입력 : ");
	}

	@Override
	public void runMenu(int menu) throws Exception {
		switch (menu) {
		case INSERT:
			insert();
			break;
		case UPDATE:
			update();
			break;
		case DELETE:
			delete();
			break;
		case SEARCH:
			search();
			break;
		case EXIT:
			System.out.println("프로그램 종료.");
			break;
		default:
			System.out.println("잘못된 입력입니다.");
			throw new IllegalArgumentException("Unexpected value: " + menu);
		}
	}

	private void update() {
		System.out.print("수정할 인원을 입력해 주세요. \n입력 : ");
		//이름입력
		sc.nextLine();// 버퍼받아주기
		String nametmp = sc.nextLine();
		//이름이 포함된 연락처들을 리스트 tmps 로받아주자
		List<Contact> tmps = list.stream().filter(c -> c.getName().contains(nametmp)).collect(Collectors.toList());
		//없으면 (위 size가 0과 같으면) 안내문구와 return
		if (tmps.size() == 0) {
			System.out.println("일치하는 연락처가 없습니다.");
			return;
		}
		for (int i = 0; i < tmps.size(); i++) {
			System.out.println((i + 1) + ". " + tmps.get(i));
		}
		System.out.print("번호 : ");
		int index = sc.nextInt() - 1;

		if (index < 0 || index >= tmps.size()) {
			System.out.println("잘못된 번호 입니다.");
			return;
		}
		Contact tmp = tmps.get(index);
		//이름, 번호를 입력받음
		System.out.print("추가할 인원의 이름을 입력해 주세요. \n입력 : ");
		sc.nextLine();// 버퍼받아주기
		String tmpName = sc.nextLine();
		System.out.print("추가할 인원의 번호를 입력해 주세요. \n입력 : ");
		String tmpNumber = sc.nextLine();
		if(list.stream().filter(p->p.getNumber().contains(tmpNumber)).count() >= 1) {
			System.out.println("이미 있는 번호입니다.");
			return;
		}
		List<Contact> jamsiman=  list;
		jamsiman.remove(tmp);
		list = jamsiman;
		list.add(new Contact(tmpNumber, tmpName));
	}

	private void delete() {
		System.out.print("삭제할 인원을 입력해 주세요. \n입력 : ");
		try {
			sc.nextLine();// 버퍼받아주기
			String tmp = sc.nextLine();

			List<Contact> tmps = list.stream().filter(c -> c.getName().contains(tmp)).collect(Collectors.toList());

			if (tmps.size() == 0) {
				System.out.println("일치하는 연락처가 없습니다.");
				return;
			}

			for (int i = 0; i < tmps.size(); i++) {
				System.out.println((i + 1) + ". " + tmps.get(i));
			}
			System.out.print("번호 : ");
			int index = sc.nextInt() - 1;

			if (index < 0 || index >= tmps.size()) {
				System.out.println("잘못된 번호 입니다.");
				return;
			}

			Contact tmpC = tmps.get(index);
			list.remove(tmpC);

		} catch (Exception e) {
			System.out.println("잘못된 입력입니다." + e.getMessage());
		}
	}

	private void insert() {
		sc.nextLine();// 버퍼받아주기
		System.out.print("추가할 인원의 이름을 입력해 주세요. \n입력 : ");
		String tmpName = sc.nextLine();
		System.out.print("추가할 인원의 번호를 입력해 주세요. \n입력 : ");
		String tmpNumber = sc.nextLine();
		if (list.stream().filter(p -> p.getNumber().equals(tmpNumber)).count() >= 1) {
			System.out.println("있는 번호입니다.");
			return;
		}
		list.add(new Contact(tmpNumber, tmpName));

	}

	private void search() {
		System.out.print("검색할 인원을 입력해 주세요. \n입력 : ");
		try {
			String tmp = sc.next();
			if (list.stream().filter(c -> c.getName().contains(tmp)).count() == 0)
				System.out.println("일치하는 연락처가 없습니다.");
			list.stream().filter(c -> c.getName().contains(tmp)).forEach(c -> System.out.println(c));

		} catch (Exception e) {
			System.out.println("잘못된 입력입니다." + e.getMessage());
			sc.nextLine();// 버퍼 받아주기
		}

	}
//검색 done

	@Override
	public void run() {
		String filename = "src/day17/contact/contact.txt";
		load(filename);
//		list = new ArrayList<Contact>();

		int M = 0;
		do {
			printMenu();
			try {
				M = sc.nextInt();
				runMenu(M);
			} catch (Exception e) {
				System.out.println("숫자가 아닙니다." + e.getMessage());
				sc.nextLine();// 버퍼처리해주기
			}

		} while (M != EXIT);

		save(filename);
	}

	@Override
	public void save(String filename) {
		try (FileOutputStream fos = new FileOutputStream(filename);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(list);
//			for (Contact tmp : list) {
//				oos.writeObject(tmp);
//			}

		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (Exception e) {
			System.out.println("예외");
		}
	}
//(Data) ois.readObject();

	@SuppressWarnings("unchecked")
	@Override
	public void load(String filename) {
		// 연락처 리스트를 가져와서 list에 저장
		try (FileInputStream fis = new FileInputStream(filename); ObjectInputStream ois = new ObjectInputStream(fis)) {
//			(Contact)ois.readObject(list);
			list = (List<Contact>) ois.readObject();
		} catch (Exception e) {
			System.out.println("파일을 찾을 수 없습니다.");
		}

	}

}
