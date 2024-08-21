package kr.kh.app.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.UserDAO;
import kr.kh.app.model.dto.LoginDTO;
import kr.kh.app.model.dto.SignUpDTO;
import kr.kh.app.model.vo.UserVO;


public class UserServiceImp implements UserService {

	private UserDAO userDao;
	
	public UserServiceImp() {
		String resource = "kr/kh/app/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			userDao = session.getMapper(UserDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean signup(SignUpDTO userDto) {
		
		if (userDto.getMe_email().trim().length()==0) {
			return false;
		}
		
		if (userDto.getMe_id().trim().length()==0) {
			return false;
		}
		
		if (userDto.getMe_pw().trim().length()==0) {
			return false;
		}
		
		System.out.println("userDto :" + userDto);
		
		String id_regex = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,15}$";
//		Pattern id_Pattern = Pattern.compile(id_regex);
		
		String pw_regex = "^(?=.*[a-zA-Z])((?=.*\\d)|(?=.*\\W)).{6,128}+$"; ;
//		Pattern pw_Pattern = Pattern.compile(pw_regex);
		
		String email_regex = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
//		Pattern email_Pattern = Pattern.compile(email_regex);
		
		
		boolean id_res = Pattern.matches(id_regex, userDto.getMe_id());
		System.out.println("id_res : " + id_res);
		
		if (!id_res) {
			return false;
		}

		boolean pw_res = Pattern.matches(pw_regex, userDto.getMe_pw());
		System.out.println("pw_res : " + pw_res);

		if (!pw_res) {
			return false;
		}
		
		boolean email_res = Pattern.matches(email_regex, userDto.getMe_email());
		System.out.println("email_res : " + email_res);
		
		if (!email_res) {
			return false;
		}	
		
		
		try {
			boolean res = userDao.insertUser(userDto);
			return res;
		} catch (Exception e) {
			System.out.println("중복");
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public UserVO getUser(LoginDTO userDto) {
		
		if (userDto.getMe_pw().trim().length()==0) {
			return null;
		}
		
		if (userDto.getMe_id().trim().length()==0) {
			return null;
		}
		
		// 아이디가 있는지 확인(아이디만!)
		UserVO user = findUserByID(userDto.getMe_id());
		
		// 가져온 유저정보 -> 아이디가 없으면 null
		System.out.println(user);
		if (user == null) {
			return null;
		}
		
		// 가져온 유저정보의 비번을 확인
		if (!user.getMe_pw().equals(userDto.getMe_pw())) {
			return null;
		}
		
		// 사용 상태인지 확인
		if (!user.getMe_ms_name().equals("사용")) {
			return null;
		}
		
		// 아이디 실패 횟수가 5보다 크면
		if (user.getMe_fail() > 5) {
			return null;
		}

		return user;
	}

	
	//ID로 사람구하기
	@Override
	public UserVO findUserByID(String me_id) {
		
		return userDao.findUserByID(me_id);
	}

	@Override
	public void idFailAdd1(UserVO user) {
		userDao.idFailAdd1(user);
	}

	@Override
	public void idSuccessFailReturnZero(UserVO user) {
		userDao.idSuccessFailReturnZero(user);
	}
	
	
}
