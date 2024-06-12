package day11;

public class ClassCastingEx01 {

	public static void main(String[] args) {
		Circle c1 = new Circle(10, 10, 10);
		Rect r1 = new Rect(0, 10, 10, 10);
		Circle c2 = new Circle(10, 10, 5);

		Shape[] shapes = new Shape[20];

		// 업캐스팅이 일어나서 클래스 형변환이 일어난다!!!
		shapes[0] = c1;
		shapes[1] = r1;
		shapes[2] = c2;

		for (Shape tmp : shapes) {
			// 원이면 원을 그리고 사각형이면 사각형을 그리는 예제

			if (tmp == null) {
				continue;
			}
			if (tmp instanceof Circle) {
				Circle circle = (Circle) tmp;// 다운 캐스팅. 반드시 명시해 주어야 하며 업 캐스팅 된 객체를 다운 캐스팅 할 때만 사용이 가능하다
				circle.drawCircle();
				((Circle) tmp).drawCircle();// 위 두줄을 합침

			} else if (tmp instanceof Rect) {
				Rect rect = (Rect) tmp;
				rect.drawRect();
				((Rect) tmp).drawRect();// 위 두줄을 합침

			}
		}
	}
}

class Shape {
	String name = "도형";

	public Shape(String name) {
		this.name = name;
	}

	void print() {
		System.out.println(name + " 입니다.");
	}

}

class Rect extends Shape {
	int x, y;
	int width, height;

	public Rect(int x, int y, int width, int height) {
		super("사각형");
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	@Override
	public void print() {
		super.print();
		System.out.println("왼쪽 아래 점 : " + x + ", " + y);
		System.out.println("너비 : " + width);
		System.out.println("높이 : " + height);
	}

	public void drawRect() {
		System.out.println("사각형을 그립니다.");
	}
}

class Circle extends Shape {
	int x, y;
	int radius;

	public Circle(int x, int y, int radius) {
		super("원");
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	@Override
	public void print() {
		super.print();
		System.out.println("중심점 : " + x + ", " + y);
		System.out.println("반지름 : " + radius);
	}

	public void drawCircle() {
		System.out.println("원을 그립니다.");
	}
}