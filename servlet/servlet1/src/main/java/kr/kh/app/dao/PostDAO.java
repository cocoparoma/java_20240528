package kr.kh.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.app.model.vo.CommentVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.model.vo.RecommendVO;
import kr.kh.app.pagination.Criteria;

public interface PostDAO {

	List<CommunityVO> getCommunityList();

	List<PostVO> getPostList(@Param("cri")Criteria cri);

	CommunityVO selectCommunity(@Param("co_id")int coId);

	int selectPostTotalCount(@Param("cri")Criteria cri);

	PostVO getPost(@Param("po_id")int poId);

	boolean insertPost(@Param("post")PostVO post);

	boolean updatePost(@Param("post")PostVO post);

	boolean deletePost(@Param("po_id")int po_id);

	void updatePostView(@Param("po_id")int id);

	RecommendVO selectRecommend(@Param("re")RecommendVO recommend);

	void deleteRecommend(@Param("re_id")int re_id);

	void insertRecommemd(@Param("re")RecommendVO recommend);

	List<CommentVO> selectCommentList(@Param("cri")Criteria cri);

	int selectCommentTotalCount(@Param("cri")Criteria cri);

	boolean insertComment(@Param("cm")CommentVO comment);

	CommentVO selectComment(@Param("cm_id")int co_id);

	boolean deleteComment(@Param("cm_id")int co_id);

	boolean updateComment(@Param("cm")CommentVO comment);

}
