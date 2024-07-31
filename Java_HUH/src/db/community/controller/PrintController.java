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
		System.out.println("--------관리자 메뉴---------");
		System.out.println("1. 게시글 등록\n2. 게시글 검색\n3. 로그아웃");
		System.out.println("------------------------");
		System.out.print(">>");
		
	}
	
}
