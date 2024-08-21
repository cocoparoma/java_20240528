package kr.kh.app.pagination;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Criteria {
	protected int page = 1; // 시작페이지
	protected int perPageNum = 10; //현재 페이지의 최대 컨텐츠 수
	
	protected String search = ""; //찾는다면 기본값으로 "" 들어가있음
	
	public Criteria(int page,int perPageNum ,String search) { //생성자
		this.page = page;
		this.perPageNum = perPageNum;
		this.search = search;
	}
	public int getPageStart() { // 페이지가 시작할 곳 선택
		return (page - 1) * perPageNum;
	}
}
