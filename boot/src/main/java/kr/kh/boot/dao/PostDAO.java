package kr.kh.boot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.boot.model.vo.CommunityVO;
import kr.kh.boot.model.vo.PostVO;
import kr.kh.boot.pagination.PostCriteria;

public interface PostDAO {
	int count();

	List<PostVO> selectPostList(PostCriteria cri);

	List<CommunityVO> getCommunityList();

	int selectCountPostList(PostCriteria cri);

	PostVO getPostById(int po_id);

	void addPostViewPoint(int po_id);
}
