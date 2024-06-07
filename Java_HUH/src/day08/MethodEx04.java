package day08;

public class MethodEx04 {

	public static void main(String[] args) {
		// 재귀 메소드로 인해 스택 오버 플로우가 발생하는 예제
		// 재귀 메소드 : 자기자신을 재 호출하는 메소드
		System.out.println(factorial(5));
		System.out.println(factorial2(5));

	}// main done

	static long factorial(long a) {
		if (a < 0) {
			return 0;
		}
		if (a == 0L || a == 1L) {
			return 1;
		}
		return a * factorial(a - 1);
	}

	// err 메서드 오버플로우 재귀쓰는것 지양하자(써야할 땐 쓰는게 좋음)
	// StackOverFlowError exception occurred
	// 함수 호출시 스택 메모리 사용 호출 완료시 스택에서 제거
	// 스택 : 위에서 추가되고 위에서 빠짐 (자료구조의 일종)
	// 함수의 장점 ! 기능을 나누어 코드 구조 파악하기 쉽고 유지 보수가 쉬움
	static long factorial2(long a) {
		return a * factorial2(a - 1);
	}

}// class done
