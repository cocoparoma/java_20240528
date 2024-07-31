package db.community.service;

import db.community.model.vo.MemberVO;

public interface MemberService {

	MemberVO login(String id, String pw);

	boolean signUp(String id, String pw, String email);


}
