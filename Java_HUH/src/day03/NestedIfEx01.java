package day03;
import java.util.Scanner;
public class NestedIfEx01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 하나를 입력해 주세요 : ");
		int su = sc.nextInt();

		if(su%2 == 0) {
			if(su%3 ==0) {
				System.out.println("6의 배수입니다.");
			} else {
				System.out.println("2의 배수입니다.");
			}	
		} else if (su%3==0) {
			System.out.println("3의 배수입니다.");
		} else {
			System.out.println("6,3,2의 배수가 아닙니다.");
		}





	}

}
