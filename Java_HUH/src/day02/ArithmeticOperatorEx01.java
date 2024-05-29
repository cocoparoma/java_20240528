package day02;
public class ArithmeticOperatorEx01 {
	public static void main(String[] args) {
		int num1 = 5, num2 = 3;
		System.out.println("" + num1 + '+' +num2+'='+(num1+num2));
		System.out.println("" + num1 + '-' +num2+'='+(num1-num2));
		System.out.println("" + num1 + '*' +num2+'='+(num1*num2));
		System.out.println("" + num1 + '/' +num2+'='+(num1/num2)); // 형변환x
		System.out.println("" + num1 + '/' +num2+'='+(num1/(double)num2));//형변환o
		System.out.println("" + num1 + '%' +num2+'='+(num1%num2));
	
		
		
		
	}
}