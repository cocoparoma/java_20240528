package day07;

import java.util.*;

public class ArrayEx01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int student[][] = new int[3][3];
		int korean[] = new int[3];
		int english[] = new int[3];
		int math[] = new int[3];
		int sum;
		double avg = 0;

		for(int i = 0; i < korean.length ; i ++) {
			clearScreen();
			System.out.print("학생 " + (i+1) + "의 국어 점수를 입력해 주세요 : ");
			korean[i] = sc.nextInt();
			System.out.print("학생 " + (i+1) + "의 영어 점수를 입력해 주세요 : ");
			english[i] = sc.nextInt();
			System.out.print("학생 " + (i+1) + "의 수학 점수를 입력해 주세요 : ");
			math[i] = sc.nextInt();
			student[i][0] = korean[i];
			student[i][1] = english[i];
			student[i][2] = math[i];
		}
		clearScreen();
		for(int i = 0; i < korean.length ; i++) {
			sum = 0;
			for(int j = 0; j < korean.length ; j++) {
				sum += student[i][j];
			}
			avg = sum/korean.length;
			System.out.println("학생 " + (i+1) + "의 총점은 " + sum +", 이고 평균은 "+ avg + "입니다.");
		}
	}
	public static void clearScreen() {
		for (int powercleaner = 0; powercleaner < 80; powercleaner++)
			System.out.println("");
	}
}
