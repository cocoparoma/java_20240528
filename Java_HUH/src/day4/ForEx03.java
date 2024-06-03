package day4;
import java.util.Scanner;
public class ForEx03 {
	public static void main(String[] args) {
		/* 문자를 입력받고 입력받은 문자가 y이면 종료하는 코드를 작성하세요.(for문 이용)
		 * */
		Scanner sc = new Scanner(System.in);
		for(char ch = 'a'; ;) {
			System.out.print("y = exit : ");
			ch = sc.next().charAt(0);
			if(ch == 'y') {
				break;
			}
		}
		System.out.println("finish");
	}
}