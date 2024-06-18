package day15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		/**
		 * 숫자 야구 게임을 구현하시오 중복되지 않은 1~9까지 3개의 숫자 생성 사용가 숫자 3개를 중복되지 않게 1~9의값 출력 입력된 값을
		 * 비교, 출력 비교 s:숫자가 있고 위치가 같은경우 b:숫자가 있고 위치가 다른 경우 o:일치하는 숫자가 없는 경우
		 */
		Game aGame = new Game();
		aGame.gameRun();
	}
}

class Game {
	public final int GAME_START = 1;
	public final int GAME_EXIT = 2;
	Scanner sc = new Scanner(System.in);
	ArrayList<Integer> ballArrayList = new ArrayList<Integer>();
	ArrayList<Integer> catchArrayList = new ArrayList<Integer>();

	public Game() {// 생성자
	}

	void gameRun() {//반복문 돌아갈 곳

		int M = 0;
		do {
			gameMenu();
			M = sc.nextInt();
			switch (M) {
			case GAME_START:
				System.out.println("공 던지는중 . ");
				System.out.println("공 던지는중 . . ");
				System.out.println("공 던지는중 . . . ");
				System.out.println("공 던지는중 . . .  완료");
				throwBall();// 공 배치 완료
				try {
					for (;;) {
						if (bigyo() == 1) {
							System.out.println("축하드립니다! 성공!!!");
							break;
						}
					}
				} catch (Exception e) {
					System.err.println("잘못된 입력방식 입니다. 정수를 넣어주세요.");
					e.printStackTrace();
				}
				break;
			case GAME_EXIT:
				System.out.println("End");
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + M);
			}
		} while (M != 2);

	}

	int bigyo() throws Exception {
		catchBall();// 공 입력받기
		int S = 0, B = 0, O = 3;
		if (ballArrayList.get(0) == catchArrayList.get(0)) S++;
		else if(catchArrayList.contains(ballArrayList.get(0))){B++;}
		if (ballArrayList.get(1) == catchArrayList.get(1)) S++;
		else if(catchArrayList.contains(ballArrayList.get(1))){B++;}
		if (ballArrayList.get(2) == catchArrayList.get(2)) S++;
		else if(catchArrayList.contains(ballArrayList.get(2))){B++;}
		O = O - S;
		O = O - B;
		System.out.println("S : " + S + ", B : " + B + ", O : " + O);
		if (S == 3)
			return 1;
		return 0;
	}

	void catchBall() throws Exception {
		catchArrayList.clear();
		System.out.println("1~9까지 정수만 입력해 주세요");
		System.out.print("첫번째 공 : ");
		catchArrayList.add(sc.nextInt());
		System.out.print("두번째 공 : ");
		catchArrayList.add(sc.nextInt());
		System.out.print("세번째 공 : ");
		catchArrayList.add(sc.nextInt());
	}

	void throwBall() {
		ballArrayList.clear();
		ballArrayList.add(1);// 0번지
		ballArrayList.add(2);
		ballArrayList.add(3);
		ballArrayList.add(4);
		ballArrayList.add(5);
		ballArrayList.add(6);
		ballArrayList.add(7);
		ballArrayList.add(8);
		ballArrayList.add(9);// 8번지
		Collections.shuffle(ballArrayList);// 값렌덤 변경
		System.out.println("디버깅용 : " +ballArrayList.get(0) + ", " +ballArrayList.get(1)+ ", " +ballArrayList.get(2));//디버깅용
	}

	void gameMenu() {
		System.out.println("즐거운 야구 게임");
		System.out.println("1. 게임 시작");
		System.out.println("2. 종료");
		System.out.print("입력 : ");
	}

}