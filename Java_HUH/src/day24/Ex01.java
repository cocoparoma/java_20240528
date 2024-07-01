package day24;

public class Ex01 {

	public static void main(String[] args) {
		int num1 = 4;
		double	num2 = num1;
		
		/**
		 * 원인 : 데이터 형이 올바르지 않아서
		 * 해별 방법 : 형변환을 위해 (int)를 적어 인트형을 맞춰줌 혹은 String str = "" + num2; int num3 = Integer.parseInt(str);로 문자열로 만들어준뒤 인트형으로 형변환 시켜줌
		 */
		int num3 = (int)num2;
		System.out.println(num3);
	}

}
