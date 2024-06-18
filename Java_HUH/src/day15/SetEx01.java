package day15;

import java.util.ArrayList;
import java.util.HashSet;

public class SetEx01 {

	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<Integer>();
		
		System.out.println(set.add(1));
		System.out.println(set.add(1));//중복될시 false 출력
		System.out.println(set.add(100));
		System.out.println(set.add(1000));
		
		System.out.println(set.remove(20));//false
		System.out.println(set.remove(100));//true
		
		System.out.println(set.contains(11));
		System.out.println(set.contains(1));
		
		System.out.println(set.size()); //크기
		System.out.println(set);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		//addAll = 컬렉션에 있는 모든 값 추가, 컬렉션
		list.addAll(set);
		list.add(8);
		list.add(9);
		list.add(10);

		//Collections.shuffle(리스트) 렌덤으로 섞어줌
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
