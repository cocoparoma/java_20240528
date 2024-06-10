package day09;

public class MethodOverLoadingEx02 {

	public static void main(String[] args) {
		System.out.println(sum(1,2,3));
		System.out.println(sum_d(1.2, 1.13));
	}
//	public static int sum(int a, int b) {
//		return a+b;
//	}
	public static double sum_d(double a, double b) {
		return a+b;
	}
	public static int sum(int a, int b, int c) {
		return a+b+c;
	}
//	public static int sum(int a, int b) {
//		return a+b;
//	}
}
