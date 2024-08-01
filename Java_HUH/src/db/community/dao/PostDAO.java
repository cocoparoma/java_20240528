package db.community.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import db.community.model.vo.CommentVO;
import db.community.model.vo.CommunityVO;
import db.community.model.vo.PostVO;
import db.community.pagination.Criteria;

public interface PostDAO {

	CommunityVO selectCommunity(@Param("coName")String coName);

	boolean insertCommunity(@Param("coName")String coName);

	boolean updateCommunity(@Param("oldCoName")String oldCoName, @Param("newCoName")String newCoName);

	boolean deleteCommunity(@Param("coName")String coName);

	List<CommunityVO> selectCommunityList();

	boolean insertPost(@Param("po")PostVO post);

	List<PostVO> selectPostList(@Param("cri")Criteria cri);

	PostVO selectPost(@Param("po_id")int co_idint);

	int selectPostListCount(@Param("cri")Criteria cri);

	boolean deletePost(@Param("po_id")int po_id);

	boolean updatePost(@Param("po")PostVO post);

	boolean insertComment(@Param("co")CommentVO co);

	List<CommentVO> selectCommentList(@Param("po_id")int po_id);

	void updatePostView(@Param("po_id")int co_idint);

}
