package kr.kh.app.service;

import java.util.List;

import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.pagination.Criteria;
import kr.kh.app.pagination.PageMaker;

public interface PostService {

	List<CommunityVO> getCommunityList();

	List<PostVO> getPostList(Criteria cri);

	CommunityVO getCommunity(int coId);

	PageMaker getPageMaker(Criteria cri, int displayPageNum);

	PostVO getPost(int poId);

}
