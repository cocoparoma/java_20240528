package kr.kh.app.service;

import kr.kh.app.model.vo.MemberVO;

public interface AdminService {

	boolean insertCommunity(String co_name);

	boolean deleteCommunity(int co_id, MemberVO admin);

	boolean updateCommunity(int co_id, String co_name, MemberVO admin);

}
