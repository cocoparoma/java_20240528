package day12;

public class FinalEx01 {

	public static void main(String[] args) {
		// final 한번만 할당 가능
		final int num;
		num = 10;
//		num =20; // 두번째 부터 할당 불가능

	}

}

class Parent1 {
	public final void print() {
		System.out.println("파이널 메소드 입니다.");
	}
}

//class Child1 extends Parent1 {
//	@Override
//	public final void print() {//파이날 메소드는 오버라이딩 할 수 없음
//		System.out.println("파이널 메소드를 수정하려 합니다.");
//	}
//
//}
final class Parent2 {

}

//class Child2 extends Parent2{
//	
//}
//파이닐 클래스는 부모클래스가 될 수 없다
//스트링도 파이날