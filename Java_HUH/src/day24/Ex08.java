package day24;

public class Ex08 {

	public static void main(String[] args) {
		/**
		 * 원인 : 생성자에 this. 안붙여서 해결방안 : this. 붙여주기
		 */

		Point p1 = new Point(10, 20);
		p1.print();
		/**
		 * 원인 : 해당하는 생성자가 없어서 해결방안 : 생성자 생성
		 */
		Point p2 = new Point();
		p2.print();

	}

}

class Point {
	private int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point() { // 생성자임 이게 필여했음 p2는
	}

	public void Point() { // 생성자가 아니라 메소드임

	}

	public void print() {
		System.out.println("(" + x + "," + y + ")");

	}

}
