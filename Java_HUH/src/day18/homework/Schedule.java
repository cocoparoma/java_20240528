package day18.homework;

import java.util.Objects;

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
		return "날짜 : " + date + "\n" + "일정 : " + todo + "\n" + "상세 : " + detail;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Schedule other = (Schedule) obj;
		return Objects.equals(date, other.date) && Objects.equals(detail, other.detail)
				&& Objects.equals(todo, other.todo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, detail, todo);
	}

}
