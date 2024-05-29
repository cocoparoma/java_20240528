package day02;
import java.util.Scanner;
public class ScannerEx01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //일단 외울 것, 그냥쓰면 스케너를 못찾음 마우스 올려서 import scanner
		
		//콘솔에서 정수를 입력받고 출력
		System.out.print("정수를 입력하시오. : ");
		int susja1 = sc.nextInt();
		System.out.println("입력하신 정수는 : " + susja1);
		
		//콘솔에서 실수를 입력받고 출력1
		System.out.print("실수를 입력하시오. : ");
		double susja2 = sc.nextDouble();
		System.out.println("입력하신 실수는 : " + susja2);
		
		//콘솔에서 문자열(단어)를 입력받고 출력 (엔터나 스페이스등을 만나기 전까지의 문자열을 가져옴)
		System.out.print("문자열(단어)을 입력하시오. : ");
		String str1 = sc.next();
		System.out.println("입력하신 문자열(단어)는 : " + str1);
		
		//콘솔에서 문자열(문장)를 입력받고 출력
		sc.nextLine();//앞에서 남은 키보드 버퍼의 공백 \n을 비워 주기 위해 사용된다.
		System.out.print("문자열(문장)을 입력하시오. : ");
		String str2 = sc.nextLine();
		System.out.println("입력하신 문자열(문장)는 : " + str2);
		
		//콘솔에서 문자를 입력받고 출력
		System.out.print("문자를 입력하시오 : ");
		char ch1 = sc.next().charAt(0); //next()로 한 단어 문자열을 가지고 오고, String 클래스에서 제공하는 charAt(번지) 기능을통해 0번지(첫번째) 글자를 가지고옴
		System.out.println("입력하신 문자는 : "+ ch1);
			
		
	}

}
