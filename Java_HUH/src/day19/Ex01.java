package day19;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			System.out.print( (i+1) +"번째 문자열 입력\n>>");
			list.add(sc.nextLine());
		}

		/**
		 *5개 문자열을 입력받아 리스트에 저장하는 예제
		 */
		List<String> alist = new ArrayList<String>();
		System.out.print("포함한 단어 찾기\n>>");
		String containsString = sc.nextLine(); 
		alist = list.stream().filter(p->p.contains(containsString)).toList();
		
		System.out.println("리스트" + list);
		System.out.println("원하는 단어를 포함한 리스트" + alist);
		
		/**
		 * 문자열 A를 입력받아 리스트에 A를 포함하는 문자열들을 출력하는 예제
		 */
	}

}
