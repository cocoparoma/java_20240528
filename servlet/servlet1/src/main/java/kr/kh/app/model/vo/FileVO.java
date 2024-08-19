package kr.kh.app.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FileVO {
	private int fi_id;
	private String fi_ori_name;
	private String fi_name;
	private int fi_po_id;
	
	
	
	public FileVO(int po_id, String fileName, String uploadFileName) {
		this.fi_po_id = po_id;
		this.fi_ori_name = fileName;
		this.fi_name = uploadFileName;
	}
	
	
}
