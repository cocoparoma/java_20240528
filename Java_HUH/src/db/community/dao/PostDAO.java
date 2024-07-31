package db.community.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import db.community.model.vo.CommunityVO;
import db.community.model.vo.PostVO;

public interface PostDAO {

	CommunityVO selectCommunity(@Param("coName")String coName);

	boolean insertCommunity(@Param("coName")String coName);

	boolean updateCommunity(@Param("oldCoName")String oldCoName, @Param("newCoName")String newCoName);

	boolean deleteCommunity(@Param("coName")String coName);

	List<CommunityVO> selectCommunityList();

	boolean insertPost(@Param("po")PostVO post);

}
