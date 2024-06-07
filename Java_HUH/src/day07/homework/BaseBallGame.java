package day07.homework;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BaseBallGame {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int[] throwBall = new int[3];
		int menu = 0;
		int accept_Random = 0;
		int OnOff = 0;
		int[] answer = new int[3];
		int s = 0;
		int b = 0;
		int score = 0;

		do {
			clearScreen();
			System.out.println("신나는 야구게임");
			System.out.println("1. 플레이");
			System.out.println("2. 기록 보기");
			System.out.println("3. 종료");
			System.out.print("입력 : ");
			menu = sc.nextInt();
			clearScreen();
			switch (menu) {
			case 1:
				System.out.println("야구게임 (0 : 뒤로가기)");
				for (int i = 0; i < throwBall.length; i++) {
					accept_Random = random_maker();
					for (int j = 0; j < throwBall.length; j++) {
						if (throwBall[j] == accept_Random) {
							OnOff = 1;
							break;
						}
					}
					if (OnOff == 1) {
						i--;
						OnOff = 0;
					} else {
						throwBall[i] = accept_Random;
					}
				}
				for (;;) {
					s = 0;
					b = 0;
					for (int i = 0; i < answer.length; i++) {
						System.out.print((i + 1) + "번째 숫자를 입력해 주세요(1~9) : ");
						answer[i] = sc.nextInt();
					}
					for (int i = 0; i < answer.length; i++) {
						if (throwBall[i] == answer[i]) {
							s++;
						} else {
							for (int j = 0; j < answer.length; j++) {
								if (throwBall[i] == answer[j]) {
									b++;
									break;
								}
							}
						}
					}
					System.out.println(s + "s" + b + "b");
					if (s == 3) {
						System.out.println("정답입니다!!");
						System.out.println(Arrays.toString(throwBall));
						score++;
						pause();
						break;
					}
				}
				break;
			case 2:
				clearScreen();
				System.out.println("당신의 점수는 : " + score + "입니다.");
				pause();
				break;
			case 3:
				clearScreen();
				System.out.println("종료합니다.");
				break;

			}

		} while (menu != 3);

	}// main out

	public static void clearScreen() {
		for (int i = 0; i < 80; i++) {
			System.out.println();
		}
	}

	static int random_maker() {
		int max = 9;
		int min = 1;
		int random = (int) (Math.random() * (max - min + 1) + min);
		return random;
	}

	public static void pause() {
		try {
			System.out.println("enter를 눌러주세요");
			System.in.read();
		} catch (IOException e) {
		}
	}

}// class out
