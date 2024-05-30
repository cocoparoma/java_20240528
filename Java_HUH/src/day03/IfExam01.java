package day03;
import java.util.Scanner;
public class IfExam01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("나이를 입력해주세요 : ");
		int age = sc.nextInt();
		//if - else 문으로 출력하는 버전
		if(age >= 19) {
			System.out.println("성인입니다.");
		} else {
			System.out.println("미성년자입니다.");
		}
		
		//String에 받아서 출력하는 버전
		String str = (age >= 19) 
		? "성인입니다."
		: "미성년자 입니다.";			//str값에 저장
		System.out.println(str);//출력
		
		//println으로 바로 출력하는 버전
		System.out.println((age >= 19) ? "성인입니다.": "미성년자 입니다.");
		
		
	}
}