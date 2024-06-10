package day09;

public class VriableArgumentEx01 {

	public static void main(String[] args) {
		// 가변 매개변수를 이용하여 정수들의 합을 구하는 메서드 예제
		System.out.println(sum1());
		System.out.println(sum1(1));
		System.out.println(sum1(1,2));
		System.out.println(sum1(1,2,3));
		System.out.println(sum1(1,2,3,4));
		System.out.println(sum1(1,2,3,4,5));
		
		System.out.println(sum2(new int[0]));
		System.out.println(sum2(new int[] {1}));
		System.out.println(sum2(new int[] {1,2}));
		System.out.println(sum2(new int[] {1,2,3}));
		System.out.println(sum2(new int[] {1,2,3,4}));
		System.out.println(sum2(new int[] {1,2,3,4,5}));
		

		
	}// main done

	public static int sum1(int... as) {
		if (as == null) {
			return 0;
		}
		int sum = 0;
		for(int tmp : as) {
			sum += tmp;
		}
		return sum;
	}// sum1 done

	public static int sum2(int[] as) {
		if (as == null) {
			return 0;
		}
		int sum = 0;
		for(int tmp : as) {
			sum += tmp;
		}
		return sum;
	}// sum2 done
}// class done
