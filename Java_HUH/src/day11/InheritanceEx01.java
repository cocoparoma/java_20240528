package day11; //상속 예제

public class InheritanceEx01 {

	public static void main(String[] args) {
		HighScoolStudent std = new HighScoolStudent();
		std.print();
		std.setAge(10);
		std.setName("김종국");
		std.print();
		std.test();
	}// main done

}// class done



//class A{
//	Student s1 = new Student();
//	
//	public void print() {
//			s1.name = "홍길동";
//			
//	}
//}
