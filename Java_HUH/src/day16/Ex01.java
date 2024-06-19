package day16;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		/**
		 * up, down 게임 예제 구현 (1~100)
		 */
		UpDownGame1 ud = new UpDownGame1();
		ud.run();

	}
}// class done

class UpDownGame1 {
	Scanner sc = new Scanner(System.in);

	public void run() {// 메인
		int M = 0;
		int R = 0;
		int N = 0;
		do {
			M = 0;
			menu();
			M = sc.nextInt();
			switch (M) {
			case 1:
				R = getRandom(100, 1);
				System.out.println(R); //디버깅용 R값 (시작하면 렌덤이 제지정되는지 확인하자)
				for (;;) {
					if (game(N, R) == 1) {
						break;
					}
				}
				break;
			case 2:
				System.out.println("종료합니다.");
				break;
			default:
				System.err.println("오류");
				throw new IllegalArgumentException("Unexpected value: " + M);
			}

		} while (M != 2);
	}

	int game(int n, int r) {
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
		return 0;
	}

	void menu() {// 프린팅 메뉴
		System.out.println("업다운 게임");
		System.out.println("1. 시작");
		System.out.println("2. 종료");
		System.out.print("입력 : ");
	}

	int getRandom(int max, int min) {
		int range = (max - min) + 1;
		int random = (int) ((range * Math.random()) + min);
		return random;
	}

}// class done