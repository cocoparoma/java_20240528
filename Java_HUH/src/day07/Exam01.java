package day07;
import java.util.*;
public class Exam01 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		String[] word_list = new String[10]; String answer;
		int menu = 0; int count = 0; int ui = 0; boolean ox = false;
		do {
			clearScreen();
			System.out.println("- - - - - - -");
			System.out.println("메뉴");
			System.out.println("1. 추가");
			System.out.println("2. 검색");
			System.out.println("3. 종료");
			System.out.println("- - - - - - -");
			System.out.print("메뉴 입력 :");
			menu = sc.nextInt();
			clearScreen();
			switch(menu) {
			case 1 :
				for(int i = 0;  ; i++ ) {
					System.out.print("단어 추가 (뒤로 : 0): ");
					answer = sc.next();
					sc.nextLine();
					if(answer.equals("0")) {
						break;
					}
					clearScreen();
					if(count == 10) {
						System.out.println("X 단어 추가 실패");
					} else {
						System.out.println("O " +(count + 1) +"단어 추가 성공");
						word_list[i] = answer;
						count ++;
					}
				}
				break;
			case 2 :
				while(true) {
					System.out.print("단어 입력 (뒤로 : 0): ");
					answer = sc.next();
					sc.nextLine();
					if(answer.equals("0")) {
						break;
					}
					for(int i = 0; i < word_list.length ; i ++) {
						if(answer.equals(word_list[i])) {
							ui++;
							ox = true;
							break;
						}
					}
					clearScreen();
					if(ox == true) {
						System.out.println("O 있는 단어 :" + word_list[ui - 1]);
						ox = false;
					} else {
						System.out.println("X 없는 단어");
					}
				}
				break;
			case 3:
				System.out.println("종료합니다.");
				break;
			default :
				System.out.println("잘못된 메뉴입니다.");
			}

		}while(menu != 3);

	}
	public static void clearScreen() {
		for (int i = 0; i < 80; i++)
			System.out.println("");
	}
	public static void pause() {
		String pause;
		for(;;) {
			System.out.print("");
			pause = sc.next();
			break;
		}
	}
}
