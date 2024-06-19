package day16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		/**
		 * UpDown 게임에 기록추가하기
		 */
		UpDownGame ud = new UpDownGame();
		ud.run();

	}

}

class Grade implements Comparable<Grade> {

	String id;
	int score;

	@Override
	public String toString() {
		return "아이디 : " + id + ", 횟수 : " + score;
	}

	public Grade(String id, int score) {
		this.id = id;
		this.score = score;
	}

	@Override
	public int compareTo(Grade o) {
		return score - o.score;
	}

}

class UpDownGame {
	Scanner sc = new Scanner(System.in);
	List<Grade> list = new ArrayList<Grade>();

	public void run() {// 메인
		int M = 0;
		int R = 0;
		int N = 0;
		int D = 0;
		int count = 0;
		do {
			M = 0;
			menu();
			try {
				M = sc.nextInt();
			} catch (Exception e) {
				System.err.println("숫자가 아닙니다.");
			}
			switch (M) {
			case 1:
				R = getRandom(100, 1);
//				System.out.println(R); // 디버깅용 R값 (시작하면 렌덤이 제지정되는지 확인하자)
				for (;;) {
					count++;
					if (game(N, R) == 1) {
						break;
					}
				}
				D++;
				saveRecord(count);
				count = 0 ;
				break;
			case 2:
				recordMgm(D);
				break;
			case 3:
				System.out.println("종료합니다.");
				break;
			default:
				System.err.println("오류");
				throw new IllegalArgumentException("Unexpected value: " + M);
			}

		} while (M != 3);
	}

	int game(int n, int r) {
		try {
			System.out.print("입력 : ");
			n = sc.nextInt();
			if (n < r) {
				System.out.println("Up");
				return 0;
			}
			if (n > r) {
				System.out.println("Down");
				return 0;
			}
			if (n == r) {
				System.out.println("정답!");
				return 1;
			}
		} catch (Exception e) {
			System.err.println("잘못 입력하셨습니다.");
		}
		return 0;
	}

	void recordMgm(int d) {
		if (d >= 5) {
			for (int i = 5; i < list.size(); i++) {
				list.remove(i);
			}
		}
		for (int i = 0; i <list.size(); i++) {
			System.out.println((i+1) +"등." + list.get(i));
		}
		
	}

	void menu() {// 프린팅 메뉴
		System.out.println("업다운 게임");
		System.out.println("1. 시작");
		System.out.println("2. 기록확인");
		System.out.println("3. 종료");
		System.out.print("입력 : ");
	}

	int getRandom(int max, int min) {
		int range = (max - min) + 1;
		int random = (int) ((range * Math.random()) + min);
		return random;
	}

	void saveRecord(int c) {
		System.out.print("아이디를 입력하여 주세요. : ");
		String tmp = sc.next();
		list.add(new Grade(tmp, c));
		Collections.sort(list);
	}

}// class done