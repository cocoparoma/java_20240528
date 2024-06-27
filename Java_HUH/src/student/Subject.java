package student;

import java.util.Objects;

import lombok.Data;

@Data
class Subject {

    String subject;
    int sgrade;
    int semester;
    int midterm;
    int finals;
    int Perfomace;
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		return finals == other.finals && midterm == other.midterm && Objects.equals(subject, other.subject);
	}
	@Override
	public int hashCode() {
		return Objects.hash(finals, midterm, subject);
	}


}