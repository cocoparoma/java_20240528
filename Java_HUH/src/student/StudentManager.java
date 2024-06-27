package student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import program.makingFiled;

public class StudentManager implements makingFiled {
	private List<Student> list = new ArrayList<Student>();
	private List<Subject> subjectList = new ArrayList<Subject>();
	private Scanner sc = new Scanner(System.in);

	@Override
	public void init() {
		while (true) {
			System.out.print("[1]학생 관리\n[2]과목 관리\n[3]종료\n>>");
			
			String M = sc.nextLine();
			
			if (M.equals("1")) insert();//Student 관리
			else if (M.equals("2")) update();//subject 관리
			else if (M.equals("3")) break;
			else if (M.equals("show")) showAll();
			else System.out.println("[잘못된 입력]");
			
			
		}
	}

	@Override
	public void insert() {//Student 관리 메뉴
		while (true) {
			System.out.print("[학생 관리 메뉴]\n[1]학생 추가\n[2]학생 수정\n[3]학생 삭제\n[4]학생 조회\n[5]뒤로가기\n>>");
			
			String M = sc.nextLine();
			
			if (M.equals("1")) studentInsert(1);//Student 관리
			else if (M.equals("2")) studentUpdateinit();// 학생 수정 매뉴
			else if (M.equals("3")) studentDelete();
			else if (M.equals("4")) studentSearch(4);
			else if (M.equals("5")) break;
			else if (M.equals("show")) showAll();
			else System.out.println("[잘못된 입력]");
		}
	}
	private void studentUpdateinit() { // 수정 필요함 메뉴2번임
		while (true) {
		System.out.print("[학생 수정 메뉴]\n[1]학생 정보 수정\n[2]성적 추가\n[3]성적 수정\n[4]성적 삭제\n[5]뒤로가기\n>>");
		
		String M = sc.nextLine();
		
		//수정 요구됨
		if (M.equals("1")) studentUpdate();//1번은 이거 맞음 아래 수정요망 수정 후 주석삭제
		else if (M.equals("2")) studentUpdate();
		else if (M.equals("3")) studentDelete();
		else if (M.equals("4")) studentSearch(4);
		else if (M.equals("5")) break;
		else if (M.equals("show")) showAll();
		else System.out.println("[잘못된 입력]");
		}
	}



	//학년반 번호 입력은 업데이트도 써야하기에 (이름재외)
	public Student inputStudent () {
		System.out.print("[학년]\n>>");
		int tmpGrade = toInt(sc.nextLine());
		System.out.print("[반]\n>>");
		int tmpClassNumber = toInt(sc.nextLine());
		System.out.print("[번호]\n>>");
		int tmpNumber = toInt(sc.nextLine());
		
	
		return 	new Student(" ", tmpGrade, tmpClassNumber, tmpNumber);
	}
	public Student inputstudentE() { //추가적으로 이름까지 입력
		Student std =  inputStudent () ;
		System.out.print("[이름]\n>>");
		String tmpName = sc.nextLine();
		std.setName(tmpName);
		return std;
	}

	private int sameStudent(Student std) {//중복확인
		if (list.contains(std)) {
			System.out.println("[중복된 학생입니다]");
			return 1;
		}
		return 0;
	}
	
	
//student 관리 ******
	private void studentInsert(int a) {//수정은 사용되지 아니하였음
		System.out.println((a == 1) ? "[학생을 추가합니다.]" : "[학생을 수정합니다.]");

		Student stdStudent = inputstudentE();

		if(sameStudent(stdStudent) == 1 ) return;

		if (a == 1) {
			list.add(stdStudent);// 생성자하난 새로만들어서 리스트빼줄것
			System.out.println("[학생 추가 완료]");
		}
		List<Student> tmplist = null;
		if (a == 2) {
		}

	}

	private void studentUpdate() {//수정, 중복확인도 완료됨
		Student ste = studentSearch(0);
		Student tmpStudent = inputstudentE();
		if(sameStudent(tmpStudent) == 1) return;
		ste.setGrade(tmpStudent.getGrade());
		ste.setClassNumber(tmpStudent.getClassNumber());
		ste.setNumber(tmpStudent.getNumber());
		ste.setName(tmpStudent.getName());
		System.out.println("[수정 완료]");
		
	}

	private void studentDelete() {//삭제
		Student ste = studentSearch(0);
		list.remove(ste);
		System.out.println("[삭제 완료]");
	}

	private Student studentSearch(int a) {//찾기 >> 수정과 삭제에 사용되었음 a가 4로 입력되면 추가사항없이 출력만 하도록 설계됨 / 잘못 입력시 널값을 가져가게 됨 / 널포인트에러가 날 가능성 O
		System.out.print("[찾으시는 학생의 이름을 입력해 주세요.]\n>>");
		String tmpName =sc.nextLine();
		List<Student> tmplist = list.stream().filter(p->p.getName().contains(tmpName)).toList();
		if (tmplist.size() == 0) {
			System.out.println("[찾으시는 정보가 없습니다.]");
		}
		for (int i = 0; i < tmplist.size(); i++) {
			System.out.println("[" + (i + 1) + "]" + tmplist.get(i).grade + "학년"  +  tmplist.get(i).classNumber + "반 "+  tmplist.get(i).number + "번 이름 : " +  tmplist.get(i).name); //출력이 여기서 이루어짐
		}
		if (a == 4)return null; // 받는사람이 없어서 괜찮음
		System.out.print("[찾으시는 번호를 입력해 주세요]\n>>");
		int idx = toInt(sc.nextLine());
		if (idx == -10) return null; //에러 날 수 있음 ㅇㅇ
		Student tmpStudent = tmplist.get(idx-1);
		return tmpStudent;
	}
	//student 관리 done******
	
	
	@Override
	public void update() {//subject menu임
		while (true) {
			System.out.print("[과목 관리 메뉴]\n[1]과목 추가\n[2]과목 수정\n[3]과목 삭제\n[4]과목 조회\n[5]뒤로가기\n>>");
			
			String M = sc.nextLine();
			//subject관련으로 바꿀 것
			if (M.equals("1")) studentInsert(1);//Student 관리
			else if (M.equals("2")) studentUpdateinit();//studentUpdate();
			else if (M.equals("3")) studentDelete();
			else if (M.equals("4")) studentSearch(4);
			else if (M.equals("5")) break;
			else if (M.equals("show")) showAll();
			else System.out.println("[잘못된 입력]");
		}
	}

	@Override
	public void delete() {//과목삭제
		// TODO Auto-generated method stub

	}

	@Override
	public String finById(String id) {//서브잭트 중복확인으로 사용할 수 가능성 높음
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void showAll() {//디버깅용
		System.out.println(list); //깡으로 리스트 찍어보기ㅣ

	}

	@Override
	public void save(String file) {
		// TODO Auto-generated method stub

	}

	@Override
	public void load(String file) {
		// TODO Auto-generated method stub

	}
	
	public int toInt(String a) {
		int toint =-1;
		try {
			toint  = Integer.parseInt(a);
		} catch (Exception e) {
			System.out.println("[잘못된 입력]");
			toint = -10;
		}
		return toint;
	}
	

	

}
