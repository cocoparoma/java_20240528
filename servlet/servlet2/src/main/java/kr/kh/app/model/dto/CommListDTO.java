package kr.kh.app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommListDTO {
	private int co_id;
	private String co_name;
	private int co_postCounter;
}
