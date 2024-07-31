package db.community.service;

import java.util.List;

import db.community.model.vo.CommunityVO;
import db.community.model.vo.PostVO;

public interface PostService {

	boolean insertCommunity(String coName);

	boolean updateCommunity(String oldCoName, String newCoName);

	boolean deleteCommunity(String coName);

	boolean insertPost(int coid, String title, String content, String meid);

	boolean insertPost(PostVO post);

	List<CommunityVO> getCommunityList();

}
