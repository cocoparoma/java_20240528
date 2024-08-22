package kr.kh.app.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.naming.java.javaURLContextFactory;

import kr.kh.app.dao.PostDAO;
import kr.kh.app.model.dto.CommListDTO;
import kr.kh.app.model.vo.CommVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.pagination.Criteria;
import kr.kh.app.pagination.PageMaker;

public class PostServiceImp implements PostService {
	
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
	public List<CommVO> getCommVOList() {
		
		return postDao.getCommVOList();
	}

	@Override
	public List<CommListDTO> getCommDTOList() {
		
		return postDao.getCommDTOList();
	}

	@Override
	public CommVO getComm(String co_id) {
		
		return postDao.getComm(co_id);
	}

	@Override
	public List<PostVO> getPostList(Criteria cri) {
		if (cri == null) {
			return null;
		}
		
		return postDao.getPostList(cri);
	}

	@Override
	public PageMaker getPageMaker(Criteria cri) {
		if (cri == null) {
			return null;
		}
		
		//post카운팅 해줘야함
		int totalCount = postDao.getPostTotalCount(cri);
		
		
		//total, display, cri -> 나머지는 내부에서 컬큘이 계산해준다
		return new PageMaker(totalCount, 10, cri);
	}

	@Override
	public PostVO getPost(String po_id) {
		return postDao.getPost(po_id);
	}

	@Override
	public boolean setPost(PostVO post) {
		if (post == null) {
			return false;
		}
		
		
		if (post.getPo_name() == null || post.getPo_name().trim().length() == 0) {
			return false;
		}
		
		try {
			return postDao.setPost(post);
		} catch (Exception e) {
			System.out.println("post Insert postServiceImp err");
			return false;
		}
		
	}

	@Override
	public void addViewPoint(int po_id) {
		
		postDao.addViewPoint(po_id);
	}

	@Override
	public boolean modifyPost(PostVO post) {
		if (post == null) {
			return false;
		}
		
		if (post.getPo_name() == null || post.getPo_name().trim().length() == 0) {
			return false;
		}
		try {
			return postDao.modPost(post);
		} catch (Exception e) {
			System.out.println("post Update postServiceImp err");
			return false;
		}
	}
	
	
	
	
	
	
	
}
