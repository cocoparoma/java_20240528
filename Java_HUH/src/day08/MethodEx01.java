package day08;

import java.util.*;

public class MethodEx01 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("정수를 입력하시오 : ");
		boolean prN =PrimeNumber(sc.nextInt());
		System.out.println(prN);
		System.out.print("정수를 입력하시오 : ");
		for(int i = 1; i <= 100  ; i++) {
			if (PrimeNumber(i)) {
				System.out.print(i+"  ");
			}
		}
	}	//main









	static boolean PrimeNumber2(int a) {
		int count = 0 ;//?
		return true;
	}









	static boolean PrimeNumber(int a) { //프리미어넘버 메소드 int > boolean
		int count = 0; boolean ox = false;
		for (int i = 1; i <= a; i++){
			if(a % i == 0) {
				count ++;
			}
			if(count > 2) {
				break;
			}
		}
		if(count==2 ) {
			ox = true;
		} else {
		}
		return ox;
	}


}
