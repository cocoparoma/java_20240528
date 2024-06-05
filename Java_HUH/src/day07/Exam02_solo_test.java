package day07;

import java.util.*;

public class Exam02_solo_test {

	public static void main(String[] args) {
		int word_number = 2; String tmp; int count = 0;
		Scanner sc = new Scanner(System.in);
		String[] word = new String[word_number];
		while(true) {
			System.out.print("단어 입력 (종료 : -1) : ");
			tmp = sc.next();
			sc.nextLine();
			if(tmp.equals("-1")) {
				System.out.println("종료");
				break;
			}
			if(count == 2)
			{
				System.out.println("단어 추가 실패");
			} else {
				word[count] = tmp;
				count++;
				System.out.println("단어 추가 성공");
			}
		}


	}

}
