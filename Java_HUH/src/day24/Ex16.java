package day24;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ex16 {

	public static void main(String[] args) {
		/**
		 * 1. 이름과 나이를 저장하고 관리하는 클래스르 생성하세요 2. 이름이 홍길동, 나이는 21인 객체 생성 3.
		 * src/day24/ex16.txt에 저장
		 */
		List<Member> list = new ArrayList<Member>();
		String file = "src/day24/ex16.txt";
		Member m1 = new Member("홍길동", 24);
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(m1);
		} catch (Exception e) {
		}

		Member m2 = new Member();
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			m2 = (Member) ois.readObject();
			/**
			 * (~~~)를 추가하는 이유 : 읽어온 정보가 어떠한 내용으로 작성되었는지 컴퓨터는 모른다. 그래서 읽어온 오브젝트가 이러한 형식으로
			 * 되어있다고 형 변환을 일으켜 주는 내용이다
			 */
		} catch (Exception e) {
		}

		System.out.println(m2);

	}
}

class Member implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1174888750642524031L;

	String name;
	int age;

	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Member() {

	}

	@Override
	public String toString() {
		return "이름 : " + name + ", 나이 : " + age;
	}

}