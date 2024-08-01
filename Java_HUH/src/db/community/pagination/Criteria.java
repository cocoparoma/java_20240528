package db.community.pagination;

import lombok.Data;
import lombok.NoArgsConstructor;

//현제 페이지 정보를 나타네는 클래스
@Data
@NoArgsConstructor
public class Criteria {
	
	private int page = 1;//명시적 초기화
	private int perPageNum = 5;// 현 페이지의 최대 콘텐츠 수
	private String search = "";

	
	public Criteria(int page, String search) {
		this.page = page;
		this.search = search;
	}
	
	public int getPageStart() {
		return (page - 1) * perPageNum;
	}
	
}
