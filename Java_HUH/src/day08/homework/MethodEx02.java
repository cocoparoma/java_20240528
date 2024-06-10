package day08.homework;

import java.util.Arrays;
import java.util.Scanner;

public class MethodEx02 {

	public static void main(String[] args) {
		/*
		 * 1부터 9 까지 렌덤한 숫자를 배열에 저장하여 콘솔에 출력하는 코드를 작성하시오.
		 */
		System.out.print("배열 개수 입력 : ");
		Scanner sc = new Scanner(System.in);
		int a[] = new int[sc.nextInt()];
		for (int i = 0; i < a.length; i++) {
			a[i] = Random(9, 1);
		}

		System.out.println(Arrays.toString(a));
	}// main done

	static int Random(int max,  int min) {
		return (int) (Math.random() * (max - min + 1) + min);
		//Math.random()  * (9) + 1
	}// random done

}// class done
