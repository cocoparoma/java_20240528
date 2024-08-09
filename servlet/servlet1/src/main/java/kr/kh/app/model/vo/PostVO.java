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
	
	
}
