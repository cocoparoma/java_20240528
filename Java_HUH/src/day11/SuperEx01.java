package day11;

public class SuperEx01 {

	public static void main(String[] args) {
		Child1 c = new Child1(10,20);
		c.printChild();
	}

}

class Parent1 {
	int num = 1;

	public void print() {
		System.out.println("num : " + num);

	}
	public Parent1(int num) {//Child1생성자가 이걸 생성
		this.num = num;
	}
//	public Parent1() {//기본생성자
//		
//	}


}

class Child1 extends Parent1 {
	int num2 = 2;

	public void printChild() {

		super.print();
		System.out.println("num2 : " + num2);

	}
//	public Child1() { >> public Parent1(int num)생성
//		super(0);
//	}
	public Child1 (int a, int b) {
		super(a);
		this.num2 = b;
	}
}