package day15;

import java.util.ArrayList;
import java.util.Objects;

public class ListEx03 {

	public static void main(String[] args) {
		/**
		 * 연락처 클래스를 이용한 List 예제 indexOf, remove, contains 을 확인하는 예제
		 */
		ArrayList<Contact> list = new ArrayList<Contact>();
		Contact c1 = new Contact("홍길동", "010-4455-1234");
		Contact c2 = new Contact("홍길동", "010-4455-1234");

		list.add(c1);

		System.out.println(list);

		list.remove(c2);

		System.out.println(list);
		/**
		 * Objects.equals(객체1, 객체2)를 호출 1. 객체 1과 객체 2가 같은 클래스인가? 확인 2. 객체1.equals(객체2)
		 * << 주소를 비교했는데 같지 않기에 삭제 x
		 */
		list.add(c1);

		System.out.println(list);

		c1.nameString = "고길동";

		System.out.println(list);
		/**
		 * 복사 생성자를 이용하여 객체를 리스트에 저장하고 객체를 밖에서 수정해도 리스트는 영향이 없게 하는 것이 좋다.
		 */

		list.add(new Contact(c2));

		System.out.println(list);

		c2.nameString = "나길동";

		System.out.println(list);

	}

}// class done

class done {

}// class done

class Contact {

	String nameString, numberString;

	public Contact(String nameString, String numberString) {
		this.nameString = nameString;
		this.numberString = numberString;
	}

	public Contact(Contact c) {
		this.nameString = c.nameString;
		this.numberString = c.numberString;
	}

	@Override
	public String toString() {
		return "name : " + nameString + ", number " + numberString;
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
		Contact other = (Contact) obj;
		return Objects.equals(numberString, other.numberString);
	}

}// class done