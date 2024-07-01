package day24;

import java.util.ArrayList;
import java.util.List;

public class Ex14 {
	public static void main(String[] args) {
		// 혹은 오브젝트로 만들어주던가
		List<PointD> list = new ArrayList<PointD>();
		list.add(new PointD(1, 1));
		list.add(new PointD(1, 10));

		// new 써서 새로운 객체를 만들어주자
		list.add(new PointD(1, 1));
		list.add(new PointD(1, 0));
		list.add(new PointD(1, 1));

	}
}

class PointD {
	int x, y;

	public PointD(int x, int y) {
		this.x = x;
		this.y = y;

	}

}