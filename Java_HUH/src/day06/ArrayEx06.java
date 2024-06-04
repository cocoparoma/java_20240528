package day06;

import java.util.*;

public class ArrayEx06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arrscore = new int[4];
		boolean ox = true;
		int sum = 0;
		System.out.println("plz enter the 4 your score : ");
		for(int i = 0 ; i < arrscore.length ; i++) {
			System.out.print((i+1) + "score : ");
			arrscore[i] = sc.nextInt();
			sum  = sum + arrscore[i];
			if(arrscore[i]<40) {ox = false;}
		} 
		int avg = sum/arrscore.length;
		System.out.println(ox);
		System.out.println(avg);
		if(ox && 60 <= avg) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}

	}

}
