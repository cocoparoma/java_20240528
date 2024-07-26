package db.student.controller;

import java.util.Scanner;

import db.student.model.vo.StudentVO;
import db.student.service.StudentServiceImp;

public class StudentController {
	
	
	private StudentServiceImp studentService = new StudentServiceImp();
	private Scanner scan;
	
	public StudentController(Scanner scan) {
		this.scan = scan;
	}

	public void insertStudent() {
		//입력한 정보를 이용하여 객체를 생성
		StudentVO std = inputStudentExpand();

		//학생 추가에 성공하면 성공했다고 알림, 실패하면 실패했다고  알림
		if(studentService.insertStudent(std)) {
			System.out.println("학생이 추가되었습니다.");
		}
		else {
			System.out.println("이미 등록된 학생 정보이어서 추가하지 못했습니다.");
		}
		
	}
	
	

	public StudentVO inputStudent() {
		System.out.print("학년 : ");
		int st_grade = Integer.parseInt(scan.nextLine());
		System.out.print("반 : ");
		int st_class = Integer.parseInt(scan.nextLine());
		System.out.print("번호 : ");
		int st_num = Integer.parseInt(scan.nextLine());
		return new StudentVO(st_grade, st_class, st_num, "");
	}
	
	public StudentVO inputStudentExpand() {
		StudentVO std = inputStudent();
		
		System.out.print("이름 : ");
		String name = scan.nextLine();
		std.setSt_name(name);
		return std;
	}

	public void updateStudent() {
		StudentVO std = inputStudent();
		
		if (! studentService.contains(std)) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		
		System.out.println("일치하는 학생이 있습니다.");
		
		//수정할 정보
		StudentVO newStd = inputStudentExpand();
		
		
		if (studentService.updateStudent(std, newStd)) {
			System.out.println("학생 정보 수정 완료");
			return;
		}
		System.out.println("이미 등록된 학생 정보로 수정할 수 없습니다.");
	
		
		
		
	}

	public void deleteStudent() {
		StudentVO std = inputStudent();
		
		if (studentService.deleteStudent(std)) {
			System.out.println("학생을 삭제하였습니다.");
			return;
		}
		
		System.out.println("일치하는 학생이 없습니다.");
	}

	public void selectStudent() {
		StudentVO std = inputStudent();
		
		StudentVO dbstd =studentService.selectStudent(std);
		
		if (dbstd==null) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		System.out.println(dbstd);
		
		
		// 성적을 가져옴
		
		// 성적 출력
		
		
	}
	
	
	
	
	
	
	
	
}
