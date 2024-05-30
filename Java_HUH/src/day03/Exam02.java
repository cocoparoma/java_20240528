package day03;
import java.util.Scanner;
public class Exam02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("학생1의 점수를 입력해 주세요 : ");
		int n1st = sc.nextInt();
		System.out.print("학생2의 점수를 입력해 주세요 : ");
		int n2st = sc.nextInt();
		System.out.print("학생3의 점수를 입력해 주세요 : ");
		int n3st = sc.nextInt();
		int total = n1st + n2st + n3st;
		double avg = (double)total/3.0;
		System.out.println("총점은 : " + total + "점. 평균은 : " + avg + "점 입니다.");
	}

}
