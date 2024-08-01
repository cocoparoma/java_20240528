package db.community.controller;

// 출력 전용 컨트롤러 입니다. DB를 사용하지 않습니
public class PrintController {

	public static void printMainMenu() {
		System.out.println("---------메인 메뉴---------");
		System.out.println("1. 로그인\n2. 회원가입\n3. 종료");
		System.out.println("------------------------");
		System.out.print(">>");
	}

	
	public static void printBar() {
		System.out.println("------------------------");		
	}


	public static void wrongMenu() {
		System.out.println("잘못된 입력");
		
	}


	public static void loginFail() {
		System.out.println("로그인 실패");
		
	}


	public static void signUpSuccess() {
		System.out.println("회원가입 완료");
		
	}


	public static void SignUpFail() {
		System.out.println("회원가입 실패");
		
	}


	public static void printAdminMenu() {
		System.out.println("--------관리자 메뉴---------");
		System.out.println("1. 커뮤니티 등록\n2. 커뮤니티 수정\n3. 커뮤니티 삭제\n4. 회원 정지\n5. 로그아웃");
		System.out.println("------------------------");
		System.out.print(">>");
		
	}


	public static void logout() {
		System.out.println("로그아웃");
		
	}


	public static void printUserMenu() {
		System.out.println("--------사용자 메뉴---------");
		System.out.println("1. 게시글 등록\n2. 게시글 검색\n3. 로그아웃");
		System.out.println("------------------------");
		System.out.print(">>");
		
	}


	public static void printPostMenu() {
		System.out.println("--------게시글 메뉴---------");
		System.out.println("1. 이전\n2. 다음\n3. 검색\n4. 상세 조회\n5. 돌아가기");
		System.out.println("------------------------");
		System.out.print(">>");
		
	}


	public static void prev() {
		System.out.println("이전으로 돌아갑니다.");
		
	}


	public static void printPostSubMenu(boolean writer) {
		System.out.println("------게시글 상세 메뉴-------");
		System.out.println("1. 뎃글 조회\n2. 뎃글 추가\n3. 돌아가기");
		if (writer) {
			System.out.println("4. 게시글 수정");
			System.out.println("5. 게시글 삭제");
		}
		System.out.println("------------------------");
		System.out.print(">>");
		
	}


	public static void notWriter() {
		System.out.println("작성자가 아닙니다.");
	}
	
}
