package kr.kh.app.pagination;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class PostCriteria extends Criteria {

	private int co_id;
	private String type;
	
	public PostCriteria(int page, int perPageNum, String search, int co_id, String type) {
		super(page, perPageNum, search);
		this.co_id = co_id;
		this.type  = type;
	}
}
