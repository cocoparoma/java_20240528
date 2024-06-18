package day15;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		Contacter a = new Contacter();
		a.start();
	}

}

class Contacter {

	ArrayList<String> pNArrayList = new ArrayList<String>();
	Scanner sc = new Scanner(System.in);

	public void start() {

		run(0);

	}

	public void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 번호 추가");
		System.out.println("2. 번호 삭제");
		System.out.println("3. 번호 조회");
		System.out.print("4. 종료");
	}

	public int run(int a) {

		do {
			printMenu();
			a = sc.nextInt();
			switch (a) {
			case 1: {
				System.out.print("번호추가 : ");
				addN();
				break;
			}
			case 2: {
				System.out.print("번호삭제 : ");
				removeN();
				break;
			}
			case 3: {
				System.out.println(pNArrayList);
				break;
			}
			case 4: {
				System.out.println("종료합니다");
				break;
			}

			default:
				throw new IllegalArgumentException("Unexpected value: " + a);
			}

		} while (a != 4);

		return 0;
	}

	public void addN() {
		String tmp = sc.next();
		if (pNArrayList.contains(tmp)) {
			System.out.println("중복된 번호입니다.");
		} else {
			pNArrayList.add(tmp);
		}
	}

	public void removeN() {
		String tmp = sc.next();
		if (pNArrayList.remove(tmp)) {
			System.out.println("삭제 완료");
		} else {
			System.out.println("삭제 실패");
		}
	}

}
