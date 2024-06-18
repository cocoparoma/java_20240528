package day15;

import java.util.ArrayList;

public class ListEx01 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		
		//add(객체) : 객체를 리스트에 추가, 컬렉션 인터페이스에서 구현
		//add(번지, 객체) : 번지에 객체를 추가, 리스트 인터페이스에서 구현
		list.add("안녕하세요");
		list.add("Hello");
		list.add(0, "Hi");//기존의 것을 뒤로 미룸
		System.out.println(list);
		
		//remove(객체) : 리스트에서 주어진 객체를 제거, 컬렉션 인터페이스에서 구현
		//remove(번지) : 리스트에서 번지 위치에 있는 객체를 삭제하고 삭제된 객체를 반환, 리스트 인터페이스
		System.out.println(list.remove("H")); // false
		System.out.println(list.remove("Hi")); // true
		System.out.println(list.remove(0));//안녕하세요 반환
		
		list.add("홍길동");
		
		//get(번지) : 번지 위에 있는 객체를 가져옴. 리스트 인터페이스
		System.out.println(list.get(1));
		//clear(); : 리스트를 비워 준다. 컬렉션 인터페이스
//		list.clear();
//		System.out.println(list);
		
		//contains(객체) : 리스트에 객체가 있는지 없는지 알려ㅓ줌, 컬렉션
		System.out.println("리스트에 Hi가 있습니까? : " + list.contains("Hi"));
		System.out.println("리스트에 홍길동이 있습니까? : " + list.contains("홍길동"));
		
		//indexOf(객체) : 리스트에 객체가 몇번지에 있는지 알려줌. 리스트
		System.out.println("리스트에 Hi가 몇번지에 있습니까? : " + list.indexOf("HI"));//-1 없어서
		System.out.println("리스트에 홍길동이 몇번지에 있습니까? : " + list.indexOf("홍길동"));//+1 있어서
		System.out.println(list);
		
		
	}

}
