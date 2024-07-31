package db.community.controller;

import java.util.Scanner;

import db.community.model.vo.MemberVO;
import db.community.service.MemberService;
import db.community.service.MemberServiceImp;

public class MemberController {
	
	
	private MemberService memberService = new MemberServiceImp();
	private Scanner scan;
	
	public MemberController(Scanner scan) {
		this.scan = scan;
	}
	
	
	public MemberVO login() {
		// 아이디 입력
		System.out.print("ID>> ");
		String id = scan.nextLine();
		
		// 비번 입력
		System.out.print("PW>> ");
		String pw = scan.nextLine();
		
		// 서비스에게 회원정보 가지고 오라고 실시
		MemberVO user = memberService.login(id,pw);
		// 가지고온 회원 정보 반환
		return user;
	} // MemberVO login done


	public boolean signUp() {
		System.out.println("---------회원 가입---------");
		//id
		System.out.print("ID>> ");
		String id = scan.nextLine();
		//pw
		System.out.print("PW>> ");
		String pw = scan.nextLine();
		//pw2
		System.out.print("PW check>> ");
		String pw2 = scan.nextLine();
		//email
		System.out.print("email>> ");
		String email = scan.nextLine();
		
		if (!pw.equals(pw2)) {
			System.out.println("비번 확인 불일치");
			return false;
		}
		
		return memberService.signUp(id,pw,email);
	}
	
	
	
	
	
}
