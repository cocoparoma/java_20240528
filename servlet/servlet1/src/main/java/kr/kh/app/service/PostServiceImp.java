package kr.kh.app.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.PostDAO;
import kr.kh.app.model.vo.CommentVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.FileVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.PostVO;
import kr.kh.app.model.vo.RecommendVO;
import kr.kh.app.pagination.Criteria;
import kr.kh.app.pagination.PageMaker;
import kr.kh.app.utils.FileUploadUtils;


public class PostServiceImp implements PostService{

	
	
	private PostDAO postDao;

	private String uploadPath = "D:\\uploads";
	
	public PostServiceImp() {
		String resource = "kr/kh/app/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			postDao = session.getMapper(PostDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	@Override
	public List<CommunityVO> getCommunityList() {
		
		return postDao.getCommunityList();
	}



	@Override
	public List<PostVO> getPostList(Criteria cri) {
		if (cri == null) {
			throw new RuntimeException();
		}
		
		
		return postDao.getPostList(cri);
	}



	@Override
	public CommunityVO getCommunity(int coId) {
		return postDao.selectCommunity(coId);
	}



	@Override
	public PageMaker getPageMaker(Criteria cri, int displayPageNum) {
		
		if (cri == null) {
			throw new RuntimeException();
		}
		
		int totalCount = postDao.selectPostTotalCount(cri);
		
		
		return new PageMaker(totalCount, displayPageNum, cri);
	}



	@Override
	public PostVO getPost(int poId) {
		if (poId == 0) {
			throw new RuntimeException();
		}
		
		return postDao.getPost(poId);
	}



	@Override
	public boolean insertPost(PostVO post, ArrayList<Part> files) {
		if (post == null) {
			return false;
		}
		
		if (post.getPo_name() == null || post.getPo_name().trim().length() == 0 ) {
			return false;
		}
		
		if (post.getPo_content() == null || post.getPo_content().trim().length() == 0 ) {
			return false;
		}
		
		boolean res = postDao.insertPost(post);
		
		if(!res) {
			return false;
		}
		
		if(files == null || files.size() == 0) {
			return true;
		}
		
		for(Part file : files) {
			if ("fileList".equals(file.getName())) {
				uploadFile(post.getPo_id(), file);
			}
		}
		return true;

	}
	
	
	private void uploadFile(int po_id, Part file){
		if(file == null) {
			return;
		}
		String fileName = FileUploadUtils.getFileName(file);
		System.out.println(fileName);
		
		if (fileName == null || fileName.trim().length() == 0) {
			return;
		}
		
		// 첨부파일 업로드 후 업로드 된 경로와 파일명을 가지고 옴
		String uploadFileName = FileUploadUtils.upload(uploadPath, file);
		
		// fileVO 생성
		FileVO fileVO = new FileVO(po_id, fileName, uploadFileName);
		postDao.insertFile(fileVO);
	}



	@Override
	public PostVO getPost(int poId, MemberVO user) {
		if (user == null) {
			return null;
		}
		
		PostVO post = postDao.getPost(poId);
		
		if (post == null) {
			return null;
		}
		
//		post.getPo_me_id().equals(user.getMe_id())
		if (checkWriter(poId, user)) {
			return post;
		}
		
		return null;
	}



	@Override
	public boolean updatePost(PostVO post, MemberVO user, List<Part> fileList, String[] fi_ids) {
		
		if (post == null || user == null) {
			return false;
		}
		
		if (!checkWriter(post.getPo_id(), user)) {
			return false;
		}
		if (post.getPo_name() == null || post.getPo_name().trim().length() == 0 ) {
			return false;
		}
		
		if (post.getPo_content() == null || post.getPo_content().trim().length() == 0 ) {
			return false;
		}
		
		boolean res = postDao.updatePost(post);
		
		if (!res) {
			return false;
		}
		
		
		// 새 첨부파일 추가
		for (Part file : fileList) {
			if ("fileList".equals(file.getName())) {
				uploadFile(post.getPo_id(), file);
			}
		}
		
		
		// 기존 첨부파일 삭제
		for(String id : fi_ids) {
			try {
				int fi_id = Integer.parseInt(id);
				deleteFile(fi_id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return true;
	}
	
	private void deleteFile(int fi_id) {
		
		// 첨부파일 정보를 가져오고
		FileVO file = postDao.selectFile(fi_id);
		// 서버에서 삭제
		deleteFile(file);
		// DB에서 삭제
		postDao.deleteFile(fi_id);
	}



	private boolean checkWriter (int po_id, MemberVO user) {
		if (user == null) {
			return false;
		}
		
		PostVO post = postDao.getPost(po_id);
		
		if (post == null) {
			return false;
		}
		
		
		if (post.getPo_me_id().equals(user.getMe_id())) {
			return true;
		}
		
		
		return false;
	}



	@Override
	public boolean deletePost(int po_id, MemberVO user) {
		
		if (!checkWriter(po_id, user)) {
			return false;
		}
		
		//첨부파일 삭제
		List<FileVO> fileList = postDao.selectFileList(po_id);
		
		for(FileVO file : fileList) {
			deleteFile(file);
		}
		
		
		//개시글 삭제
		return postDao.deletePost(po_id);
	}



	private void deleteFile(FileVO file) {
		if (file==null) {
			return;
		}
		File realFile = new File(uploadPath + file.getFi_name().replace('/', File.separatorChar));
		
		if (realFile.exists()) {
			realFile.delete();
		}
	}



	@Override
	public void updatePostView(int id) {
		postDao.updatePostView(id);
	}



	@Override
	public int insertRecommend(RecommendVO recommend) {
		
		if (recommend == null) {
			throw new RuntimeException();
		}
		
		RecommendVO DBcheck = postDao.selectRecommend(recommend);
		
		if (DBcheck == null) {
			postDao.insertRecommemd(recommend);
			
			return recommend.getRe_state();
		}
		
		
		postDao.deleteRecommend(DBcheck.getRe_id());
		
		
		if (DBcheck.getRe_state() == recommend.getRe_state()) {
			
			return 0;
		}
		
		postDao.insertRecommemd(recommend);
		return recommend.getRe_state();
		
		
	}



	@Override
	public RecommendVO getRecommend(int po_id, MemberVO user) {
		
		if (user == null) {
			return null;
		}
		
		RecommendVO recommend = new RecommendVO(0, po_id , user.getMe_id());
		
		RecommendVO DBcheck = postDao.selectRecommend(recommend);
		
		return DBcheck;
	}



	@Override
	public List<CommentVO> getCommentList(Criteria cri) {
		if (cri == null) {
			return null;
		}
		
		return postDao.selectCommentList(cri);
	}



	@Override
	public PageMaker getCommentPageMaker(Criteria cri) {
		if (cri == null) {
			return null;
		}
		int totalCount  = postDao.selectCommentTotalCount(cri);
		
		return new PageMaker(totalCount, 2, cri);
	}



	@Override
	public boolean insertComment(CommentVO comment) {
		if (comment == null) {
			return false;
		}
		if (comment.getCm_content() == null || comment.getCm_content().length() == 0) {
			return false;
		}
		return postDao.insertComment(comment);
	}



	@Override
	public boolean deleteComment(int co_id, MemberVO user) {
		if (user == null) {
			return false;
		}
		CommentVO comment = postDao.selectComment(co_id);
		
		if (comment == null) {
			return false;
		}
		
		if (!comment.getCm_me_id().equals(user.getMe_id())) {
			return false;
		}
		return postDao.deleteComment(co_id);
	}



	@Override
	public boolean updateComment(CommentVO comment, MemberVO user) {
		if (user == null || comment == null) {
			return false;
		}
		
		CommentVO dbComment = postDao.selectComment(comment.getCm_id());
		System.out.println(dbComment);
		if (dbComment == null) {
			System.out.println("test1");
			return false;
		}
		
		if (!dbComment.getCm_me_id().equals(user.getMe_id())) {
			System.out.println("test2");
			return false;
		}
		
	
		return postDao.updateComment(comment);
	}



	@Override
	public List<FileVO> getFileList(int id) {
		return postDao.selectFileList(id);
	}
	
}
