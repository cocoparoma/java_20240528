package kr.kh.app.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.MemberDAO;
import kr.kh.app.model.dto.LoginDTO;
import kr.kh.app.model.vo.MemberVO;

public class MemberServiceImp implements MemberService{
	
	
	private MemberDAO memberDao;

	
	public MemberServiceImp() {
		String resource = "kr/kh/app/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			memberDao = session.getMapper(MemberDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Override
	public boolean signup(LoginDTO member) {
		if (member==null) {
			return false;
		}
		
		// 중복 검사
		if (memberDao.selectMember(member.getId()) != null) {
			return false;
		}
		
		if (!checkValidate(member)) {
			return false;
		}
		
		
		try {
			//이메일이 중복되면 추가할 수 없어서(유니크 설정) 예외가 발생
			return memberDao.insertMember(member);
		} catch (Exception e) {
			return false;
		}
		
	}

	// 화면쪽에서 걸러주나 화면을 믿으면 안됨 개발자 도구를 이용해서 억지로 집어넣을 수 있는데 이럴 때 이 쪽에서 걸러주는 작업이 필요함
	private boolean checkValidate(LoginDTO member) {
		if (member== null || member.getId() == null || member.getPw() == null || member.getEmail() == null) {
			return false;			
		}
		// 아이디 유효성 검사
		String idRegex = "\\w{6,13}$";
		if (!Pattern.matches(idRegex, member.getId())) {
			return false;
		}
		
		// 비번 유효성 검사
		String pwRegex = "^[a-zA-Z0-9!@#$]{6,15}$";
		if (!Pattern.matches(pwRegex, member.getPw())) {
			return false;
		}
		// 이메일 유효성 검사
		String emailRegex = "^[A-Za-z0-9_]+@[A-Za-z0-9_]+(\\.[A-Za-z]{2,}){1,}$";	
		if (!Pattern.matches(emailRegex, member.getEmail())) {
			return false;
		}
		
		return true;
	}


	@Override
	public MemberVO getUser(String id, String pw) {
		if (id.length() == 0 || pw.length() == 0) {
			return null;
		}
		return memberDao.getUser(id, pw);
	}

	
	
	
	
	
}
