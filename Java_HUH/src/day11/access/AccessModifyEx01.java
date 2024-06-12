package day11.access;

import day11.Student;

public class AccessModifyEx01 {

	public static void main(String[] args) {
		A a = new A();
		a.print();
	}

}

class A {
	Student std = new Student();

	public void print() {
		std.birthday = "2000Y01M01D";
		System.out.println(std.birthday);
		
	}
}

