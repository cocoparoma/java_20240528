package day24;

import lombok.Data;

public class Ex10 {

	public static void main(String[] args) {
		PointB pB1 = new PointB();
		pB1.setX(100);
		pB1.print(10.5, 20.5);
		/**
		 * int에 왜 더블을 넣으려 하는지 모르겠음
		 * 새로운 생성자를 만든다 더블더블로
		 */
		
		
		
		
		PointB pB2 = new PointB();
	}

}



/**
 * 원인 : 메소드 이름 중복
 * 해결방안 : 컴퓨터는 구별하기 힘들다고 외친다 이름을 바꿔주자
 */




@Data
class PointB {
	private int x, y;

	public void print() {
		System.out.println("(" + x + "," + y + ")");
	}

	public void print(int x, int y) {
		System.out.println("(" + x + "," + y + ")");
	}
	public void print(Double x, Double y) {
		System.out.println("(" + x + "," + y + ")");
	}
	public int print_To_return_Int() {
		System.out.println("(" + x + "," + y + ")");
		return x+y;
	}

}