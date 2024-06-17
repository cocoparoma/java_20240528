package day14;

public class EqualsEx01 {
	public static void main(String[] args) {

		Number a = new Number("abc");

		boolean ox = "abdc".equals(a.Num);

		System.out.println(ox);

		ox = "abc".equals(a.Num);

		System.out.println(ox);

	}

}

class Number {
	String Num;

	public Number(String num) {
		Num = num;
	}

}