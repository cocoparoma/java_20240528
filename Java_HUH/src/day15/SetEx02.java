package day15;

import java.util.HashSet;
import java.util.Iterator;

public class SetEx02 {

	public static void main(String[] args) {
		//향상된 for 문을 이용, set 값 가져오기
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(9);
		set.add(4);
		set.add(3);
		set.add(2);
		
		for (Integer tmp : set) {
			System.out.println(tmp);
		}
		
		System.out.println();
		Iterator<Integer> it = set.iterator();
		
		while (it.hasNext()) {
			Integer num = it.next();
			System.out.println(num + "  ");
			
		}
		
		
		
	}

}
