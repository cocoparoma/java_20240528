package kr.kh.app.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RecommendVO {
	
	private int re_id;
	private int	re_state;
	private int re_po_id;
	private String re_me_id;
	
	public RecommendVO(int re_id, int re_state, int re_po_id, String re_me_id){
		
		this.re_id = re_id;
		this.re_state = re_state;
		this.re_po_id = re_po_id;
		this.re_me_id = re_me_id;
		
	}
	
	
	public RecommendVO(int re_state, int re_po_id, String re_me_id){
		
		this.re_state = re_state;
		this.re_po_id = re_po_id;
		this.re_me_id = re_me_id;
		
	}
	
}
