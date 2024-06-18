package day15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class ListSortEx01 {

	public static void main(String[] args) {
		// List를 이용하여 정렬하는 방법
		List<String> list = new ArrayList<String>();

		list.add("홍길동");
		list.add("고길동");
		list.add("둘리");

		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);

		/**
		 * Collections.sort(리스트, Comparator 객체) -Comparator객체 : Comparator인터페이스를 구현한 구현
		 * 글래스의 객체가 필요 그런데 아래 코드에서 String 클래스는 라이브러리에서 제공하는 클래스이기 때문에 우리가 수정할 수 없다. 그래서
		 * 익명 클래스(이름이 없는 1회용 클래스)를 만들어서 해당 클래스의 객체를 이용한다. Comparator 인터페이스의 Compare 추상
		 * 메소드를 오버라이딩 해야하고 오버라이딩 한 코드에 따라서 정렬 방식이 바뀐다.
		 */

		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return -o1.compareTo(o2);
			}
		});// Collections done
		
		System.out.println(list);
		List<Student> stds = new ArrayList<Student>();
		
		stds.add(new Student("2024160002", "고길동"));
		stds.add(new Student("2024160001", "홍길동"));
		stds.add(new Student("2024135001", "둘리"));
		
		System.out.println(stds);
		
		Collections.sort(stds, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				
				return o1.numberString.compareTo(o2.nameString);
			}
		});
		
		//다음 쳅터 람다식 적용해봄
//		Collections.sort(stds, (o1, o2)-> o1.numberString.compareTo(o2.nameString))  {
//			
//		};

	}

}

class Student {
	String numberString, nameString;// 학번, 이름

	public Student(String numberString, String nameString) {
		this.numberString = numberString;
		this.nameString = nameString;
	}

	@Override
	public String toString() {
		return "학번 : " + numberString + ", 이름 : " + nameString;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numberString);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(numberString, other.numberString);
	}

}