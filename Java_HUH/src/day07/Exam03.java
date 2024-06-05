package day07;
import java.util.*;
public class Exam03 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		 int ui = 0; 
		boolean ox = false;
		String[] list = new String[] {"cat", "dog", "banana"};
		String answer;
		clearScreen();
		for(;;) {
			System.out.print("단어 입력 (종료 -1) : ");
			answer = sc.next();
			sc.nextLine();
			for(int i = 0; i < list.length; i ++ ) {
				if(answer.equals(list[i])) {
					ox =true; break;
				}//if로 칠때는 종료코드를 위에 두어서 다른 특수한 경우로 빠지는 길을 방지하자
			}
			if(answer.equals("-1")) {
				System.out.println("종료합니다.");
				break;
			}
			if(ox == true) {
				clearScreen();
				System.out.println("있는 단어 입니다.");
				ox = false;
			} else if (ox == false) {
				clearScreen();
				System.out.println("없는 단어 입니다.");
			}
		}
	}

	public static void clearScreen() {
		for(int i = 0 ; i < 80 ; i ++) {
			System.out.println();
		}
	}
}
