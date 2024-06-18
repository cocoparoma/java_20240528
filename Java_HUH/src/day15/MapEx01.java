package day15;

import java.util.HashMap;

public class MapEx01 {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("admin", "admin123");
		System.out.println(map.put("admin", "admin0000000"));// HashMap기능 중 put 은 기존값을 리턴해주고 새로운 값으로 덮어쓰기됨
		System.out.println(map);// 덮어쓴 val값이 나옴

		String tmpString = map.remove("admin");// remove(key) : 주어진 키 값과 일치하는키가 있으면 삭제하고 value를 반환함
		System.out.println(tmpString);

		System.out.println(map);

		map.put("abc123", "def123");
		map.put("qweqwe", "def123");

		System.out.println(map);

		// containsKey(key) : 주어진 키와 같은 값이 있는지 없는지 반환
		System.out.println(map.containsKey("admin"));
		System.out.println(map.containsKey("qweqwe"));

	}

}
