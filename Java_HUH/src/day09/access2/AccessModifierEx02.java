package day09.access2;

import day09.access.Student;

public class AccessModifierEx02 {

	public static void main(String[] args) {
		Student std1 = new Student();
		std1.grade = 10;
		//std1.classNum = 1;
		//std1.num = 10;
		//std1.name = "홍길동"; //접근 제어자가 private라서 다른클래스 사용 불가
	}

}
