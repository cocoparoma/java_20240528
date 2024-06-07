package day08.homework;

import java.util.Arrays;
import java.util.Scanner;

public class MethodEx03 {

	public static void main(String[] args) {
		/*
		 * 배열에 랜덤으로 1~9 사이의 중복되지 않은 배열을 생성하고 콘솔에 출력하는 코드 작성 단 메소드 이용
		 */
		int random_arr[] = Random_arr_maker();
		random_arr = double_check(random_arr);
		System.out.println(Arrays.toString(random_arr));

	}// main done

	static int Random() {
		int max = 9;
		int min = 1;
		return (int) (Math.random() * (max - min + 1) + min);
	}// random done

	static int[] Random_arr_maker() {
		System.out.print("배열 개수 입력(! 9까지만) : ");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int tmp = Integer.parseInt(str);
		if (tmp > 9) {
			System.out.println("9 가 최대입니다.");
			tmp = 9;
		}
		int a[] = new int[tmp];

		for (int i = 0; i < a.length; i++) {
			a[i] = Random();
		}
		return a;
	}// arr_maker done

	static int[] double_check(int a[]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 1; j + i < a.length; j++) {
				if (a[i] == a[i + j]) {
					a[i] = Random();
					j = 0;
					i = 0;
				}
			}
		}
		return a;
	}// double_check done

}// class done
