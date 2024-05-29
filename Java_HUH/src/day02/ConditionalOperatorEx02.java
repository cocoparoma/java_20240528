package day02;

public class ConditionalOperatorEx02 {

	public static void main(String[] args) {
//		조건 연산자
//		조건 수가 짝수면 짝수라고 출력하고 홀수면 홀수라고 출력하는 코드를 작성하라.
		int susja = 32;
		String result = (susja%2 == 1) ? "홀수입니다." : "짝수입니다";
		System.out.println(susja+ " 는 " + result);
//		if-else문에 비해 빠르거나 하지 않음. 간단하게 한줄 두줄로 쓰일때는 적당함 과하면 if문이 좋음	
	}

}
