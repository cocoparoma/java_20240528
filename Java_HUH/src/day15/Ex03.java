package day15;

import java.util.ArrayList;
import java.util.Collections;

public class Ex03 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= 45; i++) {
			list.add(i);
		}

		Collections.shuffle(list);
		for (int i = 0; i < 7 ;  i++) {
			System.out.print(list.get(i) + "   ");
		}

	}

}
