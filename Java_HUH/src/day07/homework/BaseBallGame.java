package day07.homework;
import java.util.*;
public class BaseBallGame {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int[] throwBall = new int [3]; int menu = 0;
		BaseBallGame ran = new BaseBallGame();
		throwBall[0] = ran.random_maker();
		System.out.println(throwBall[0]);
		do {
			System.out.println("신나는 야구게임");
			System.out.println("1. 플레이");
			System.out.println("2. 기록 보기");
			System.out.println("3. 종료");
			System.out.print("입력 : ");
			menu = sc.nextInt();
			
			
			
			
			switch(menu) {
			case 1:
			case 2:
			case 3:
				
			}
			
			
			
		}while(menu != 3);
















	}//main out
	public static void clearScreen() {
		for(int i = 0 ; i < 80 ; i ++) {
			System.out.println();
		}
	}
	 int random_maker() {
		int max = 9; int min = 1;
		int random = (int)(Math.random()*(max - min +1) + min);
		return random;
	}
	
}//class out
