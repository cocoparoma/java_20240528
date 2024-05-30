package day03;
import java.util.Scanner;
public class ScannerEx03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score1, score2, score3;
		System.out.println("세 학생의 성적을 입력하세요 : ");
		score1 = sc.nextInt();
		score2 = sc.nextInt();
		score3 = sc.nextInt();
		System.out.println("세 학생의 성적은 " + score1 + ", " + score2 + ", " + score3 + "입니다.");
		//스캐너 사용시 일자 길을 잘 생각해보자(공백 즉 \n 구분하기 위해서)

	}

}
