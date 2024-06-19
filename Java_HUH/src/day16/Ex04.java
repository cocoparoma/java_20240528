package day16;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

public class Ex04 {
//하나의 메소드로 여러가지 식을 뽑아 낼 수 있다.
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		AB a = (n1, n2, n3) -> n1 + n2 + n3;
		list.add(new Student(1, 1, 2, "고길동", 100, 100, 100));
		list.add(new Student(1, 1, 1, "홍길동", 100, 20, 30));
		list.add(new Student(1, 2, 1, "둘리", 70, 60, 80));
		double da = 0;
		System.out.println(printAvgKor(list));
		System.out.println(printAvgEng(list, da));
		System.out.println(printAvgMath(list, da));
		System.out.println("*** *** *** *** ***");
		printS(list, f -> f.getKor(), s -> s.getName());
		System.out.println("*** *** *** *** ***");
		printKor(list);
		printEng(list);
		printMath(list);
		print(list, s -> System.out.println("이름 : " + s.getName() + ", 국어 : " + s.getKor()));
		System.out.println("국어 성적이 80점 이상");
		printStudent(list, p -> p.getKor() >= 80);
		System.out.println("*** *** *** *** ***");

		System.out.println("1학년 1반 만 출력");
		printStudent(list, p -> p.getGrade() == 1 && p.getClassNum() == 1);
		System.out.println("*** *** *** *** ***");

		System.out.println("1학년 1반 1번 만 출력");
		printStudent(list, p -> p.getGrade() == 1 && p.getClassNum() == 1 && p.getNum() == 1);
		System.out.println("*** *** *** *** ***");

		Collections.sort(list, (o1, o2) -> {
			if (o1.getGrade() != o2.getGrade()) {
				return o1.getGrade() - o2.getGrade();
			}
			if (o1.getClassNum() != o2.getClassNum()) {
				return o1.getClassNum() - o2.getClassNum();
			}
			return o1.getNum() - o2.getNum();
		});
		System.out.println(list);
		System.out.println("*** *** *** *** ***");
		printStudent(list, p->true);
		System.out.println("영어 성적순 정렬");
		Collections.sort(list, (o1, o2)-> o2.getEng() - o1.getEng());
		printStudent(list, p->true);
	}
	
	

	public static void printStudent(List<Student> list, Predicate<Student> p) {
		for (Student tmp : list) {
			if (p.test(tmp)) {
				System.out.println(tmp);
			}
		}
	}

	public static void print(List<Student> list, Consumer<Student> c) {
		for (Student tmp : list) {
			c.accept(tmp);
		}
	}

	public static void printS(List<Student> list, Function<Student, Integer> f, Function<Student, String> s) {
		for (Student tmp : list) {
			System.out.println(s.apply(tmp) + f.apply(tmp));
		}
	}

	public static void printKor(List<Student> list) {
		for (Student tmp : list) {
			System.out.println(tmp.getKor());
		}
	}

	public static void printEng(List<Student> list) {
		for (Student tmp : list) {
			System.out.println(tmp.getEng());
		}
	}

	public static void printMath(List<Student> list) {
		for (Student tmp : list) {
			System.out.println(tmp.getMath());
		}
	}

	public static Double printAvgKor(List<Student> list) {
		int sum = 0;
		for (Student tmp : list) {
			sum = sum + tmp.getKor();
		}
		return sum / (double) list.size();
	}

	public static Double printAvgEng(List<Student> list, double a) {
		for (Student tmp : list) {
			a = a + tmp.getEng();
		}
		return a / (double) list.size();
	}

	public static Double printAvgMath(List<Student> list, double a) {
		for (Student tmp : list) {
			a = a + tmp.getMath();
		}
		return a / (double) list.size();
	}

}

interface AB {
	int sum(int su1, int su2, int su3);
}

@Data
@AllArgsConstructor
class Student {
	@NonNull
	private int grade, classNum, num;
	@NonNull
	private String name;
	private int kor, eng, math;

	@Override
	public String toString() {
		return grade + "학년 " + classNum + "반" + num + "번 / 이름 : " + name + ", 국어 : " + kor + ", 영어 : " + eng + ", 수학 : "
				+ math + "점";
	}

}