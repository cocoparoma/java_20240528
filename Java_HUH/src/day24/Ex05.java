package day24;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean res = true;
		
		
		while (res) {
			System.out.println("문자열 입력 : ");
			String str = sc.next();
			if (str.equals("EXIT")) {
				break;
			}
			System.out.println(str);
		}
		System.out.println("end");
	}

}
/**
 * 원인 : 반복문이 true가 아니라 진입하지 못했고 equals가 아닌 == 을 사용하여 문자열을 비교하지 못했고 continue를 이용하였기에 반복문에서 빠져나오지 못하는 상황
 * 해결방안 : res = true, equals("EXIT"), break; 사용
 */

