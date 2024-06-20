package day17;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Data;

public class StreamEx01 {

	public static void main(String[] args) {
		List<Person> list = Arrays.asList(new Person("홍길동", 21, "남"), new Person("임꺽정", 40, "남"),
				new Person("유관순", 18, "여"), new Person("황짆이", 20, "여"));

		// filter(p) : 조건을 만족하는 요소들만 선택
		// forEach(c) : 요소를 하나씩 꺼내 처리

		Stream<Person> stream = list.stream();
		stream.filter(p -> p.getAge() >= 20).filter(p -> p.getGender().equals("여")).forEach(p -> System.out.println(p));

		// map(f<T,R> F) : T를 가공해서 R 로 변환시킴 Person 객체에서 이름(String)을 가져와서 변환
		stream = list.stream();
		stream.map((p) -> p.getName()).forEach(name -> System.out.println(name));

		stream = list.stream();
		long count = stream.filter(p -> p.getGender().equals("여")).count();
		System.out.println("여성의 수 : " + count);

		stream = list.stream();
		count = stream.filter(p -> p.getAge() >= 20).count();
		System.out.println("성인의 수 : " + count);

		stream = list.stream();
		// map이 T를 가공해서 R로 만듦. mapToInt는 T를 가공해서 Integer로 만듦
		// mapToInt는 OptionalDouble로 변환 하는데 이유는 객체가 없어서 평균을 구할 수 없으면
		// 객체를 통해 알 수 있는 메소드를 제공하기 때문에 사용
		OptionalDouble ageAverage = stream.mapToInt(Person::getAge).average();// p->p.getAge()

		if (ageAverage.isPresent()) {
			System.out.println("평균 나이 : " + ageAverage.getAsDouble());
		} else {
			System.out.println("일치하는 사람이 없습니다.");
		}

		stream = list.stream();
		List<Person> list2 = stream.filter(p -> p.getAge() <= 20).collect(Collectors.toList());
		System.out.println(list2);
	}

}

@Data
@AllArgsConstructor
class Person {
	private String name;
	private int age;
	private String gender;
}

class AAA{
	public static InputStream in = new InputStream() {
		
		@Override
		public int read() throws IOException {
			// TODO Auto-generated method stub
			return 0;
		}
	};
	
}
