package day10;

import java.util.Arrays;
import java.util.Scanner;

public class VocabularyEx01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max_word = 10;
		int word_count = 0;
		int menu = 0;
		Eng_word word[] = new Eng_word[max_word];
		reselect(word);
		do {
			print_menu();
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				word_count = word_case1(word_count, word, sc, max_word);
				Arrays.sort(word);
				break;
			case 2:
				word_case2(word, max_word, sc);
				break;
			case 3:
				word_case3(word, max_word, sc);
				break;
			case 4:
				word_case4(word, max_word, sc);
				break;
			case 5:
				System.out.println("종료합니다.");
				break;
			default:

			}
		} while (menu != 5);

	}// main done

	public static void reselect(Eng_word[] word) {
		for (int i = 0; i < word.length; i++) {
			word[i] = new Eng_word("", "", "", 0);
		}
	}

	public static void print_menu() {
		System.out.println("메뉴");
		System.out.println("1. 단어 등록");
		System.out.println("2. 단어 수정");
		System.out.println("3. 단어 검색");
		System.out.println("4. 단어 삭제");
		System.out.println("5. 종료");
		System.out.print("입력 : ");
	}// print_menu done

	public static void input_word(int a, Eng_word word[], Scanner sc) {
		System.out.print("단어 : ");
		String tmp1 = sc.next();
		System.out.print("품사 : ");
		String tmp2 = sc.next();
		System.out.print("의미 : ");
		sc.nextLine();
		String tmp3 = sc.nextLine();

		word[a] = new Eng_word(tmp1, tmp2, tmp3, a);
	}

	public static int word_case1(int a, Eng_word word[], Scanner sc, int max_word) {
//		String tmp1, tmp2, tmp3;
		for (int i = 0; i < word.length; i++) {
			if (a > word.length && word[i].getEng_word_number() == 0) {
				input_word(a, word, sc);
				word[a].word_printer();
				return a;
			}
		}
		if (a > word.length) {
			System.out.println("더이상 입력하실 수 없습니다.");
			return a;
		}
		input_word(a, word, sc);
		word[a].word_printer();

		return a++;
	}// word_input done

	public static void word_case2(Eng_word word[], int max_word, Scanner sc) {
		System.out.print("수정할 단어 : ");
		String tmp1 = sc.next();
		int count = 0;
		int select = 0;
		int[] tmp = new int[word.length];
		for (int i = 0; i < word.length; i++) {
			if (word[i].getEng_word() == "") {
				System.out.println(i + "cc");
				continue;
			}
			if (tmp1.equals(word[i].getEng_word())) {
				tmp[i]++;
				System.out.println(tmp[i]);
				count++;
				select = i;
			}
		}
		if (count == 1) {
			System.out.println("단어를 찾았습니다.");
			input_word(select, word, sc);
			return;
		}
		for (int i = 0; i < tmp.length; i++) {
			if (tmp[i] == 0) {
				System.out.println(tmp[i]);
				continue;
			}
			for (int l = 0; l < tmp.length; l++) {
				if (tmp[l] > 1) {
					System.out.println(tmp[l]);
					System.out.println((tmp[l] + 1) + "번 단어 :" + word[l].getEng_word());
				}
			}
			System.out.println("가 중복됩니다. 어느 단어를 변경하시겠습니까?");
			System.out.print("입력 : ");
			select = sc.nextInt();
			if (tmp[select - 1] == 0 || select < 0 || select > tmp.length) {
				System.out.println("잘못 된 입력입니다.");
				return;
			}
			if (tmp[select - 1] != 0) {
				System.out.println("단어를 찾았습니다.");
				input_word(select - 1, word, sc);
				return;
			}
		}
		System.out.println("없는 단어입니다.");
	}// word_case2 done

	public static void word_case3(Eng_word word[], int max_word, Scanner sc) {
		for (int i = 0; i < word.length; i++)
			System.out.print(word[i].getEng_word() + " ");
		System.out.print("검색할 단어 : ");
		String tmp1 = sc.next();
		String nt = null;
		for (int i = 0; i < max_word; i++) {
			if (word[i].getEng_word().equals(nt)) {
				continue;
			}
			if (tmp1.equals(word[i].getEng_word())) {
				System.out.println("단어를 찾았습니다.");
				word[i].word_printer();
				return;
			}
		}
		System.out.println("단어가 없습니다.");
	}// word_case3 done

	public static void word_case4(Eng_word word[], int max_word, Scanner sc) {
		System.out.print("삭제할 단어 : ");
		String tmp1 = sc.next();
		for (int i = 0; i < max_word; i++) {
			if (word[i].getEng_word() == null) {
				continue;
			}
			if (tmp1.equals(word[i].getEng_word())) {
				System.out.println("단어를 삭제합니다.");
				word[i] = new Eng_word("", "", "", 0);
				return;
			}
		}
		System.out.println("단어가 없습니다.");
	}// word_case4 done

}// class VocabularyEx01 done

class Eng_word implements Comparable<Eng_word> {
	private String eng_word, meaning, part_of_speech;
	private int eng_word_number;

	public void word_printer() {
		System.out.println("*** *** *** ***");
		System.out.println("단어 : " + eng_word);
		System.out.println("품사 : " + part_of_speech);
		System.out.println("의미 : " + meaning);
		System.out.println("*** *** *** ***");
	}

	public String getEng_word() {
		return eng_word;
	}

	public void setEng_word(String eng_word) {
		this.eng_word = eng_word;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public String getPart_of_speech() {
		return part_of_speech;
	}

	public void setPart_of_speech(String part_of_speech) {
		this.part_of_speech = part_of_speech;
	}

	public int getEng_word_number() {
		return eng_word_number;
	}

	public void setEng_word_number(int eng_word_number) {
		this.eng_word_number = eng_word_number;
	}

	public Eng_word() {// 생성자
	}

	public Eng_word(String eng_word, String part_of_speech, String meaning, int eng_word_number) {// 생성자
		this.eng_word = eng_word;
		this.meaning = meaning;
		this.part_of_speech = part_of_speech;
		this.eng_word_number = eng_word_number;
	}

	@Override
	public int compareTo(Eng_word other) {
		return eng_word.compareTo(other.eng_word);

	}
}

/*
 * 영어 단어를 관리하기 위한 word 클래스를 만들고, 필요한 멤버변수들을 선언해 보세요 1.영단어 저장 2.영단어 시험 3.영단어 보기
 * 4.영단어 삭제(list보여주고 삭제) 5. 종료
 */