package kr.kh.app.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.app.model.dto.SignUpDTO;
import kr.kh.app.model.vo.UserVO;

public interface UserDAO {

	boolean insertUser(@Param("user")SignUpDTO userDto);

	UserVO findUserByID(@Param("me_id")String me_id);

	void idFailAdd1(@Param("user")UserVO user);

	void idSuccessFailReturnZero(@Param("user")UserVO user);

}
