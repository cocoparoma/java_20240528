package day03;
import java.util.Scanner;
public class IfExam04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력해 주세요 : ");
		int su = sc.nextInt();
//		if (su%3 == 0) {
//			System.out.println("3의 배수입니다.");
//		} else {
//			System.out.println("3의 배수가 아닙니다.");
//		}
		System.out.println((su%3 == 0) ? "3의 배수입니다." : "3의 배수가 아닙니다.");
	}
}
