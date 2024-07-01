package day24;

import lombok.Data;

public class Ex13 {

	public static void main(String[] args) {
		
		
		/**
		 * 널값이 나옴
		 * 즉 초기화가 안되었네용?
		 */
		
		PointC [] pts = new PointC[3];

		
		
		
		for (int i = 0; i < pts.length; i++) {
			pts[i]= new PointC(0, 0); 
			 pts[i].setX(i+1);
			 pts[i].setY(i+1);
			 pts[i].print();
			
		}
		
		

	}

}
@Data
class PointC {
	private int x, y;

	public PointC(int x, int y) {
		this.x = x;
		this.y = y;

	}
	
	
	public void print() {
		System.out.println("(" + x + "," + y + ")");
	}

}