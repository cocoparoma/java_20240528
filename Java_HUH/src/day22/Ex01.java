package day22;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		System.out.print("문장을 단어로!\n>>");

		String str = sc.nextLine();

		StringTokenizer st = new StringTokenizer(str, " ");
		while (st.hasMoreTokens()) {
			String token = st.nextToken();// 토큰을 가져옴
			System.out.println(token);
			count++;
		}
		System.out.println("이 문장은 " + count + "개의 단어를 가지고 있습니다.");

		/**
		 * str = sc.nextLint();
		 *  String [] words = str.split(" "); 
		 *  syso(words.legth):
		 */

	}
}