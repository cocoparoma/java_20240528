package day08;

public class MethodEx03 {

	public static void main(String[] args) {

		int a = 1, b = 2;
		int num1 = 1, num2 = 2;

		System.out.println(Add(a, b));
		System.out.println(Add(num1, num2));
		System.out.println(Add(1, 2));

		System.out.println(" a : " + a + " b: " + b);
		swap(a, b); // 리턴이 없음 실제로 바뀌지는 아니함
		System.out.println(" a : " + a + " b: " + b);

	}// main done

	static int Add(int a, int b) {
		return a + b;
	}// Add done

	static void swap(int a, int b) {
		int tmp = a;
		a = b;
		b = tmp;
	}

	static void test(int a, int b) {
		a = 10;
		System.out.println(a + b);
	}

}// class done
