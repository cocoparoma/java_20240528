package db.community.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.community.dao.MemberDAO;
import db.community.model.vo.MemberVO;

public class MemberServiceImp implements MemberService {
	
	
	private MemberDAO memberDao;
	
	
	public MemberServiceImp(){
		String resource = "db/community/config/mybatis-config.xml";
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
	public MemberVO login(String id, String pw) {
		if (id.length() == 0 ||pw.length() == 0 ) {
			return null;
		}
		
		MemberVO user = memberDao.selectMember(id);
		
		if (user == null) {
			return null;
		}
		
		// 암호화시 해당 부분을 수정하면 됨
		if (user.getMe_pw().equals(pw)) {
			memberDao.updateFail(user.getMe_id(),0);
			return user;
		}
		
		memberDao.updateFail(user.getMe_id(),1);
		return null;
	}


	@Override
	public boolean signUp(String id, String pw, String email) {
		MemberVO user = memberDao.selectMember(id);
		if (user != null) {
			System.out.println("중복확인을 위해 가져온 유저정보 null");
			return false;
		}
		String idRegex = "^\\w{6,13}$";
		if (!Pattern.matches(idRegex, id)) {
			System.out.println("아이디 패턴 불일치");
			return false;
		}
		String pwRegex = "^[a-zA-Z0-9!@#$]{6,15}$";
		if (!Pattern.matches(pwRegex, pw)) {
			System.out.println("비번 패턴 불일치");
			return false;
		}
		//join user to dao
		System.out.println("생성");
		return memberDao.insertMember(id, pw, email);
	}



}
