package day02;
public class CastingEx01 {
	public static void main(String[] args) {
//		자료형 변환
//		 - 상수, 변수, 리터널의 자료형을 일시적으로 변환
		
		double num1 = 3;
		long num2 = 3;
		int num3 = 3;
		long num4 = num3;
		
		System.out.println(num4);
		
		int num5 = (int)3.14;
		
		System.out.println(num5); // 명시적 자료 형변환 실수 > 정수화
		byte num6 = (byte) num5;
		System.out.println(num6);
		byte num7 = (byte)123123;
		System.out.println(num7);
		
		double res = 1/2;
		System.out.println(res);
		
		res = 1/(double)2;
		System.out.println(res);		
	}
	
}