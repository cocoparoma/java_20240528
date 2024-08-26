package kr.kh.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.app.model.dto.CommListDTO;
import kr.kh.app.model.vo.CommVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.pagination.Criteria;

public interface PostDAO {

	List<CommVO> getCommVOList();

	List<CommListDTO> getCommDTOList();

	CommVO getComm(@Param("co_id")String co_id);

	List<PostVO> getPostList(@Param("cri")Criteria cri);

	int getPostTotalCount(@Param("cri")Criteria cri);

	PostVO getPost(@Param("po_id")String po_id);

	boolean setPost(@Param("po")PostVO post);

	void addViewPoint(@Param("po_id")int po_id);

	boolean modPost(@Param("po")PostVO post);

	boolean removePost(@Param("po_id")int po_id);

}
