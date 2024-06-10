package day09;

public class StaticEx01 {

	public static void main(String[] args) {
		Student4 std1 = new Student4(1, 1, 1, "홍길동");
		Student4 std2 = new Student4(1, 2, 2, "임꺽정");

		std1.print();
		std2.print();

		Student4.printschoolName();
	}

}

class Student4 {
	public int grade, classNum, num;
	public String name;

	public static String schoolName = "kh고등학교";

	public void print() {
		System.out.println(grade + "학년" + classNum + "반 " + num + "번 " + name);
	}

	public static void printschoolName() {
		System.out.println(schoolName);
	}

	public Student4(int grade, int classNum, int num, String name) {
		super();
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
	}

	// 클래스 메소드
	public static void test1() {
		// 클래스 메소드에서 클래세 변수를 호출할 수 있다 (o) => printschoolName
		System.out.println("학교명 : " + schoolName);
		// 클래스 메소드에서 객체 변수를 호출 할 수 있다(x) =>객체를 생성한 후 호출 가능함
		Student4 std = new Student4(1, 1, 1, "둘리"); // 아래의 에러를 해결하려면 이런 줄이 필요한데 매우 비효율적
		// System.out.println("학년 : " + grade); //err
		// 클래스 메소드에서 클래스 메소드를 호출 할 수 있다(o)
		printschoolName();
		// 클래스 메소드에서 객체 메소드를 호출 할 수 있다.(x) =>객체를 생성한 후 호출 가능함
		// print();
		std.print();//Student4 std = new Student4(1, 1, 1, "둘리");로 만들어서 가능.
	}

	// 객체 메소드
	public void test2() {
		// 객체 메소드에서 클래세 변수를 호출할 수 있다 (o) => printschoolName
		System.out.println("학교명 : " + schoolName);
		// 객체 메소드에서 객체 변수를 호출 할 수 있다(o)
		System.out.println("학년 : " + grade);// ok
		// 객체 메소드에서 클래스 메소드를 호출 할 수 있다(o)
		printschoolName();
		// 객체 메소드에서 객체 메소드를 호출 할 수 있다.(o) 
		print();
		
		// 결론 클래스 메소드가 만들어진 후 객체 메소드가 만들어진다 순서를 잘 생각해서 코드를 짜보자
	}

}