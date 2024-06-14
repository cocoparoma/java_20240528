package day13;

public class ExceptionEx03 {

	public static void main(String[] args) {
		int su1 = 1;
		int su2 = 0;
		try {
			System.out.println(su1 % su2);
		} catch (Exception e) {
			System.out.println("예외 발생");
		}

		//

		try {
			System.out.println(su1 % su2);
		} catch (Exception e) {
			System.out.println("예외 발생");
		} finally {
			System.out.println("end");
		}
		System.out.println("--- --- --- --- ---");
		test1();
		System.out.println("--- --- --- --- ---");
		test2();

	}

	//

	public static void test1() {
		int su1 = 1;
		int su2 = 0;
		try {
			System.out.println(su1 % su2);
		} catch (Exception e) {
			System.out.println("예외 발생");
			return;
		} // try-catch done

		System.out.println("end");

	}// test1 done

	//

	public static void test2() {
		int su1 = 1;
		int su2 = 0;
		try {
			System.out.println(su1 % su2);
		} catch (Exception e) {
			System.out.println("예외 발생");
			return;
		} finally {
			// try-catch에서 실행문을 실행하고 메소드에서 return으로 빠져나가도 무조건 실행됨
			System.out.println("end");
		} // try-catch-finally done

	}

}
