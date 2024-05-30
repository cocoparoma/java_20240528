package day02;

import java.util.Scanner;

public class Scanner_Test_Solo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 1 : ");
		int a = sc.nextInt();
		System.out.print("정수 2: ");
		int b = sc.nextInt();
		System.out.print("연산자 : ");	
		char operator = sc.next().charAt(0);
		System.out.println(
				 (operator == '+') ? ""+a+operator+b+"="+(a+b)//+일때
				: (operator == '-') ? ""+a+operator+b+"="+(a-b) //-일때
				: (operator == '*') ? ""+a+operator+b+"="+(a*b)//*일때
				: (operator == '/') ? ""+a+operator+b+"="+(a/b)///일때
				:"잘못 입력하셨습니다."); //예외처리
	}
}
