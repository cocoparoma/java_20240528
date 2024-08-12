package kr.kh.app.service;

import java.util.List;

import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.pagination.Criteria;
import kr.kh.app.pagination.PageMaker;

public interface PostService {

	List<CommunityVO> getCommunityList();

	List<PostVO> getPostList(Criteria cri);

	CommunityVO getCommunity(int coId);

	PageMaker getPageMaker(Criteria cri, int displayPageNum);

	PostVO getPost(int poId);

	boolean insertPost(PostVO post);

	PostVO getPost(int poId, MemberVO user);

	boolean updatePost(PostVO post, MemberVO user);

	boolean deletePost(int po_id, MemberVO user);

	void updatePostView(int id);

}
