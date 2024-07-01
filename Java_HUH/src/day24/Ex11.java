package day24;

public class Ex11 {

	public static void main(String[] args) {
		/**
		 * 생성자가 없다 <<이방법대로 해봐용
		 * 스테틱을 붙여준다
		 */
		
		Ex11 ex = new Ex11();
		
		
		int res = ex.sum(1,2);
		
		System.out.println(1 + " + " + 2 + " = " + res);

	}

	
	public int sum(int a, int b) {
		return a+b;
	}
	
	
	
	
	
	
}
