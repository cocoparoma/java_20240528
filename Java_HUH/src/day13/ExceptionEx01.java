package day13;

import java.util.Scanner;

public class ExceptionEx01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("정수1를 입력하세요 : ");
		int su1 = sc.nextInt();
		System.out.print("정수2를 입력하세요 : ");
		int su2 = sc.nextInt();
		/**
		 * 예외처리를 하지 않으면 예외 발생 후 프로그램이 중단된다. 
		 * 예외처리를 한다면 예외처리 명령어 실행 후 이어서 실행된다.
		 */
		try {
			System.out.println("결과 : " + su1 / su2);
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("잘못된 번지에 접근했습니다.");
		} catch (RuntimeException e) {
			System.out.println("런타임 에러");
		} catch (Exception e) {
			System.out.println("예외발생");
		}

		System.out.println("프로그램 종료");
	}

}
