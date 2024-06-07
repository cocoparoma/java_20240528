package day08;

import java.util.*;

public class MethodEx02 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("실수1 입력 : ");
		int su1 = sc.nextInt();
		System.out.print("실수2 입력 : ");
		int su2 = sc.nextInt();
		if (su1 < su2) {
			int tmp = su1;
			su1 = su2;
			su2 = tmp;
		} // if done
		int result = greatest_common_divisor(su1, su2);
		System.out.println("최대 공약수 : " + result);// 같은수로 나눌수 있는 가장 큰 수
		result = least_common_multiple(su1, su2);
		System.out.println("최소 공배수 : " + result);// 주어진 값으로 공동으로 나눌 수 있는 가장 작은 수
	}// main

	static int greatest_common_divisor(int a, int b) {// new! : 유클리드 호제법
		if (a % b == 0) {
			return b;
		}
		return greatest_common_divisor(a, a % b);
	}// greatest_common_divisor done

	static int least_common_multiple(int a, int b) {// new! : 유클리드 호제법
		return (a * b) / greatest_common_divisor(a, b);
	}// least_common_multiple done

	// su2 가 su1의 배수인지 아닌지 확인하는 메서드
	static boolean measure(int a, int b) {
		return a % b == 0;
	}

	// 최대 공약수
	static int gcd(int a, int b) {
		for (int i = b; i > 1; i--) {
			if (a % i == 0 && b % i == 0) {
				return i;
			}
		}
		return 1;
	}
	// 최소 공배수
	static long lcm(long a, long b) {
		for(long i = a; i<a*b ; i +=a) {
			
		}
		return 0;
	}

}// class










