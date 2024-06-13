package day12;

public class InheritanceEx01 {

	public static void main(String[] args) {
		Child c = new Child();
				run(c);
	}

	//main 메소드에서 호출할 run 메소드 만드는데,
	// 누가 어떻게 구현할 지 모르는 상황
	public static void run(Parent parent) {
		if(parent != null) {
			parent.run();
		}
	}
}

//Parent 는 개발자들이 많이 쓰는 클래스라고 가정  = > 다른 패키지에 있다고 가정 코드가 어찌되는지 모름
//이 클래스에는 run 이라는 메소드가 있다고 가정
class Parent {

	public void run() {
		System.out.println("실행합니다.");
	}
}

class Child extends Parent{
	@Override
	public void run() {
		System.out.println("오버라이드 해서 실행합니다.");
	}	
}