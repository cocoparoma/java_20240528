package day07;
import java.util.*;
public class Exam02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int word_number = 2; int ui = 0; char ending = 'a';
		String[] word = new String[word_number];
		do {
			System.out.println("1.단어 입력");
			System.out.println("2.단어 확인");
			System.out.println("3.종료");
			ui = sc.nextInt();
			switch(ui) {
			case 1:
				for(int i = 0; i < word.length ; i ++) {
					System.out.println("단어를 입력해 주세요 :");
					word[i] = sc.next();
					sc.nextLine();
					System.out.println("단어를 추가하였습니다.");
				}
				break;
			case 2:
				System.out.println("입력한 단어 : " +Arrays.toString(word));
				break;
			case 3:
				System.out.println("종료");
				break;
			default :
				System.out.println("오류");
			}
		}while(ui != 3);

	}

}
