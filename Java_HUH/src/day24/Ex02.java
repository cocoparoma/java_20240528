package day24;

public class Ex02 {

	public static void main(String[] args) {
		int num1 = 1, num2 = 2;
		double res = num1 /(double) num2;
		System.out.println(num1 + " / " + num2 +  " = " + res);
	}

}
/**
 * 원인 : 순서의 문제. 인트 1과 2가 먼저 계산이 되어 나눌수 없어 0 의 값을 출력하고 그 값을 더블형 res에 넣어주기 때문이다
 * 해결 방안 : 인트 1과 인트 2를 계산할 때 한쪽을 double 형변변환 시켜주어 인트와 더블의 계산식으로 바꾸어준다
 */
