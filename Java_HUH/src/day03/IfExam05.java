package day03;
import java.util.Scanner;
public class IfExam05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력해 주세요 : ");
		int su = sc.nextInt();
		if(su%2 == 0 && su%3==0) {
			System.out.println("6의 배수입니다.");
		} else if(su%2 == 0) {
			System.out.println("2의 배수입니다.");
		} else if(su%3 == 0) {
			System.out.println("3의 배수입니다.");
		} else {
			System.out.println("6 혹은 2, 3의 배수가 아닙니다.");
		}
		//ifif 2중중첩문도 괜찮아 보임 if 2의배수{if3의배수} else if 3의배수
	}

}
