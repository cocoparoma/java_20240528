package day02;
public class StringEx02 {
	public static void main(String[] args) {
		//문자열 더하기 예제
		String str1 = 1+"안녕";
		String str2 = "1안녕" + 2;
		
		System.out.println(str1);
		System.out.println(str2);
		
//		우선순위 앞부터 = 결과가 다름
		String str3 = 1+ 2+ "3";
		String str4 = "1" + 2+ 3;
		
		System.out.println(str3);
		System.out.println(str4);
	}
}