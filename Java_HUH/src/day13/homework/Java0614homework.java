package day13.homework;

import java.util.*;
import java.util.regex.Pattern;

public class Java0614homework {
	static Scanner sc = new Scanner(System.in);
	public static final String REGEXP_PHONE = "^[\\d]{11}+$";
	public static final Pattern pattern = Pattern.compile(REGEXP_PHONE);

	static List<Contact> member = new ArrayList<Contact>();

	public static void main(String[] args) {

		int menuToken = 0;

		do {
			menuStart();

			try {
				menuToken = sc.nextInt();
			} catch (Exception e) {
				System.out.println("올바른 숫자를 입력해 주세요");
				continue;
			}

			switch (menuToken) {
			case 1:
				addContact();
				break;
			case 2:
				editContact();
				break;
			case 3:
				removeContact();
				break;
			case 4:
				searchContact();
				break;
			case 5:
				System.out.println("종료합니다.");
				break;
			default:
			}
		} while (menuToken != 5);

	}// main done

	static void menuStart() {
		System.out.println("메뉴");
		System.out.println("1. 연락처 추가");
		System.out.println("2. 연락처 수정");
		System.out.println("3. 연락처 삭제");
		System.out.println("4. 연락처 검색");
		System.out.println("5. 프로그램 종료");
		System.out.print("입력 : ");
	}// menuStart done

	// 이름 받기
	static String inputContactName() {
		System.out.print("이름 : ");
		sc.nextLine();
//        String tmpName = sc.next();//수정전 tmpName 리턴했음
		return sc.next();
	}

	// 폰 넘버 받고 살짝 형식 관리
	static String inputContactNumber() {
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

	// 중복 번호 확인 작업
	static boolean numberEquals(String number) {
		try {
			// for (int i = 0; i < member.length; i++) {
			for (int j = 0; j < member.size(); j++) {
				if (member.get(j).phoneNumberString == null)
					return true;
				if (member.get(j).phoneNumberString.equals(number))
					return true;
			}
			// }
		} catch (NullPointerException e) {
			System.out.println("boolean numberEquals 오류");
		}
		return false;
	}

	// String 값이 01012341234 형식인지 아닌지 확인
	static boolean phone_REG(String tmpNumber_notREG) {
		return Pattern.matches(REGEXP_PHONE, tmpNumber_notREG);
	}

	// 번호형식을 010-1234-1234로 변환
	static String phoneNumberFormChanger(String Number) {
		String tmpToken1 = Number.substring(7);
		String tmpToken2 = Number.substring(3, 7);
		String tmpToken3 = Number.substring(0, 3);
		return tmpToken3 + "-" + tmpToken2 + "-" + tmpToken1;
	}

	static private void addContact() {
		System.out.println("연락처 추가");
		String tmpName = inputContactName();
		String tmpPhone = inputContactNumber();
		// 010-1234-1234 폼 변환
		tmpPhone = phoneNumberFormChanger(tmpPhone);
		// 중복 확인
		if (numberEquals(tmpPhone)) {
			System.out.println("중복된 번호 입니다.");
			return;
		}

		member.add(new Contact(tmpName, tmpPhone));
		int membeConuter = member.size();
		// 저장
		System.out.println("이름 : " + member.get(membeConuter - 1).nameString);
		System.out.println("번호 : " + member.get(membeConuter - 1).phoneNumberString);

	}

	static private void editContact() {
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

	static private void removeContact() {
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

	static private void searchContact() {
		System.out.println("연락처 검색");
		Collections.sort(member);// 리스트 > Collections 콜랙션
		System.out.println("검색할 사람의 이름을 입력해 주세요 (엔터시 전체검색)");
		System.out.print("입력 : ");
		String searchToken = sc.nextLine();

		int idx = 0;
		if (searchToken == null || "\n".equals(searchToken)) {
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

}// class done

class Contact implements Comparable<Contact> {
	public String nameString, phoneNumberString;

	public Contact(String nameString, String phoneNumberString) {
		this.nameString = nameString;
		this.phoneNumberString = phoneNumberString;
	}

	@Override
	public String toString() {
		return "Contact{" + "nameString='" + nameString + '\'' + ", phoneNumberString='" + phoneNumberString + '\''
				+ '}';
	}

	@Override
	public int compareTo(Contact other) {

		return nameString.compareTo(other.nameString);
	}

}
