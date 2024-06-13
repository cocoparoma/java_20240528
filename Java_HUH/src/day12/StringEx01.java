package day12;

import java.util.Arrays;

public class StringEx01 {

	public static void main(String[] args) {

		String str = "Hello world";
		// char charAt(index) : 문자열의 index 번지 문자 반환
		System.out.println(str + "의 3번째 문자 : " + str.charAt(2));

		// boolean equals(Object obj) : 문자열이 같은지 반환
		String str2 = "Hellow world";
		System.out.println(str + "이랑" + str2 + "는 같나요? : " + str.equals(str2));

		// int indexOf(String str) : 문자열의 시작 번지를 반환, 없으면 - 1 반환
		System.out.println(str + "에서 world 의 시작 번지는? : " + str.indexOf("world"));

		// boolean contains(String str) : 문자열이 있는지 없는지 반환
		System.out.println(str + "에서 world 가 있습니까? : " + str.contains("world"));

		// String replace(str1, str2) : 문자열에서 찾을 문자열을 찾아서 교체할 문자열로 바꾼 후 반환
		System.out.println(str + "에서 o 를 O로 전환 : " + str.replace("o", "O"));
		System.out.println("바꾼 후 str : " + str); // 값을 반환 해주는것 원본을 수정하지 아니함

		// String substring(시작 번지) : 시작번지부터 부분 문자열을 추출
		// String substring(시작번지 , 끝번지) : 시ㅣ작번지부터 끝번지 전까지 부분 문자열을 추출(마지막 포함 안함)
		System.out.println(str + "에서 6번지부터 부분 문자열 : " + str.substring(6));
		System.out.println(str + "에서 6번지부터 10번지 전 까지의 문자열 : " + str.substring(6, 10));

		// String toLowerCase() : 소문자로
		// String toUpperCase() : 대문자로
		System.out.println(str + "을 소문자로 : " + str.toLowerCase());
		System.out.println(str + "을 대문자로 : " + str.toUpperCase());

		// String trim() : 첫 문자 앞 공백과 마지막 문자 뒤 공백을 제거한 문자열을 반환 > a b 중간의 공백을 없에줌
		String str3 = "반가워요                             리뷰입니다.                                       \n";
		System.out.println(str3.trim());

		// String valueOf(기본자료형) : 기본 자료형을 문자열로 변환
		String str4 = String.valueOf(1); // str + "1" 즉 "" + "1"
		System.out.println(str4); // str4는 문자열
		String str5 = String.valueOf(true);// str + "true" 즉 "" + "true"
		System.out.println(str5);

		// String[] split(정규표현식) : 정규표현식을 기준으로 문자열을 추출하여 배열로 전환
		String fruit = "오렌지,포도,바나나,사과,수박";
		String[] fruits = fruit.split(",");
		System.out.println(Arrays.toString(fruits));

		// String 은 수정 보다는 새로 만들어서 교체한다. 수정은 StringBuffer class를 사용해보자
	}

}
