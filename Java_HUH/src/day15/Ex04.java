package day15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		Lotto aLotto = new Lotto();
		aLotto.run();

	}

}

class Lotto {
	public ArrayList<Integer> ball = new ArrayList<Integer>();// 렌덤으로 점칠된 로또번호
	public ArrayList<Integer> list = new ArrayList<Integer>();// 인생을 건 나의 번호
	public Scanner sc = new Scanner(System.in);

	public Lotto() {// 생성자

	}

	public void run() {// 런 메뉴
		makeNumber();
		// 결과값 먼저보기
//		for (int i = 0; i < 7; i++) {
//			System.out.print(ball.get(i) + "  ");
//		}
		System.out.println("또다시 돌아온 로또");
		System.out.println("*** *** *** *** ***");
		inputNumber();
		System.out.println("*** *** *** *** ***");
		System.out.println(searchNumber());//서치넘버에 로또result가 들어가있음
		System.out.println("*** *** *** *** ***");
		System.out.println("입력하신 값");
		System.out.println(list);
		System.out.println("로또 값 (마지막은 보너스 공)");
		for (int i = 0; i < 7; i++) {
			System.out.print(ball.get(i) + "  ");
		}
		System.out.println();
		System.out.println("*** *** *** *** ***");
	}

	public void makeNumber() {

		for (int i = 1; i <= 45; i++) {
			ball.add(i);
		}
		Collections.shuffle(ball);
	}

	public String searchNumber() {
		int count = 0;
		int bonus = 0;
		for (int i = 0; i < 6; i++) {
			if (list.contains(ball.get(i))) {
				count++;
			}
		}
		if (list.contains(ball.get(6))) {
			bonus++;
		}
		return resultLotto(count, bonus);
	}

	public void inputNumber() {
		for (int i = 1; i <= 6; i++) {
			System.out.print(i + "번째 번호 : ");
			int tmp = sc.nextInt();
			list.add(tmp);
		}
		System.out.print("보너스 번호 : ");
		int tmp = sc.nextInt();
		list.add(tmp);

		System.out.println("총 입력한 번호");
		System.out.println(list);
	}

	public String resultLotto(int count, int bonus) {
		if (count == 6) {
			return "1등";
		}
		if (count == 5 && bonus == 1) {
			return "2등";
		}
		if (count == 5) {
			return "3등";
		}
		if (count == 4) {
			return "4등";
		}
		if (count == 3) {
			return "5등";
		}
		return "꽝";
	}

}