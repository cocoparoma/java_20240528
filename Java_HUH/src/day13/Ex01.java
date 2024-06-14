package day13;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		/**
		 * 다음과 같은 책 제목들이 있을 때 원하는 단어를 검색해서 해당 단어가 있는 책을 출력하는 코드를 작성하시오
		 */
		String[] bookList = { "자바의 정석", "혼자하는 자바", "혼자하는 C", "수학의 정석", "누구나 하는 C" };
		boolean thereIs = false;
		int OnOff = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("찾으시는 책의 이름 혹은 함유된 단어를 입력해 주세요 : ");
		String getBoodName = sc.nextLine();
		for (int i = 0; i < bookList.length; i++) {
			thereIs = bookList[i].contains(getBoodName);
			if (thereIs) {
				System.out.println(bookList[i]);
				OnOff++;
			}
		}
		if (OnOff == 0)
			System.out.println("찾으시는 책이 없습니다.");
	}// main done

	public static void searchBook2(String bookList[]) {
		String search = "자바";
		int count = 0;
		for (String book : bookList) {
			System.out.println(book);
			count++;
		}
		if (count == 0)
			System.out.println("일치하는 책이 없습니다. ");
	}

}// class done
