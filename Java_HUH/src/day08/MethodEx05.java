package day08;

import java.io.IOException;
import java.util.*;

public class MethodEx05 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		/*
		 * 정수 배열이 주어지고 주어진 배열에 원하는 정수가 있는지 없는지 확인하는 코드를 작성하세요. 단 메서드를 이용하여 Put_In(),
		 * clearScreen(), finder(), random()
		 */
		int tmp = 0;
		boolean ox = true;
		int[] arr_random = new int[5];
		for (int i = 0; i < arr_random.length; i++) {
			arr_random[i] = Put_In(tmp, ox, arr_random, i);
		}
		for (;;) {
			clearScreen();
			System.out.println(Arrays.toString(arr_random));
			System.out.print("숫자를 입력하시오 (0 : 나가기): ");
			tmp = sc.nextInt();
			if (tmp == 0) {
				System.out.println("종료");
				break;
			}
			ox = finder(tmp, arr_random.length, arr_random);
			System.out.println((ox) ? "있습니다." : "없습니다.");
			pause();
		}
	}// main done

	static int random() {
		int max = 9;
		int min = 1;
		return (int) (Math.random() * (max - min + 1) + min);
	}// random done

	static boolean finder(int a, int b, int[] c) { // Scanner = a, arr_random.length = b, arr_random[] =c
		for (int i = 0; i < b; i++) {
			if (c[i] == a) {
				return true;
			}
		}
		return false;
	}// finder done

	public static void clearScreen() {
		for (int i = 0; i < 80; i++) {
			System.out.println();
		}
	}// clearScreen done

	static int Put_In(int a, boolean b, int c[], int i) {// a= tmp, b= ox , c = arr_random[i], int i = i++
		a = random();
		b = true;
		for (int j = 0; j < c.length; j++) {
			if (c[j] == a) {
				b = false;
				break;
			}
		}
		if (b) {
			c[i] = a;
			return a;
		}
		return i--;
	}// Put_In done

	public static void pause() {
		try {
			System.out.println("enter를 눌러주세요");
			System.in.read();
		} catch (IOException e) {
		}
	}// pause done

}// class done
