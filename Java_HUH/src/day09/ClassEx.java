package day09;

public class ClassEx {// 추상화

	public static void main(String[] args) {

		Student1 std1 = new Student1();
		Student1 std2 = new Student1(1,1,1,"홍길동");
		std2.print();
		//멤버 변수와 메서드는 객체명, 멤버변수 또는 객체명.메소드명(매개변수들)을 이용하여 호출할 수 있다.
		//단, 접근제어자에 따라서 제한 될 수 있다.
		std1.name = "임꺽정";
		std1.print();
	}

}// class done
/*
 * 학생 성적을 관리하기 위해 학생 클래스를 추상화 하려고 한다. 학생 성적은 국어, 영어, 수학 성적만 관리한다. 클래스 이름은
 * Student1이고 이 때 필요한 멤버 변수를 선언해 보세요.
 * 
 */

class Student1 {
	String name;
	int grade, classNum, num, score[];
	public Student1() {
		
	}
	public Student1(int g, int c, int n, String name1){
		grade = g;
		classNum = c;
		num = n;
		name = name1;
	}
	public void Student1() {
		
	}
	public void print() {
		System.out.println(grade + "학년 " + classNum + "반 " + num + "번 " + name);
	}
	
	
	
	
	
	
}
