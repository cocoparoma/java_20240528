package day18.homework;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class Member implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;

	@Override
	public String toString() {
		return "아이디 : " + id + "/ 이름 : " + name;
	}

}
