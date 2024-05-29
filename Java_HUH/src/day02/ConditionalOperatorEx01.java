package day02;
public class ConditionalOperatorEx01 {
	public static void main(String[] args) {
//		조건 연산자 예제
//		주어진 나이에 따라 성인, 미성년자를 출력하는 예제
		int age = 10;
		String result = (age >= 20) ? "성인입니다." : "미성년자입니다. ";
		System.out.println(age + "살은 " + result);
	}
}