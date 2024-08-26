package kr.kh.app.service;

import java.util.List;

import kr.kh.app.model.dto.CommListDTO;
import kr.kh.app.model.vo.CommVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.model.vo.UserVO;
import kr.kh.app.pagination.Criteria;
import kr.kh.app.pagination.PageMaker;

public interface PostService {

	List<CommVO> getCommVOList();

	List<CommListDTO> getCommDTOList();

	CommVO getComm(String co_id);

	List<PostVO> getPostList(Criteria cri);

	PageMaker getPageMaker(Criteria cri);

	PostVO getPost(String po_id);

	boolean setPost(PostVO post);

	void addViewPoint(int po_id);

	boolean modifyPost(PostVO post_new);

	boolean removePost(PostVO post, UserVO user);


}