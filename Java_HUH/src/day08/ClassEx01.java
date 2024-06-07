package day08;

public class ClassEx01 {

	public static void main(String[] args) {
		int su1 = 10; int su2 = 30; int sum = 0;
		sum = Add(su1, su2);
		OutPut(su1, su2);
		System.out.println(sum);
		
	}
	
	public static int Add(int a, int b) {
		return a+b;
	}
	public static void OutPut(int a, int b) {
		System.out.println(a+b);
	}
	
}

//(대)학생 클래스 선언
class Student1{
	//이름, 학번, 학년. 사는곳, 전공
	String name, num, address, major;
	int semester;




}