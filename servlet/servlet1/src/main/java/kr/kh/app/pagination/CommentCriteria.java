package kr.kh.app.pagination;

public class CommentCriteria extends Criteria{
	


	private int po_id;
	
	
	public CommentCriteria(int page, int perPageNum, int po_id) {
		this.page = page;
		this.perPageNum = perPageNum;
		this.po_id = po_id;
	}
}
