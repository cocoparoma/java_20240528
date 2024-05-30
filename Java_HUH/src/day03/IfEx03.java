package day03;
import java.util.Scanner;
public class IfEx03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//else if Ex
		System.out.print("정수를 입력해 주세요 : ");
		int num = sc.nextInt();
		if(num>0) {
			System.out.println("입력하신 수는 양수입니다.");
		}else if(num == 0) {
			System.out.println("입력하신 수는 0입니다.");
		}else {
			System.out.println("입력하신 수는 음수입니다.");
		}

	}
}