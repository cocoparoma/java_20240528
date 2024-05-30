package day03;
import java.util.Scanner;
public class IfEx02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력해 주세요 : ");
		int num = sc.nextInt();
		//if else (조건식)으로 이어가도 괜찮음
		if(num%2 == 1){
			System.out.println("홀수입니다."); //나머지 1 == 참일 때
		} else {
			System.out.println("짝수입니다.");//나머지 1 == 거짓일 때 (위의조건이 거짓일때)
		}
		//해당문법처럼 홀짝같은 간단한 연산은 삼항연산자가 더 짧고 보기 편함
	}
}
