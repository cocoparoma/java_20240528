package student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Student {

    String name;
    int grade;
    int classNumber;
    int number;
    List<Subject> subjectList = new ArrayList<Subject>();
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return classNumber == other.classNumber && grade == other.grade && number == other.number;
	}
	@Override
	public int hashCode() {
		return Objects.hash(classNumber, grade, number);
	}
	public Student(String name, int grade, int classNumber, int number) {
		this.name = name;
		this.grade = grade;
		this.classNumber = classNumber;
		this.number = number;
	}
	public void print () {
		System.out.println( grade + "학년"  + classNumber + "반 "+ number + "번 이름 : "+ name);
		System.out.println("[과목 성적]");
		if (subjectList.size() == 0) {
			System.out.println("[아직 입력되지 않았습니다.]");
			return;
		}		
		for (Subject tmp : subjectList) {
			System.out.println(tmp);
		}
		
	}
	
	
	

}
