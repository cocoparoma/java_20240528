package day24;

public class Ex04 {

	public static void main(String[] args) {
		int score = 80;
		
		if (score >= 90 && score <= 100) {
			System.out.println("A");
		}
		
		
		/**
		 * 원인 : or 연산자를 사용하였기 떄문 조건문 1에 해당하지 않지만 조건문 2에 해당하므로 A가 작성이 된것
		 * 해결 방안 : || 을 && 으로 변환한다
		 */
	}

}
