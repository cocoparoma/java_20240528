package day13;

import java.util.Iterator;

public class ExceptionEx04 {

	public static void main(String[] args) {
		// 예외를 발생시키고 미루는 예제
		int[] arr = null;
		try {
			printArrays(arr);
		} catch (Exception e) {
			// e.getMessage()는 예외 클래스에 있는 message 값을 가져오는 메소드
			// 보통 생성자에서 넣는 문자열을 가져옴
			System.out.println(e.getMessage());
			// e.printStackTrace(); : 예외가 발생한 경로를 순차적으로 콘솔에 출력해준다.
			e.printStackTrace();//경로를 출력해 주어도 프로그램은 종료된것은 아님
		}

		System.out.println("프로그램 종료");
	}

	public static void printArrays(int[] arr) throws Exception/* throw NullPointerException << 생략된것 */ {
		if (arr == null) {
			throw new Exception("배열이 생성되지 않았습니다.");
		}
		for (int tmp : arr) {
			System.out.println(tmp);
		}
	}

}
