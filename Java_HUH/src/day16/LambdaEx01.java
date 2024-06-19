package day16;

public class LambdaEx01 {

	public static void main(String[] args) {
		A a1 = new A() {
			@Override
			public int sum(int su1, int su2) {
				return su1 + su2;
			}
		};

		A a2 = (n1, n2) -> {
			return n1 * n2;
		};

		A a3 = (n1, n2) -> n1 - n2; // 한줄이면 중괄호 생략이 가능, 중괄호 생략시 리턴도 생략 가능
		
		B b1 = n1 -> System.out.println(n1);//매개변수가 하나이면 괄호 생락도 가능 와우

		b1.print(110);
		b1.print(a2.sum(10, 30));
		
		
	}

}

interface A {
	int sum(int su1, int su2);
}

interface B {
	void print(int su1);
}
@FunctionalInterface
interface C{
	void test();
}



/**
 * 람다식 (매개변수둘) -> { 구현 }
 *
 * 1.추상 메서드가 1개인 인터페이스를 생성 2. main 메서드가 있는 클래스에서 1에서 생성한 인터페이스를 구현한 익명 클래스 객체 생성
 * 3. 2에서 생성한 객체를 이용해 기능 호출
 *
 *인터페이스에는 그런 기능 없음. 람다식이 만들었음
 */