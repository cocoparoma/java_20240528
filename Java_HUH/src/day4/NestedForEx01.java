package day4;
import java.util.Scanner;
public class NestedForEx01 {
	public static void main(String[] args) {
		/* 구구단 2~9단을 출력하는 코드를 작성하세요.
		 * 반복횟수 : num를 2부터 9까지 1씩 증가
		 * 규칙성 : num단 출력하는 코드
		 * 반복문 종료 후 : 없음
		 * */
		Scanner sc = new Scanner(System.in);
		int num;
		for(;;) {
			System.out.print("구구단 몇단(0를 누르면 종료) : ");
			num = sc.nextInt();
			if(num == 0) {
				break;
			}
			for(int i = 1; i <= 9; i++) {
				System.out.println(num +" x " + i +" = "+ (i*num));
			}
		}
		System.out.println("finish");
		
	}

}
