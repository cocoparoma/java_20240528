package day06;

import java.util.Scanner;

public class ArrayEx04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[4];
		for(int i = 0; i < arr.length ;i ++ ) {
			System.out.println("plz int : arr[" + i + "]" + " = ");
			arr[arr.length - 1 - i] = sc.nextInt();
		}
		for(int tmp : arr) {
			System.out.print(tmp + " ");
		}
		
		int[] arr1 = new int[4];
		int tmp = 0;
		System.out.print("Enter the four number: ");
		int su = sc.nextInt();
		if(su < 1000 || 9999 < su) {
			System.out.println("wrong number");
		} else {
			tmp = su;
			int i = 0;
			while(tmp != 0){
				arr1[i++] =tmp % 10;
				tmp = tmp / 10;
			}
			for(int tmp2 : arr1) {
				System.out.print(tmp2 + "  ");
			}
		}
		
	}

}
