package day14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import program.program;

public class PhoneManager implements program {

	private Contact[] list;
	private int count;
	private static Scanner sc = new Scanner(System.in);
	private final int INSERT = 1;
	private final int UPDATE = 2;
	private final int DELETE = 3;
	private final int SEARCH = 4;
	private final int EXIT = 5;
	public static final String REGEXP_PHONE = "^[\\d]{11}+$";
	public static final Pattern pattern = Pattern.compile(REGEXP_PHONE);
	static List<Contact> member = new ArrayList<Contact>();

	@Override
	public void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 연락처 추가");
		System.out.println("2. 연락처 수정");
		System.out.println("3. 연락처 삭제");
		System.out.println("4. 연락처 검색");
		System.out.println("5. 프로그램 종료");
		System.out.print("입력 : ");

	}

	@Override
	public void runMenu(int menu) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		String fileName = null;
		load(fileName);

		int menu = 0;
		do {
			// 메뉴 출력
			printMenu();
			// 메뉴 선택
			switch (menu) {
			case INSERT:
				insert();
				break;
			case UPDATE:
				try {
					update();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case DELETE:
				delete();
				break;
			case SEARCH:
				search();
				break;
			case EXIT:
				System.out.println("종료합니다.");
				break;
			default:
			}
			try {
				menu = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("메뉴를 잘못 입력하셨습니다.");
				sc.next();
			}
			// 선택한 메뉴에 따른 기능 실행
			runMenu(menu);
		} while (menu != EXIT);
		// 저장하기 save(fileName) 요구됨
	}

	private void search() {
		System.out.println("연락처 검색");
		Collections.sort(member);// 리스트 > Collections 콜랙션
		System.out.println("검색할 사람의 이름을 입력해 주세요 (엔터시 전체검색)");
		System.out.print("입력 : ");
		String searchToken = sc.nextLine();

		int idx = 0;
		if (searchToken == null || "\n".equals(searchToken)|| searchToken.isEmpty()) {
			System.out.println("전체검색");
			for (int i = 0; i < member.size(); i++) {
				System.out.println(
						i + ", 이름 : " + member.get(i).nameString + "  번호 : " + member.get(i).phoneNumberString);
			}
		} else {
			for (idx = 0; idx < member.size(); idx++) {
				if (member.get(idx).nameString.contains(searchToken)) {
					System.out.println(idx + ", 이름 : " + member.get(idx).nameString + "  번호 : "
							+ member.get(idx).phoneNumberString);
				}
			}
			System.out.println("부분검색");
		}

	}

	private void delete() {
		System.out.println("연락처 삭제");
		Collections.sort(member);// 리스트 > Collections 콜랙션
		int idx = 0;
		for (idx = 0; idx < member.size(); idx++) {
			System.out.println(
					idx + ", 이름 : " + member.get(idx).nameString + "  번호 : " + member.get(idx).phoneNumberString);
		}
		System.out.println("삭제하고싶은 연락처의 번호를 입력해 주세요.");
		System.out.print("입력 : ");
		idx = sc.nextInt();
		member.remove(idx);
		System.out.println("삭제가 완료되었습니다.");
	}

	private void update() throws Exception {
		Collections.sort(member);
		System.out.println("연락처 수정");
		System.out.println("수정할 사람의 이름을 입력해 주세요");
		System.out.print("입력 : ");
		String case2Token = sc.next();
		sc.nextLine();

		int idx = 0;
		// for (Contact conct : member) {
		for (idx = 0; idx < member.size(); idx++) {
			if (member.get(idx).nameString.contains(case2Token)) {
				System.out.println(
						idx + ", 이름 : " + member.get(idx).nameString + "  번호 : " + member.get(idx).phoneNumberString);
			}
		}
		System.out.println("수정하고싶은 연락처의 번호를 입력해 주세요.");
		System.out.println("입력 : ");
		idx = sc.nextInt();
		
		String tmpName = inputContactName();
		String tmpPhone = inputContactNumber();
		tmpPhone = phoneNumberFormChanger(tmpPhone);
		if (numberEquals(tmpPhone)) {
			System.out.println("중복된 번호 입니다.");
			return;
		}
		// set 수정완료
		member.set(idx, new Contact(tmpName, tmpPhone));
		// 확인용
		System.out.println("이름 : " + member.get(idx).nameString);
		System.out.println("번호 : " + member.get(idx).phoneNumberString);
		// 정렬 필요함

	}

	// 번호형식을 010-1234-1234로 변환
	static String phoneNumberFormChanger(String Number) {
		String tmpToken1 = Number.substring(7);
		String tmpToken2 = Number.substring(3, 7);
		String tmpToken3 = Number.substring(0, 3);
		return tmpToken3 + "-" + tmpToken2 + "-" + tmpToken1;
	}

	// 이름 받기
	static String inputContactName() {
		System.out.print("이름 : ");
		sc.nextLine();
//        String tmpName = sc.next();//수정전 tmpName 리턴했음
		return sc.next();
	}

	// 폰 넘버 받고 살짝 형식 관리
	static String inputContactNumber() throws Exception {
		for (;;) {
			System.out.println("번호(형식 : 01012341234), 0입력시 뒤로가기");
			System.out.print("입력 : ");
			sc.nextLine();
			String tmpNumber = sc.next();
			if (phone_REG(tmpNumber)) {
				return tmpNumber;
			} else if (tmpNumber.equals("0")) {
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
		return "잘못된 번호.";
	}

	// String 값이 01012341234 형식인지 아닌지 확인
	static boolean phone_REG(String tmpNumber_notREG) {
		return Pattern.matches(REGEXP_PHONE, tmpNumber_notREG);
	}

	// 중복 번호 확인 작업
	static boolean numberEquals(String number) {
		try {

			for (int j = 0; j < member.size(); j++) {
				if (member.get(j).phoneNumberString == null)
					return true;
				if (member.get(j).phoneNumberString.equals(number))
					return true;
			}

		} catch (NullPointerException e) {
			System.out.println("boolean numberEquals 오류");
		}
		return false;
	}

	private void insert() {
		System.out.println("연락처 추가");
		String tmpName = inputContactName();
		String tmpPhone;
		try {
			tmpPhone = inputContactNumber();
			tmpPhone = phoneNumberFormChanger(tmpPhone);
			if (numberEquals(tmpPhone)) {
				System.out.println("중복된 번호 입니다.");
				return;
			}

			member.add(new Contact(tmpName, tmpPhone));
			int membeConuter = member.size();
			System.out.println("이름 : " + member.get(membeConuter - 1).nameString);
			System.out.println("번호 : " + member.get(membeConuter - 1).phoneNumberString);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void load(String fileName) {
		if (fileName == null) {
			System.out.println("불러올 파일이 없습니다.");
			list = new Contact[10];
			return;
		}
	}

}
