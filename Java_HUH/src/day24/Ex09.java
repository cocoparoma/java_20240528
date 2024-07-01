package day24;

public class Ex09 {

	public static void main(String[] args) {
		PointA p1 = new PointA(10,20	);
		p1.print();
		/**
		 * 원인 : 필드변수에 접근이 안됨
		 * 해결 방안 : 상남자 답게 퍼블릭으로 바꾼다, 하남자 답게 겟셋을만든다
		 */
		p1.x = 100;
		p1.y = 200;

		p1.print();

		/**
		 * 원인 : 기본생성자가 없다
		 * 해결방안 : 상남자 답게 만들어준다.
		 */

		PointA p2 = new PointA();
		p2.print();

	}

}

class PointA {
//	private int x, y; //하남자 코드
	public int x, y;//상남자 코드

	public PointA(int x, int y) {
		this.x = x;
		this.y = y;

	}

	public PointA() {
	}

	public void print() {
		System.out.println("(" + x + "," + y + ")");
	}

}