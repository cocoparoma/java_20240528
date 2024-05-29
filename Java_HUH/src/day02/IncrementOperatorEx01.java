package day02;

public class IncrementOperatorEx01 {

	public static void main(String[] args) {
		int num1 = 10, num2 = 10;
		++num1;
		num2++;
		System.out.println("num1 : " + num1 );
		System.out.println("num2 : " + num2 );
		
		System.out.println("++num1 : " + ++num1 ); //전위형
		System.out.println("num2++ : " + num2++); //후위형
		
		System.out.println("final num1 : " + num1 );
		System.out.println("final num2 : " + num2);
	}

}
