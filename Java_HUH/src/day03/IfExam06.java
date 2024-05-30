package day03;
import java.util.Scanner;
public class IfExam06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("성적을 입력해 주세요 : ");
		int score = sc.nextInt();
		if (100 >=score && score >= 90) {
			System.out.println("A 등급");
		}else if(90 >score && score >= 80) {
			System.out.println("B 등급");
		}else if(80 >score && score >= 70) {
			System.out.println("C 등급");
		}else if(70 >score && score >= 60) {
			System.out.println("D 등급");
		}else if(60 >score && score >= 0) {
			System.out.println("F 등급");
		}else {
			System.out.println("잘못된 성적입니다.");//예외처리
		}
	}
}