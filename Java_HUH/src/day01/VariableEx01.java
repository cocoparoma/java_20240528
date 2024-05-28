package day01;
public class VariableEx01 {
	public static void main(String[] args) {
//		char ch1;//문자형 변수 ch 선언
//		char ch2 = '\u0041';
//		char ch3, ch4;
		char ch1, ch2 = '\u0041', ch3, ch4='\u0042',ch5 = '+', ch6 = '\\' ;
		//위의 3줄과 해당줄은 같은 뜻입니다.(동시선언이 가능합니다.)
		System.out.println(ch2);
		System.out.println(ch6);
		System.out.println(ch4);
		System.out.println(ch5);
		long long_number1 = 1234567890123456L;
		System.out.println(long_number1); //인트형을 넘어가는 숫자는 long 그리고 접두사로 L을 붙여준다.
		/*
		 * 5 = 0000 0101
		 * 5의 1의 보수 = 1111 1010
		 * 5의 2의 보수 = 1의 보수 + 1 = 1111 1011
		 *  -5 = 1111 1011
		 *  해당부분은 잘 사용하지 아니하나 잘 살펴보지 않으면 오류가 날 수 있음
		 */
		float float_num1 = 3.141592F; // 4바이트, 소수점 6자리, 접미사 F사용 !실수형의 기본형은 double
		double double_num1 = 3.141592;
		System.out.println(float_num1);
		//논리형 true = 1 , false = 0
		boolean isEven = true;
		System.out.println(isEven);
	}
}