package day19;

import java.util.Scanner;

public class EnumEx01 {

	public static void main(String[] args) {
		/**
		 * 열거형 : 상수 데이터들의 집합 enum을 이용하여 생성
		 * 
		 * enum 열거 형 명{ 값 1, 값 2, ... }
		 * 
		 * 사용 열거형명 객체명 = 열거형.값;
		 * 
		 * 열거형.valueOf(문자열) :
		 */

		Season s = Season.SPRING;
		System.out.println(s); // SPRING
		System.out.print("봄 : SPRING \n여름 : SUMMER\n가을 : FALL\n겨울 : WINTER\n계절 입력 :  ");
		Scanner sc = new Scanner(System.in);
		String season = sc.next();
		s = Season.valueOf(season);
		System.out.println(s);

		switch (s) {
		case SPRING:
			System.out.println("봄");
			break;
		case SUMMER:
			System.out.println("여름");
			break;
		case FALL:
			System.out.println("가을");
			break;
		case WINTER:
			System.out.println("겨울");
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + s);
		}
		/**
		 * 열거형.values() : 열거형 객체 안에있는 모든 상수들을 배열로 반환
		 * 열거형.ordinal() : 열거형 객체의 순서대로 0부터 사직
		 */
		System.out.print("봄 : 1 \n여름 : 2\n가을 : 3\n겨울 : 4\n계절 입력 :  ");
		int num = sc.nextInt();
		s = null;
		for (Season tmpSeason : Season.values()) {
			if (num == tmpSeason.ordinal() + 1) {
				s = tmpSeason;
			}
		}
		switch (s) {
		case SPRING:
			System.out.println("봄");
			break;
		case SUMMER:
			System.out.println("여름");
			break;
		case FALL:
			System.out.println("가을");
			break;
		case WINTER:
			System.out.println("겨울");
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + s);
		}

	}

	enum Season {
		SPRING, SUMMER, FALL, WINTER
	}

}
