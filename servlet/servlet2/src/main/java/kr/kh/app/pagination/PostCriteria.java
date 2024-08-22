package kr.kh.app.pagination;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostCriteria extends Criteria {

	private String co_id;
	private String type="";
	
	public PostCriteria(String co_id, String pageStr, String search, String type, int perPageNum) {
		int page;
		try {
			page = Integer.parseInt(pageStr);
		}catch(Exception e) {
			page = 1;
		}
		this.search = search == null ? "" : search;
		this.type = type == null ? "" : type;
		this.co_id = co_id;
		this.page = page;
		this.perPageNum = perPageNum;
	}
}