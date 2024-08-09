package kr.kh.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.pagination.Criteria;

public interface PostDAO {

	List<CommunityVO> getCommunityList();

	List<PostVO> getPostList(@Param("cri")Criteria cri);

	CommunityVO selectCommunity(@Param("co_id")int coId);

	int selectPostTotalCount(@Param("cri")Criteria cri);

	PostVO getPost(@Param("po_id")int poId);

}
