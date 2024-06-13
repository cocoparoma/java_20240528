package day12;

import java.util.Random;

public class RandomEx01 {

	public static void main(String[] args) {
		Random r1 = new Random(10);
		for (int i = 0; i < 100; i++) {
			int num = r1.nextInt(10);
			System.out.print(num+"  " + (i%30 == 29 ? "\n" : ""));
		}
		
		System.out.println();
		System.out.println("=============================");
		
		Random r2 = new Random();//현재 시간을 seed값으로 활용하여 매번 실행마다 다른 패턴의 랜덤수를 생성할 수 있다.
		for (int i = 0; i < 100; i++) {
			int num = r2.nextInt(10);
			System.out.print(num+"  " + (i%30 == 29 ? "\n" : ""));
		}
	}

}
