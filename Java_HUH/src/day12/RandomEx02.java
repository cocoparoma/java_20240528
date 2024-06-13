package day12;

import java.util.Random;
import java.util.Scanner;

public class RandomEx02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random ra = new Random();

		System.out.print("Max : ");
		int Max = sc.nextInt();
		System.out.print("Min : ");
		int Min = sc.nextInt();

		if (Min > Max) {
			int tmp = Max;
			Max = Min;
			Min = tmp;
		}

		System.out.print("Repetitions :");
		int reps = sc.nextInt();

		if (reps < 0) {
			reps = Math.abs(reps);
		}

		// take 1 (use Math.Random)
		for (int i = 0; i < reps; i++) {
			int r = (int) (Math.random() * (Max - Min + 1) + Min);
			System.out.print(r + "  " + ((i % 10 == 9) ? "\n" : ""));
		}
		System.out.println(" === === === === === ");

		// take 2 (use Random ra.nextInt())
		for (int i = 0; i < reps; i++) {
			int num = ra.nextInt(Max - Min + 1) + Min;
			System.out.print(num + "  " + ((i % 10 == 9) ? "\n" : ""));
		}

		System.out.println(" === === === === === ");

		// take 3 (use Random ra.nextInt()) //재일 간단하고 보기 좋아보이긴 함
		for (int i = 0; i < reps; i++) {
			int num = ra.nextInt(Min, Max+1); // <<<<<<<< 
			System.out.print(num + "  " + ((i % 10 == 9) ? "\n" : ""));
		}

	}

}
