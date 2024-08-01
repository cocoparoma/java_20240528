package db.community.service;

import java.util.List;

import db.community.model.vo.CommentVO;
import db.community.model.vo.CommunityVO;
import db.community.model.vo.PostVO;
import db.community.pagination.Criteria;

public interface PostService {

	boolean insertCommunity(String coName);

	boolean updateCommunity(String oldCoName, String newCoName);

	boolean deleteCommunity(String coName);

	boolean insertPost(int coid, String title, String content, String meid);

	boolean insertPost(PostVO post);

	List<CommunityVO> getCommunityList();

	List<PostVO> getPostList(Criteria cri);

	PostVO getPost(int co_idint);

	int selectPostListTotalCount(Criteria cri);

	boolean deletePost(int po_id);

	boolean updatePost(PostVO post);

	boolean insertComment(CommentVO co);

	List<CommentVO> getCommentList(int po_id);

	void updatePostView(int co_idint);

}
