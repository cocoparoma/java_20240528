package day24;

public class Ex03 {

	public static void main(String[] args) {
		
		/**
		 * 원인 : 세미콜론의 오류 if 문 뒤에 세미콜론에 의해 if문은 조건을만족하고 실행문이 없이 끝나는 문이다 가로안의 실행문은 if문과 전혀 관련 없다
		 * 해결방법 : 세미콜론 삭제
		 */

		int num = 2;
		
		if (num % 2 == 0) {
			System.out.println("짝수");
		}
		
		if (num % 2 != 0) {
			System.out.println("홀수");
		}

		
	}

}
