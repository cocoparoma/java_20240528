package db.student.controller;

import java.awt.im.InputSubset;
import java.util.Scanner;

import db.student.model.vo.ScoreVO;
import db.student.model.vo.StudentVO;
import db.student.model.vo.SubjectVO;
import db.student.service.ScoreService;
import db.student.service.ScoreServiceImp;
import db.student.service.SubjectServiceImp;

public class ScoreController {
	
	private Scanner scan;
	private ScoreServiceImp scoreService = new ScoreServiceImp();
	
	public ScoreController(Scanner scan) {
		this.scan = scan;
	}


	public void inserScore() {
		
		
		
		
		StudentVO std = inputStudent();
		SubjectVO subject = inputSubject();
		ScoreVO score = inputScore();
		
		
		if (scoreService.insertScore(std, subject, score)) {
			System.out.println("학생 성적 등록");
		}else {
			System.out.println("학생 성적 등룍 오류");
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
	
	public ScoreVO inputScore() {
		System.out.print("중간 : ");
		int midterm = Integer.parseInt(scan.nextLine());
		System.out.print("기말 : ");
		int finals = Integer.parseInt(scan.nextLine());
		System.out.print("수행 : ");
		int performace = Integer.parseInt(scan.nextLine());
		ScoreVO score = new ScoreVO(midterm,finals,performace);
		return score;
	}
	
	public SubjectVO inputSubject(){
		System.out.print("이름 : ");
		String name = scan.nextLine();
		System.out.print("학년 : ");
		int grade = Integer.parseInt(scan.nextLine());
		System.out.print("학기 : ");
		int semester = Integer.parseInt(scan.nextLine());
		return new SubjectVO(name, grade, semester);
	}


	public void delectScore() {
		
		StudentVO std = inputStudent();
		SubjectVO subject = inputSubject();
		
		if (scoreService.deleteScore(std, subject)) {
			System.out.println("과목 성적 삭제 완료");
			return;
		} else {
			System.out.println("삭제 실패");
		}
	}


	public void updateScore() {
		
		StudentVO std = inputStudent();
		SubjectVO subject = inputSubject();
		
		
		ScoreVO score = inputScore();
		
		if (scoreService.updateScore(std, subject, score)) {
			System.out.println("과목 성적 수정 완료");
		} else {
			System.out.println("! 과목 성적 수정 실패");
		}
		
		
		
	}
	
	
}
