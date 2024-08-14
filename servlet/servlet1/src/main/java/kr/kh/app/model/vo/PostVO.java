package kr.kh.app.model.vo;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostVO {

	private int po_id;
	private String po_name;
	private String po_content;
	private String po_me_id;
	private int po_co_id;
	private Date po_date;
	private int po_view;
	private int po_report;
	private int po_up;
	private int po_down;
	
	public PostVO(int co_id, String title, String content, String id) {
		this.po_co_id = co_id;
		this.po_name = title;
		this.po_content = content;
		this.po_me_id = id;
	}

	public PostVO(int po_id, String title, String content) {
		this.po_id = po_id;
		this.po_name = title;
		this.po_content = content;
	}
	
}
