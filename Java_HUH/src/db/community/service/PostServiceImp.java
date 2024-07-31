package db.community.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.community.dao.PostDAO;
import db.community.model.vo.CommunityVO;
import db.community.model.vo.PostVO;

public class PostServiceImp implements PostService {

	private PostDAO postDao;

	public PostServiceImp() {
		String resource = "db/community/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			postDao = session.getMapper(PostDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean insertCommunity(String coName) {
		if (coName.trim().length() == 0 || coName == null) {
			System.out.println("커뮤니티명 값이 null 입니다");
			return false;
		}
		coName = coName.trim();

		CommunityVO communityVO = postDao.selectCommunity(coName);

		if (communityVO.getCo_name().length() != 0) {// 오류나면 communityVO != null 로 조건변경 부탁드립니다.
			System.out.println("커뮤니티명 중복");
			return false;
		}

		return postDao.insertCommunity(coName);
	}

	@Override
	public boolean updateCommunity(String oldCoName, String newCoName) {

		if (oldCoName.length() == 0 || newCoName.length() == 0) {
			System.out.println("커뮤니티명 값이 null 입니다");
			return false;
		}

		if (oldCoName.equals(newCoName)) {
			System.out.println("이전 커뮤니티명과 같습니다.");
			return false;
		}

		CommunityVO communityVO = postDao.selectCommunity(newCoName);

		oldCoName = oldCoName.trim();
		newCoName = newCoName.trim();

		if (communityVO.getCo_name().length() != 0) {
			System.out.println("이미 있는 커뮤니티명 입니다.");
			return false;
		}

		return postDao.updateCommunity(oldCoName, newCoName);
	}

	@Override
	public boolean deleteCommunity(String coName) {
		List<CommunityVO> list = postDao.selectCommunityList();
		
		if (list.size() == 1) {
			return false;
		}
				
		coName = coName.trim();
		return postDao.deleteCommunity(coName);
	}

	@Override
	public boolean insertPost(int coid, String title, String content, String meid) {

		return false;
	}

	@Override
	public boolean insertPost(PostVO post) {

		if (post == null)
			return false;

		if (!checkString(post.getPo_name()))
			return false;

		if (!checkString(post.getPo_content()))
			return false;
		
//		System.out.println(post); //기본키 0
		boolean res =  postDao.insertPost(post);
//		System.out.println(post); //기본키가 바뀜
		
		return res;
	}
	

	private boolean checkString(String str) {
		if (str.trim().length() == 0 || str == null)
			return false;
		return true;
	}

	@Override
	public List<CommunityVO> getCommunityList() {

		return postDao.selectCommunityList();
	}

}
