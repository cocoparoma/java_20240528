package day21.socket2;

public class ClientMain {

	public static void main(String[] args) {
		/**
		 * 연락처 관리 프로그램을 구현할 것
		 * 단, 블러오기랑 저장은 소켓 통신을 활용하여 작성할 것
		 * 메뉴
		 * 1.연락처 추가
		 * 2.연락처 수정
		 * 3.연락처 삭제
		 * 연락처 확인
		 * 5프로그램 종료
		 * 메뉴 선택
		 * 
		 */
		
		ClientContact cc = new ClientContact();
		cc.init();
		
		System.out.println("[Program Exit]");
		
	}

}
