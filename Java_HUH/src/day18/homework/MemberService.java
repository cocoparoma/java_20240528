package day18.homework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.swing.text.html.CSS;

public class MemberService implements MemberInterface {
	SchedulerService ss = new SchedulerService();
	Scanner sc = new Scanner(System.in);
	List<Member> list = new ArrayList<Member>();
	String file = "src/day18/homework/member.txt";

	@Override
	public void init() {
		load(file);
		while (true) {
		System.out.print("메뉴 \n[1]회원 관리\n[2]일정관리\n[3]종료\n>>");

		String M = sc.nextLine();

		if (M.equals("1")) initMember();
		else if (M.equals("2")) ss.init();
		else if (M.equals("3")) break;
		else if (M.equals("show")) showAll();
		else System.out.println("잘못 입력하셨습니다.");
		}
	}

	public void initMember() {
		while (true) {
			System.out.print("메뉴  \n[1]회원 추가\n[2]회원 수정\n[3]회원 삭제\n[4]돌아가기\n>>");

			String M = sc.nextLine();

			if (M.equals("1")) insertMember();
			else if (M.equals("2")) updateMember();
			else if(M.equals("3")) deleteMember();
			else if (M.equals("4")) break;
			else System.out.println("잘못 입력하셨습니다.");
			save(file);
		}

	}

	@Override
	public void insertMember() {
		System.out.print("[아이디] : ");
		String id = sc.nextLine();
		System.out.print("[닉네임] : ");
		String nickname = sc.nextLine();
		if (list.stream().filter(p -> p.getId().equals(id)).count() >= 1) {
			System.out.println("중복된 아이디 입니다.");
			return;
		}
		list.add(new Member(id, nickname));
	}

	@Override
	public void updateMember() {
		System.out.print("[아이디] : ");
		String id = sc.nextLine();

		List<Member> tmpList = list.stream().filter(p->p.getId().contains(id)).collect(Collectors.toList());
		
		if (tmpList.size() == 0) System.out.println("존재하지 않는 아이디");
		if (tmpList.size() == 0) return;
		
		for (int i = 0; i < tmpList.size(); i++) System.out.println("[" + (i + 1) + "]" + tmpList.get(i));
		System.out.print(">>");

		int idx = 0;
		
		try {
			idx = sc.nextInt() - 1;
			sc.nextLine();
			if (idx < 0 || tmpList.size() <= idx) {
				System.out.println("잘못된 번호입니다.");
				return;
			}
		} catch (Exception e) {
			System.out.println("숫자만 입력해 주세요.");
			return;
		}
		//변경할 닉네임
		System.out.print("[닉네임] : ");
		String nickname = sc.nextLine();
		if(list.stream().filter(p->p.getId().contains(nickname)).count() >= 1) {
			System.out.println("중복된 아이디 입니다.");
			return;
		}
		Member jamkkanMember = tmpList.get(idx);
		List<Member> jamsiList = list;
//		jamsiList.set(idx, new Member(jamsiList.indexOf(jamsiList), nickname));
		jamsiList.remove(idx);
		jamsiList.remove(jamkkanMember);
		list = jamsiList;
		
		
	}

	@Override
	public void deleteMember() {
		System.out.print("[아이디] : ");
		String id = sc.nextLine();
		if(list.stream().filter(p->p.getId().equals(id)).count() == 0) {
			System.out.println("Not Found");
			return;
		}
		List<Member> tmpList = list.stream().filter(p->p.getId().contains(id)).collect(Collectors.toList());
		for (int i = 0; i < tmpList.size(); i++) {
			System.out.println("[" + (i + 1) + "]" + tmpList.get(i));
		}
		System.out.print(">>");
		int idx =0;
		try {
			idx = sc.nextInt() - 1;
			if (idx < 0 || tmpList.size() <= idx) {
				System.out.println("잘못된 번호입니다.");
				return;
			}
		} catch (Exception e) {
			System.out.println("숫자만 입력해 주세요.");
			return;
		}
		Member jamsimanyo = tmpList.get(idx);
		list.remove(jamsimanyo);

	}

	@Override
	public void showAll() {// 디버깅용
		System.out.println(list);
		System.out.println(list.get(0));
		System.out.println(list.getClass());
		
	}

	@Override//람다식, 스트림으로 대체 해당 메소드는 반복문으로 찾다가 찾으면 멈추는 형식으로 되어있게 만들면 됨
	public Member findById(String id) {
		return null;
	}

	@Override
	public void save(String file) {
		try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(list);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void load(String file) {
		try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis);) {
			list = (List<Member>) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
