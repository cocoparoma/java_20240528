package day5;

import java.util.Scanner;

public class ArrayEx04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		for(int i = 0 ; i <arr.length ; i++) {
			System.out.print((i+1) + "번 정수를 입력해 주세요 : ");
			arr[i] = sc.nextInt();
		}
		
//		for(int i = 0 ;i <arr.length ; i++) {
//			System.out.print(arr[arr.length-1-i]+ "  ");
//		}
		for(int i = arr.length-1 ;i >=0 ; i--) {
			System.out.print(arr[i]+ "  ");
		}
		
		
	}

}
