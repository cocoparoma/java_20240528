package day02;

import java.util.Scanner;

public class ScannerEx02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 1을 입력하시오. : ");
		int n1 = sc.nextInt();
		System.out.print("정수 2을 입력하시오. : ");
		int n2 = sc.nextInt();
		System.out.println("연산자를 입력하시오. : ");
		char info = sc.next().charAt(0);
		int result = 0;
		if (info == '+') {
			result = n1+n2;
			System.out.println(""+n1+info+n2+"="+result);
		} else if (info == '-')
		{
			result = n1-n2;
			System.out.println(""+n1+info+n2+"="+result);
		} else if (info == '*')
		{
			result = n1*n2;
			System.out.println(""+n1+info+n2+"="+result);
		} else if (info == '/')
		{
			result = n1/n2;
			System.out.println(""+n1+info+n2+"="+result);
		} 
	}
}
