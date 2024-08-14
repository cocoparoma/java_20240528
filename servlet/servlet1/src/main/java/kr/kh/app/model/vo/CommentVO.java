package kr.kh.app.model.vo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentVO {
	private int cm_id;
	private String cm_content;
	private int cm_po_id;
	private int cm_ori_id;
	private Date cm_date = new Date();
	private String cm_me_id;
	private int cm_report;
	private int cm_state;

	public String getCm_date() {
		if(isToday()) {
			SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
			return format.format(cm_date);
		}else {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return format.format(cm_date);
		}
	}
	public boolean isToday() {
		
		
		Calendar today = Calendar.getInstance();
		Calendar date = Calendar.getInstance();
		
		
		date.setTime(cm_date);
		
		if(today.get(Calendar.YEAR) != date.get(Calendar.YEAR)) {
			return false;
		}
		
		if(today.get(Calendar.MONTH) != date.get(Calendar.MONTH)) {
			return false;
		}
		
		if(today.get(Calendar.DAY_OF_MONTH) != date.get(Calendar.DAY_OF_MONTH)) {
			return false;
		
		}
		return true;
	}


	public CommentVO(int cm_po_id, int cm_ori_id, String cm_content, String cm_me_id) {
		this.cm_po_id=cm_po_id;
		this.cm_ori_id = cm_ori_id;
		this.cm_content = cm_content;
		this.cm_me_id = cm_me_id;
		
	}


	public CommentVO(int cm_id, String cm_content) {
		this.cm_id = cm_id;
		this.cm_content = cm_content;
	}
	
}
