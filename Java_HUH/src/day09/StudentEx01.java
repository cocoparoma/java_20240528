package day09;

import java.util.*;

public class StudentEx01 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int arr_if[] = new int[3];
		int student_number = 102;
		Student std[] = new Student[student_number];
		int count = 0;
		for (int i = 0; i < std.length; i++) {
			std[i] = new Student();
		}
		int menu = 0;
		do {
			print_menu();
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				count = insertStudent(std, arr_if, count);
				break;
			case 2:
				updateStudent(std, count, arr_if);
				break;
			case 3:
				show_student_info(std, arr_if);
				break;
			case 4:
				System.out.println("종료합니다.");
				break;
			default:
				System.out.println("오류입니다.");
			}
			// run_menu(menu);
		} while (menu != 4);
	}// main done

	public static void print_menu() {
		System.out.println("메뉴");
		System.out.println("1. 학생 등록");
		System.out.println("2. 성적 수정 ");
		System.out.println("3. 성적 확인");
		System.out.println("4. 종료");
		System.out.print("입력 : ");
	}// print_menu done

	public static int[] score_input(int[] a) {
		System.out.print("학년 : ");
		a[0] = sc.nextInt();
		System.out.print("반 : ");
		a[1] = sc.nextInt();
		System.out.print("번호 : ");
		a[2] = sc.nextInt();
		return a;
	}

	public static void run_menu(int menu) { // 주석처리됨
		switch (menu) {
		case 1:
			System.out.println("학생 등록입니다.");
			break;
		case 2:
			System.out.println("성적 수정입니다.");
			break;
		case 3:
			System.out.println("성적 확인입니다.");
			break;
		case 4:
			System.out.println("종료합니다.");
			break;
		default:
			System.out.println("오류입니다.");
		}// switch(menu) done
	}

	public static int insertStudent(Student[] std, int arr_if[], int count) {
		score_input(arr_if);
		System.out.print("이름 :");
//		std[count].setName(sc.next());
		std[count] = new Student(arr_if[0], arr_if[1], arr_if[2], sc.next());
		if (count > 100) {
			System.out.println("더이상 추가할 수 없습니다.");
		} else {
			count++;
		}
		return count;
	}

	public static void updateStudent(Student[] std, int count, int[] arr_if) {
		System.out.println("성적 수정입니다.");
		System.out.println("학년, 반, 번호를 입력해 주세요.");
		score_input(arr_if);
		boolean ox = false;
		std[101] = new Student(arr_if[0], arr_if[1], arr_if[2], "testMember");
		for (int i = 0; i < std.length - 1; i++) {// continue 사용이 더 깔끔함 ㄲㅂ
			int OnOff = 0;
			if (std[101].getGrade() == std[i].getGrade()) {
				OnOff++; // 1
			}
			if (OnOff == 1 && std[101].getClassNum() == std[i].getClassNum()) {
				OnOff++; // 2
			}
			if (OnOff == 2 && std[101].getNum() == std[i].getNum()) {
				OnOff++; // 3
			}
			if (OnOff == 3) {
				System.out.println("일치하는 학생이 있습니다. 성적을 입력해 주세요");
				System.out.print("국어 : ");
				int tmp = sc.nextInt();
				System.out.print("영어 : ");
				int tmp1 = sc.nextInt();
				System.out.print("수학 : ");
				int tmp2 = sc.nextInt();
				std[i].updateScore(tmp, tmp1, tmp2);
				std[i].print_Student_info();
				ox = false;
			}
		}
		if (ox) {
			System.out.println("일치하는 학생이 없습니다.");
		}
		ox = true;
	}

	public static void show_student_info(Student[] std, int[] arr_if) {
		System.out.println("성적 확인입니다.");
		System.out.println("성적 수정입니다.");
		System.out.println("학년, 반, 번호를 입력해 주세요.");
		score_input(arr_if);
		boolean ox = false;
		std[101] = new Student(arr_if[0], arr_if[1], arr_if[2], "testMember");
		for (int i = 0; i < std.length - 1; i++) {
			int OnOff = 0;
			if (std[101].getGrade() == std[i].getGrade()) {
				OnOff++; // 1
			}
			if (OnOff == 1 && std[101].getClassNum() == std[i].getClassNum()) {
				OnOff++; // 2
			}
			if (OnOff == 2 && std[101].getNum() == std[i].getNum()) {
				OnOff++; // 3
			}
			if (OnOff == 3) {
				System.out.println("일치하는 학생이 있습니다. 성적을 출력합니다.");
				std[i].print_Student_info();
				ox = false;
			}
		}
		if (ox) {
			System.out.println("일치하는 학생이 없습니다.");
		}
		ox = true;
	}

	public static void cleanScreen() {
		for (int i = 0; i < 80; i++)
			System.out.println("");
	}// cleanScreen done

}// StudentEx01 class done

class Student {
	private int grade, classNum, num;
	private int kor, eng, math;
	private String name;

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getClassNum() {
		return classNum;
	}

	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public Student() {// 생성자

	}

	public Student(int grade, int classNum, int num, String name) {// 생성자
		super();
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
	}

	public void updateScore(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public void print_Student_info() {
		System.out.println(grade + "학년 " + classNum + "반 " + num + "번 " + name);
		System.out.println("국어 : " + kor + ", 영어 : " + eng + ", 수학 : " + math);
	}

}
