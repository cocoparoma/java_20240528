package kr.kh.app.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import kr.kh.app.model.dto.LoginDTO;
import kr.kh.app.model.dto.SignUpDTO;
import kr.kh.app.model.vo.UserVO;

public interface UserService {

	boolean signup(SignUpDTO userDto);

	UserVO getUser(LoginDTO userDto);
	
	UserVO findUserByID(String me_id);

	void idFailAdd1(UserVO userVO);

	void idSuccessFailReturnZero(UserVO user);

	Cookie setAutoLoginCookie(UserVO user, HttpServletRequest request);

	UserVO getMemberBySid(String sid);

	void updateMemberCookie(UserVO user);
}
