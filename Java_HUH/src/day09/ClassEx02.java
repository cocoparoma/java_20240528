package day09;

public class ClassEx02 {

	public static void main(String[] args) {
		Student2 std = new Student2();
		std.setGrade(1);
		System.out.println(std.getGrade() + "학년");
		std.setGrade(3);
		System.out.println(std.getGrade() + "학년");
		}

}
class Student2{
	private int grade, classNum, num;
	private String name;
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int a) {
		grade = a;
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
}