package db.community.model.vo;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentVO {

		private int cm_id;
		private String cm_content;
		private int cm_po_id;
		private int cm_ori_id;
		private Date cm_date;
		private String cm_me_id;
		private int cm_report;
		private int cm_state;


		public CommentVO(int po_id, String id, String comment) {
			this.cm_po_id = po_id;
			this.cm_me_id = id;
			this.cm_content = comment;
		}


		@Override
		public String toString() {
			return "작성자 |" + cm_ori_id + " | 내용 : " + cm_content + "| [작성일" + cm_date + "]";
		}
		
		
}