package db.community.model.vo;

import java.sql.Date;
import java.text.SimpleDateFormat;

import db.community.controller.PrintController;
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
	private int  po_view;
	private int po_report;
	
	
	public PostVO(int coNum, String title, String content,String id) {
		
	}

	public PostVO(int po_id, String title, String content) {
		this.po_id = po_id;
		this.po_name = title;
		this.po_content = content;
	};

	@Override
	public String toString() {
		return po_id + "번글 | [제목 : " + po_name + "] [작성자|" + po_me_id + "] [작성일|" + getPo_date() + "]"
				+ "--- [조회수 :" + po_view + "]";
	}
	
	public void print() {
		PrintController.printBar();
		System.out.println("번호 : "+ po_id);
		System.out.println("제목 : "+ po_name);
		System.out.println("작성자: " + po_me_id);
		System.out.println("작성일: " + getPo_date());
		System.out.println("조회수 : " + po_view);
		System.out.println(po_content);
		PrintController.printBar();
	}
	
	public String getPo_date() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return format.format(po_date);
	}



	
	
}
