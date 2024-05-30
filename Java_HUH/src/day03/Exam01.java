package day03;
import java.util.Scanner;
public class Exam01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("성적을 입력해 주세요 : ");
		int score = sc.nextInt();
		String str = (score >= 60) ? "Pass" : "Fail" ;
		System.out.println("당신은 " + score +"점 으로 " + str + " 입니다.");

	}

}
