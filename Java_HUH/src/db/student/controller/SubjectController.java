package db.student.controller;

import java.util.ArrayList;
import java.util.Scanner;

import db.student.model.vo.SubjectVO;
import db.student.service.SubjectServiceImp;

public class SubjectController {
	
	private Scanner scan = new Scanner(System.in);
	private SubjectServiceImp subjectService = new SubjectServiceImp();

	
	public SubjectController(Scanner scan) {
		this.scan = scan;
	}


	public void insertSubject() {
		System.out.print("과목 : ");
		String subject = scan.nextLine();
		
		if (subjectService.insertSubject(subject)) {
			System.out.println("과목을 추가했습니다");
		} else {
			System.out.println("이미 등록된 과목입니다.");
		}
	
	}


	public void updateSubject() {
		System.out.print("과목 : ");
		String subject = scan.nextLine();

		System.out.print("새 과목 : ");
		String newSubject = scan.nextLine();
		
	
		if (subjectService.updateSubject(subject, newSubject)) {
			System.out.println("과목 수정 완료");
		} else {
			System.out.println("! 오류 : 없는 과목이거나, 이미 중복된 과목입니다.");
		}
		
		
	}


	public void deleteSubject() {
		System.out.print("삭제할 과목 : ");
		String subject = scan.nextLine();
		
		if (subjectService.deleteSubject(subject)) {
			System.out.println("과목 삭제 완료");
		} else {
			System.out.println("! 실패 : 없는 과목입니다.");
		}
		
	}


	public void selectSubject() {
		ArrayList<SubjectVO> list = subjectService.selectSubjectList();
		
		if (list == null) {
			System.out.println("과목이 없습니다.");
		}
		System.out.println(list);
	}
	
	
}
