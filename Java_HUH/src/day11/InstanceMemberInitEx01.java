package day11;

public class InstanceMemberInitEx01 {

	public static void main(String[] args) {
		
		//객체 생성 전이라 블럭 까지만 초기화 됨
		System.out.println(B.Max);
		B b = new B();
		//객체 생성 후 초기화 됨
		System.out.println(B.Max);
		System.out.println(b.Max);
		System.out.println(b.num);

	}

}

class B {
	public int num = 10;
	public static int Max = 10;
	{
		num = 20;
	}
	static {
		Max = 20;
	}

	public B() {
		num = 30;
		Max = 30;
	}

}