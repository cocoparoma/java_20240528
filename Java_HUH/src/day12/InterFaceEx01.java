package day12;

public class InterFaceEx01 {

	public static void main(String[] args) {
		Dog1 dog = new Dog1();
		dog.bark();
		dog.sleep();
		// 인터페이스는 직접 객체를 만들 수 없고 구현 클래스를 이용하여 객체를 만들수 있다(다형성 포함)
		AnimalAction a = new Dog1();
		a.bark();
		System.out.println(AnimalAction.num1);
		System.out.println(AnimalAction.num2);
		AnimalAction.print();
	}

}

interface AnimalAction {
	public static final int num1 = 10;
	int num2 = 120;

	public abstract void bark();

	// 디폴트 메소드는 오버라이딩 하지 않아도 됨
	default void sleep() { 
		System.out.println("잠을 잡니다.");
	}

	void eat(String food);// public abstract 가 자동으로 붙음

	public static void print() {
		System.out.println("동물이 움직입니다.");
	}
}

abstract class Animal2 implements AnimalAction {
	String name;

}

class Dog1 extends Animal2 {
	@Override
	public void bark() {
		System.out.println("멍멍");
	}

	@Override
	public void eat(String food) {
		System.out.println(food + "을 먹었다.");
	}

	@Override
	public void sleep() {
		System.out.println("수면");
	}
}