package day11;

public class SingleTonEx01 {

	public static void main(String[] args) {
		SingleTon s1 = SingleTon.getInstance();
		s1.message();

		SingleTon s2 = SingleTon.getInstance();
		s2.message();

		// 하나의 객체를 s1, s2가 공유중
		System.out.println(s1);
		System.out.println(s2);

		A a1 = new A();
		A a2 = new A();

		//일반 클래스는 각자 다른 객체를 생성
		System.out.println(a1);
		System.out.println(a2);
		//참조변수의 공유 즉 같은 객체(메모리주소)를 공유
		a1 = a2;
		System.out.println(a1);
		System.out.println(a2);

	}

}

class A {

}

class SingleTon {
	private static SingleTon instance = new SingleTon();

	private SingleTon() {

	}

	public static SingleTon getInstance() {
		return instance;
	}

	public void message() {
		System.out.println("싱글톤 입니다.");
	}

}