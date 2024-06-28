package student;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Subject implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 12312L;
	String subject;
    int sgrade;
    int semester;
    int midterm;
    int finals;
    int Performance;
    


	public Subject(String subject) {
		this.subject = subject;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		return semester == other.semester && sgrade == other.sgrade && Objects.equals(subject, other.subject);
	}



	@Override
	public int hashCode() {
		return Objects.hash(semester, sgrade, subject);
	}

	public void update (int midterm, int finals , int Performance) {
		this.midterm = midterm;
		this.finals = finals;
		this.Performance = Performance;
	}



	@Override
	public String toString() {
		return "[과목 : " + subject + "] / [학년 : " + sgrade + "] / [학기 : " + semester + "] / [ 중간 : " + midterm
				+ "] / [ 기말 : " + finals + "] / [  수행" + Performance + "] / [ 총점 : "  +getTotal() + "] " ;
	}



	private double getTotal() {
		return (double) (midterm * 0.4) + (finals * 0.5) + (Performance * 0.1);
	}

}