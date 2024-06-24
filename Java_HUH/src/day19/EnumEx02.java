package day19;

import java.util.Scanner;


public class EnumEx02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("봄 : 1 \n여름 : 2\n가을 : 3\n겨울 : 4\n계절 입력 :  ");
		
		int num = sc.nextInt();
		
		Season2 s  =Season2.fromValue(num);

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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	enum Season2{
		SPRING(1), SUMMER(2),FALL(3),WINTER(4);
		
		private final int value;
		
		private Season2(int value) {
			this.value = value;
		}
		public int getValue() {
			return value;
		}
		public static Season2 fromValue(int value) {
			for (Season2 tmpSeason : Season2.values()) {
				if (tmpSeason.getValue() == value) {
					return tmpSeason;
				}
			}
			throw new IllegalArgumentException("잘못된 계절입니다.");
		}
	}
	
}
