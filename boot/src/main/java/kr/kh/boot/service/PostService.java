package kr.kh.boot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.kh.boot.dao.PostDAO;
import kr.kh.boot.model.vo.CommunityVO;
import kr.kh.boot.model.vo.PostVO;
import kr.kh.boot.pagination.PageMaker;
import kr.kh.boot.pagination.PostCriteria;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostService {
	
	private PostDAO postDao;

	
	public List<PostVO> getPostList(PostCriteria cri) {
		return postDao.selectPostList(cri);
	}


	public List<CommunityVO> getCommunityList() {
		return postDao.getCommunityList();
	}


	public PageMaker getPageMaker(PostCriteria cri) {
		int count = postDao.selectCountPostList(cri); 
		return new PageMaker(3, cri, count);
	}


	public PostVO getPostById(int po_id) {
		return postDao.getPostById(po_id);
	}


	public void addPostViewPoint(int po_id) {
		postDao.addPostViewPoint(po_id);
		
	}
}
	