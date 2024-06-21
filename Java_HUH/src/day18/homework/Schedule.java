package day18.homework;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Schedule {
	private String date;
	private String todo;
	private String detail;
	
	
	@Override
	public String toString() {
		return "날짜 : " + date + "\n"
				+ "일정 : " + todo + "\n"
						+ "상세 : " + detail;
	}
	
	
	
	
	
}
