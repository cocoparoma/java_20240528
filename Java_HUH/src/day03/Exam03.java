package day03;
import java.util.Scanner;
public class Exam03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);//과목 1, 2 값을 받음
		System.out.print("과목 1의 성적을 입력해 주세요 : ");
		int score_n1 = sc.nextInt();
		System.out.print("과목 2의 성적을 입력해 주세요 : ");
		int score_n2 = sc.nextInt();
		double avg = (score_n1 + score_n2) /2.0; //더블 형으로 소수점을 포함한 평균값을 구함
		String result = (avg >= 60 && score_n1 >= 40 && score_n2 >= 40) ? "합격" : "불합격"; //조건식을 확인한 후 결과값을 스트링에 저장
		System.out.println("결과 : "+ result); // 저장한 스트링 값을 출력
	}
}//코드에 주석을 다는 연습하는게 좋음 