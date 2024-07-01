package day24;

public class Ex12 {

	public static void main(String[] args) {
		
		/**
		 * 원인 void는 리턴값이 없어서 ins res에 값을 쥐어줄 수 없음
		 * void -> int 한 후 리턴값을 쥐어주자
		 */
		int res = sum(1,2);
		
	}

	
	
	
	
	
	public static int sum(int a, int b) {
		System.out.println(a+b);
		return a+b;
	}
}
