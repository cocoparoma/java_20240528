package day07;

import java.util.Scanner;

public class ScannerEx01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str_test_nextLine, str_test_next;
		//next : 공백을 제외한 연속된 문자열
		//next : 공백을 포함은 연속되지 않은 한줄의 문자열
		System.out.print("str_test_nextLine : ");
		str_test_nextLine = sc.nextLine();
		System.out.print("str_test_next : ");
		str_test_next = sc.next();
		System.out.println("--- --- --- --- --- ---");
		System.out.println("str_test_nextLine : " + str_test_nextLine);
		System.out.println("str_test_next : " + str_test_next);
		sc.nextLine(); // \n Buffer 가져가는 친구
		System.out.println("--- --- --- --- --- ---");
		System.out.println("--- 순서를 바꾸어서 --- ");
		System.out.println("--- --- --- --- --- ---");
		System.out.print("str_test_next : ");
		str_test_next = sc.next();
		sc.nextLine(); // \n Buffer 가져가는 친구
		System.out.print("str_test_nextLine : ");
		str_test_nextLine = sc.nextLine();
		System.out.println("--- --- --- --- --- ---");
		System.out.println("str_test_next : " + str_test_next);
		System.out.println("str_test_nextLine : " + str_test_nextLine);

		
		
	}
	public static void clearScreen() {
		for (int powercleaner = 0; powercleaner < 80; powercleaner++)
			System.out.println("");
	}

}
//변수명 .nextLine(); 으로 \n의 버퍼를 지워주자
//next처리하면 자동으로 \n이 남는데 변수명.nextLine이 남은 버퍼를 가지고 없어진다. 어디 저장할 필요 없으니 저장할 변수명은 생략해주자