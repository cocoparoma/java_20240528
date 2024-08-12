package kr.kh.app.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.PostDAO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.pagination.Criteria;
import kr.kh.app.pagination.PageMaker;


public class PostServiceImp implements PostService{

	
	
	private PostDAO postDao;

	
	
	public PostServiceImp() {
		String resource = "kr/kh/app/config/mybatis-config.xml";
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
	public List<CommunityVO> getCommunityList() {
		
		return postDao.getCommunityList();
	}



	@Override
	public List<PostVO> getPostList(Criteria cri) {
		if (cri == null) {
			throw new RuntimeException();
		}
		
		
		return postDao.getPostList(cri);
	}



	@Override
	public CommunityVO getCommunity(int coId) {
		return postDao.selectCommunity(coId);
	}



	@Override
	public PageMaker getPageMaker(Criteria cri, int displayPageNum) {
		
		if (cri == null) {
			throw new RuntimeException();
		}
		
		int totalCount = postDao.selectPostTotalCount(cri);
		
		
		return new PageMaker(totalCount, displayPageNum, cri);
	}



	@Override
	public PostVO getPost(int poId) {
		if (poId == 0) {
			throw new RuntimeException();
		}
		
		return postDao.getPost(poId);
	}



	@Override
	public boolean insertPost(PostVO post) {
		if (post == null) {
			return false;
		}
		
		if (post.getPo_name() == null || post.getPo_name().trim().length() == 0 ) {
			return false;
		}
		
		if (post.getPo_content() == null || post.getPo_content().trim().length() == 0 ) {
			return false;
		}
		
		return postDao.insertPost(post);
	}



	@Override
	public PostVO getPost(int poId, MemberVO user) {
		if (user == null) {
			return null;
		}
		
		PostVO post = postDao.getPost(poId);
		
		if (post == null) {
			return null;
		}
		
//		post.getPo_me_id().equals(user.getMe_id())
		if (checkWriter(poId, user)) {
			return post;
		}
		
		return null;
	}



	@Override
	public boolean updatePost(PostVO post, MemberVO user) {
		
		if (post == null || user == null) {
			return false;
		}
		
		if (!checkWriter(post.getPo_id(), user)) {
			return false;
		}
		if (post.getPo_name() == null || post.getPo_name().trim().length() == 0 ) {
			return false;
		}
		
		if (post.getPo_content() == null || post.getPo_content().trim().length() == 0 ) {
			return false;
		}
		
		return postDao.updatePost(post);
	}
	
	private boolean checkWriter (int po_id, MemberVO user) {
		if (user == null) {
			return false;
		}
		
		PostVO post = postDao.getPost(po_id);
		
		if (post == null) {
			return false;
		}
		
		
		if (post.getPo_me_id().equals(user.getMe_id())) {
			return true;
		}
		
		
		return false;
	}



	@Override
	public boolean deletePost(int po_id, MemberVO user) {
		
		if (!checkWriter(po_id, user)) {
			return false;
		}
		
		return postDao.deletePost(po_id);
	}



	@Override
	public void updatePostView(int id) {
		postDao.updatePostView(id);
	}
	
}
