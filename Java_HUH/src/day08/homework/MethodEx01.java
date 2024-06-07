package day08.homework;

import java.util.Arrays;
import java.util.Scanner;

public class MethodEx01 {

	public static void main(String[] args) {
		/* sc.nextInt()을 int 값으로 알아듣는다. 신기하다
		 * 정수 n 을 입력받아 입력받은 n 의 크기를 가지는배열을 생성하는 코드를 작성하세요.
		 */
		System.out.print("배열 개수 입력 : ");
		Scanner sc = new Scanner(System.in);
		int a[] = new int[sc.nextInt()];
		for (int i = 0; i < a.length; i++) {
			a[i] = (1 + i);
		}
		System.out.println(Arrays.toString(a));
	}

}
