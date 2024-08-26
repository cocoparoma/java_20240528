package kr.kh.app.model.vo;

import java.util.Date;

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

	
	//사용처 : comm/insert
	public PostVO(String po_name, String po_content, String me_id, int co_id) {
		this.po_name = po_name;
		this.po_content = po_content;
		this.po_me_id = me_id;
		this.po_co_id = co_id;
	}

	//사용처 : comm/update
	public PostVO(int po_id, String po_name, String po_content) {
		this.po_id = po_id;
		this.po_name = po_name;
		this.po_content = po_content;
	}

	public PostVO(String po_id, String me_id) {
		try {
			this.po_id = Integer.parseInt(po_id);
		} catch (Exception e) {
			this.po_id = 0;
		}
		this.po_me_id = me_id;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
