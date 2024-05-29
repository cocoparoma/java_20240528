package day02;
public class AssignmentOperatorEx01 {
	public static void main(String[] args) {
//		복합 대입 연산자 예제
		int n1 = 10, n2 = 20;
		n1 = n1 + n2;
		System.out.println(n1);
		int n3 = 10, n4 = 20;
		n3 += n4; // << 복합대입연산자 : +=, -=, *=, /=, %=, &=, |=, ^=, >>=, <<=, >>>=
		System.out.println(n3);
	}

}
