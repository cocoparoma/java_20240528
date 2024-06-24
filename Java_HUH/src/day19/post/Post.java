package day19.post;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Post implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1010L;
	String title;
	String post;
	String name;
	String password;
	public int veiw;
	// 게시글 번호
	private int num;
	// 게시글 번호를 생성할 때 활용
	private static int count = 0;

	@Override
	public String toString() {
		veiw++;
		return "제목 : " + title + "\n내용 : " + post + "\n작성자 : " + name + "\n조회수 :" + veiw;
	}

	public Post(String title, String post, String name, String password) {
		this.title = title;
		this.post = post;
		this.name = name;
		this.password = password;
		this.num = ++count;
	}


	public void update(String title, String post) {
		this.title = title;
		this.post = post;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return num == other.num;
	}

	@Override
	public int hashCode() {
		return Objects.hash(num);
	}


	
	
}