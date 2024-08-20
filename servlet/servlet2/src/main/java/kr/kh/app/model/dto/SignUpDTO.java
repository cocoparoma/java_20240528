package kr.kh.app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDTO {
	//회원가입 시 아이디와 비번 체크용
	private String me_id ="";
	private String me_pw ="";
	private String me_email ="";
}
