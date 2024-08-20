package kr.kh.app.service;

import kr.kh.app.model.dto.LoginDTO;
import kr.kh.app.model.dto.SignUpDTO;
import kr.kh.app.model.vo.UserVO;

public interface UserService {

	boolean signup(SignUpDTO userDto);

	UserVO getUser(LoginDTO userDto);
	
	UserVO findUserByID(String me_id);
}
