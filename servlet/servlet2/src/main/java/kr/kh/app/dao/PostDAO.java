package kr.kh.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.app.model.dto.CommListDTO;
import kr.kh.app.model.vo.CommVO;

public interface PostDAO {

	List<CommVO> getCommVOList();

	List<CommListDTO> getCommDTOList();

	CommVO getComm(@Param("co_id")String co_id);

}
