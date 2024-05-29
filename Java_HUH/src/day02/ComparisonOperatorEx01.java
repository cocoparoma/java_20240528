package day02;

public class ComparisonOperatorEx01 {

	public static void main(String[] args) {
		//비교연산자 에제
		int num1 = 10 , num2 = 20;
		System.out.println("" + num1 + '<' +num2 +" : " + (num1 < num2));
		System.out.println("" + num1 + '>' +num2 +" : " + (num1 > num2));
		System.out.println("" + num1 + "<=" +num2 +" : " + (num1 <= num2));
		System.out.println("" + num1 + ">=" +num2 +" : " + (num1 >= num2));
		System.out.println("" + num1 + "==" +num2 +" : " + (num1 == num2));
		System.out.println("" + num1 + "!=" +num2 +" : " + (num1 != num2));
		
		String str1 = "abc", str2 = "abc", str3 = new String("abc");
		System.out.println("str1 == str2 : "+ (str1 == str2));
		System.out.println("str1 == str3 : "+ (str1 == str3));
		System.out.println("str2 == str3 : "+ (str2 == str3));
		
		System.out.println("str1 == str2 : "+ (str1.equals(str2)));
		System.out.println("str1 == str3 : "+ (str1.equals(str3)));
		System.out.println("str2 == str3 : "+ (str2.equals(str3)));

}
	
}
