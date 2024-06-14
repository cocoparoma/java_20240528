package day13;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		/**
		 * 두 정수와 산술 연산자를 입력받아 산술 연산결과를 알려주는 메소드를 정의 및 구현하고 main 메소드에서 실행하는 코드를 작성하시오 단
		 * 예외 발생시 예외처리하는 코드를 추가하시오.
		 */
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.print("정수 1를 입력하세요 :");
			int su1 = scanner.nextInt();
			System.out.print("정수 2를 입력하세요 :");
			int su2 = scanner.nextInt();
			System.out.print("연산자(+, -, /, *, %)를 입력하세요");
			scanner.nextLine();
			char ch = scanner.nextLine().charAt(0);
			double result = OutputNumber(su1, su2, ch);
			if (result != 0)
				System.out.println("결과 : " + result);
			if (result == 0)
				System.out.println("오류 발생");
		} catch (Exception e) {
			System.out.println("숫자가 아닙니다.");
		}
	}

	public static double OutputNumber(int a, int b, char c) throws Exception {
		String wString = "";
		wString = Character.toString(c);
		try {
			if (c == '+')
				return a + (double) b;
			if (c == '-')
				return a - (double) b;
			if (c == '*')
				return a * (double) b;
			if (c == '/')
				return a / (double) b;
			if (c == '%')
				return a % (double) b;
			if (!(wString.contains("+") || wString.contains("-") || wString.contains("*") || wString.contains("/")
					|| wString.contains("%"))) {
				System.out.println("정상적인 연산자가 아닙니다.");
			}
		} catch (ArithmeticException e) {
			System.out.println("(0으로 나눔) 정상적인 숫자가 아닙니다.");
		}
		return 0;
	}

}
