package day10;

import java.util.Scanner;


public class VocabularyEx01_another_way {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		int menu = 0;
		int conuting_Word = 0;
		final int MAX_WORD = 2;
		Word[] wordList = new Word[MAX_WORD];
		startScreen(menu);

		do {
			menu = startScreen(menu);
			switch (menu) {
			case 1:
				// 단어 등록
				conuting_Word = registration_word(conuting_Word,wordList);
				//단어 최대치 증가
				if(wordList.length == conuting_Word) {
					//최대치 증가 기능 
				}
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				ending();
				break;
			default:
				err();
			}
		} while (menu != 5);


		
		
	}// main done

	static int startScreen(int menu) {
		Word.print_Menu();
		menu = sc.nextInt();
		return menu;
	}// start done

	static void ending() {
		System.out.println("종료합니다");
	}//ending done
	
	static void err() {
		System.out.println("오류입니다.");
	}//ending done
	
	//단어 추가
	static int registration_word(int CWord, Word[] wordList) {
		//새로단어 받아오기
		Word tmp = inputWord();
		//가장 최근 배열에 저장
		wordList[CWord] = tmp;
		//최대치 하나 증가
		CWord++;
		//단어 정렬
		sortword(wordList, CWord);
		//리턴
		return CWord ;
	}
	
	//단어 최대치 증가
	static Word[] maxWordUp(int cWord, Word[] word) {
		
		return word;
	}
	
	
	
	static void sortword(Word[] word,int cWord ) {
		for(int i = 0; i < cWord; i ++ ) {
			for(int j = 0; j < cWord;) {
				if(word[j].getWord().compareTo(word[j+1].getWord())>0) {
					Word tmp = word[j];
					word[j]= word[j+1];
					 word[j+1] = word[j];
				}
			}
		}
	}
	
	
	static Word inputWord() {
		System.out.print("단어 : ");
		String word = sc.next();
		System.out.print("품사 : ");
		String part_of_speech = sc.next();
		System.out.print("단어 : ");
		sc.nextLine();
		String meaning = sc.nextLine();
		Word tmp = new Word(word, part_of_speech, meaning);
		return tmp;
	}
	
}//VocabularyEx01_another_way class done















class Word {
	//@param 
	private String word;
	private String part_of_speech;
	private String meaning;

	public Word(String word, String part_of_speech, String meaning) {
		this.word = word;
		this.part_of_speech = part_of_speech;
		this.meaning = meaning;
	}//생성자

	public Word() {
		
	}// 생성자
	static void print_Menu() {
		System.out.println("메뉴");
		System.out.println("1. 단어 등록");
		System.out.println("2. 단어 수정");
		System.out.println("3. 단어 검색");
		System.out.println("4. 단어 삭제");
		System.out.println("5. 종료");
		System.out.print("입력 : ");
	}// menu done

	void updateWord(Word word) {
		this.word = word.word;
		this.meaning = word.meaning;
		this.part_of_speech = word.part_of_speech;
	}

	void showWord() {
		System.out.println("단어 : " + word);
		System.out.println("품사 : " + part_of_speech);
		System.out.println("의미 : " + meaning);
	}
	void showWord1(Word word) {
		System.out.println("단어 : " + word);
		System.out.println("품사 : " + part_of_speech);
		System.out.println("의미 : " + meaning);

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//getter, setter
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getPart_of_speech() {
		return part_of_speech;
	}

	public void setPart_of_speech(String part_of_speech) {
		this.part_of_speech = part_of_speech;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}//getter, setter done

}//word class done
