package day15;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {

		PhoneNumber pn = new PhoneNumber();
		pn.start();

	}

}

class PhoneNumber {

	Scanner scanner = new Scanner(System.in);
	ArrayList<String> pNumber = new ArrayList<String>();

	public void start() {
		// 잘 입력했다고 가정
		for (int i = 0; i < 5; i++) {
			System.out.println((i + 1) + "번째 " + "전화번호를 입력하시오 ");
			System.out.print("입력 : ");
			pNumber.add(scanner.next());
		}
		System.out.println(pNumber);
		removeNumber();
	}
	
	public void removeNumber() {
		System.out.println(pNumber);
		System.out.print("삭제할 번호 : ");
		String tmpString =scanner.next();
		if (pNumber.remove(tmpString)) {
			System.out.println("삭제 완료");
		} else {
			System.out.println("삭제 실패");
		}
		
		System.out.println(pNumber);
		
	}

}



































