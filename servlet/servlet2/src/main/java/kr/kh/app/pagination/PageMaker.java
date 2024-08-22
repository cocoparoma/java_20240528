package kr.kh.app.pagination;

import lombok.Data;

@Data
public class PageMaker {

	private int startPage;//페이지네이션의 시작 번호  -- auto
	private int endPage;//페이지네이션의 마지막 번호 -- auto
	private int totalCount;//전체 컨텐츠 수 => endPage 계산 때문에 -- db에서 카운트로 가져와야함
	private int displayPageNum;//한 페이지네이션의 최대 페이지 개수 -- 하고싶은대로 지정
	private boolean prev;//이전 버튼 활성화 -- auto
	private boolean next;//다음 버튼 활성화 -- auto
	private Criteria cri;//현재 페이지 정보 -- 만들어서 가져다 주셈
	
	//시작 페이지, 마지막 페이지, 이전 버튼 활성화 여부, 다음 버튼 활성화 여부를 계산하는 메소드
	// 우리가 챙겨야할 것 totalCount(db에서 가져오기), displayPageNum(마음가는대로 지정) cri = 현제 페이지 정보 다 때려넣으셈

	public void calculte() {
		//마지막 페이지 번호를 계산 => 최대 페이지 번호
		endPage = (int)(Math.ceil(cri.getPage()/(double)displayPageNum) * displayPageNum);
		
		startPage = endPage - displayPageNum + 1;
		//마지막 페이지네이션에서 마지막 페이지 번호
		int lastEndPage = (int)(Math.ceil(totalCount / (double)cri.getPerPageNum()));
		
		if(endPage > lastEndPage) {
			endPage = lastEndPage;
		}
		prev = startPage == 1 ? false : true;
		next = endPage == lastEndPage ? false : true;
	}

	public PageMaker(int totalCount, int displayPageNum, Criteria cri) {
		this.totalCount = totalCount;
		this.displayPageNum = displayPageNum;
		this.cri = cri;
		calculte();
	}
	
}
