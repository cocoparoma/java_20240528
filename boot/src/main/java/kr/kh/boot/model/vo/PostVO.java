package kr.kh.boot.model.vo;

import java.util.Date;

import lombok.Data;

@Data
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
}
