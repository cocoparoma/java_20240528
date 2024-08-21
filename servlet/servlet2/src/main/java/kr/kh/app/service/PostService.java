package kr.kh.app.service;

import java.util.List;

import kr.kh.app.model.dto.CommListDTO;
import kr.kh.app.model.vo.CommVO;

public interface PostService {

	List<CommVO> getCommVOList();

	List<CommListDTO> getCommDTOList();

	CommVO getComm(String co_id);

}