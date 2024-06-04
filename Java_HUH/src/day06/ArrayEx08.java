package day06;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str  = new String[5];
		int i = 0;
		do {
			System.out.print("plz enter the " + (i+1) +" word : "); 
			str[i] = sc.next();
			i++;
		}while(i != str.length);
		
		for(int n = 0; n < str.length; n ++) {
			System.out.println(str[n]);	
		}
		
		for(String tmp : str) {
			System.out.println(tmp);
		}
		
		System.out.println(Arrays.toString(str));
	}

}
