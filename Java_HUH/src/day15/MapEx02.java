package day15;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapEx02 {

	public static void main(String[] args) {
		// 해시 멤을 이용한 반복문 예제
		HashMap<String, String> map = new HashMap<String, String>();

		map.put("2000160001", "고길동");
		map.put("2000160002", "홍길동");
		map.put("2000160013", "임꺽정");

		// 방법 1. keysSet 이용
		// Set<String> set = map.keySet(); 키로 바꾸든가 아니면 헤쉬셋으로 옛날버전임 으로 바꾸셈
		// HashSet<String> setHashMap = (HashSet)map.keySet();

		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String keyString = it.next();
			String valueString = map.get(keyString);
			System.out.println(keyString + " : " + valueString);
		}

		// 방법 2. EntrySet을 이용 .Enter 클래스를 이용하여 set으로 만들고, 반복문을 활용
		Set<Map.Entry<String, String>> entrySet = map.entrySet();

		Iterator<Entry<String, String>> it2 = entrySet.iterator();
		while (it2.hasNext()) {
			Map.Entry<String, String> tmp = it2.next();
			String key = tmp.getKey();
			String value = tmp.getValue();
			System.out.println(key + " : " + value);
		}

	}

}
