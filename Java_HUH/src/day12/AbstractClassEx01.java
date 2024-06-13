package day12;

public class AbstractClassEx01 {

	public static void main(String[] args) {
		// 추상 클래스를 이용하여 객체를 생성할 수 없다.
		Cat cat = new Cat();
		cat.bark();
		Dog dog = new Dog();
		dog.bark();
		Tiger tiger = new Tiger();
		tiger.bark();

		Animal[] animals = new Animal[3];
		animals[0] = cat;
		animals[1] = dog;
		animals[2] = tiger;

		for (Animal tmp : animals) {
			tmp.bark();
		}

	}

}

abstract class Animal {
	public String name;
	public String species;

	public void sleep() {
		System.out.println("수면");
	}

	public void eat(String food) {
		System.out.println(food + "을 먹었다.");

	}

//back() 메소드는 Animal 클래스를 상속받는 모든 클래스들이 오버라이딩 해야 하기에
	// 굳이 구현 안해도 됨. 추상 매소드 화 >> 클래스도 추상 클래스로 바꿔주자
	public abstract void bark();
}

class Cat extends Animal {
	public Cat() {
		name = "고양이";
		species = "고양이과";
	}

	@Override
	public void bark() {
		System.out.println("야옹");
	}
}

class Dog extends Animal {
	public Dog() {
		name = "개";
		species = "개과";
	}

	@Override
	public void bark() {
		System.out.println("멍멍");
	}
}

class Tiger extends Animal {
	public Tiger() {
		name = "호랑이";
		species = "고양이과";
	}

	@Override
	public void bark() {
		System.out.println("어흥");
	}

}
//추상 클래스는 추상 메소드가 반드시 들어가는 것은 아니다.
abstract class test{
	
}