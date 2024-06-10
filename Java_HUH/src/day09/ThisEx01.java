package day09;

public class ThisEx01 {

	public static void main(String[] args) {
		Student3 학생1 = new Student3();
		Student3 학생2 = new Student3(1, 2, 2, "둘리");
		System.out.println(학생1.schoolName);
		System.out.println(학생2.schoolName);

		학생1.schoolName = "KH 중학교";

		System.out.println(학생1.schoolName);
		System.out.println(학생2.schoolName);

		System.out.println(Student3.schoolName);
		System.out.println(Math.PI);// Math에서 제공하는 static 값
	}

}

class Student3 {
	private int grade, classNum, num;
	private String name;
	public static String schoolName = "kH고등학교"; // static : 고정형

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getClassNum() {
		return classNum;
	}

	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student3(int grade, int classNum, int num, String name) {
		super();
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
	}

	public Student3() {
		this(1, 1, 1, "홍길동");// this()생성자는 첫번째 줄에 무조건 있어야해요! 아니면 err가 난답니다ㅣ?
	}

}