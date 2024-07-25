package db.day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

public class DbEx02 {

	public static Statement st = null;
	public static PreparedStatement ps = null;
	public static Connection con = null;

	public static void main(String[] args) {
		/*
		 * String url = "jdbc:mysql://localhost:3306/DB명"; String id = "DB 계정"; String
		 * pw = "DB 비번";
		 */
		String db = "student";// 연결할 디비 선택
		String url = "jdbc:mysql://localhost:3306/" + db;
		String id = "root";
		String pw = "root";

		/*
		 * Connection con = null; try{ Class.forName("com.mysql.cj.jdbc.Driver"); con =
		 * DriverManager.getConnection(url, id, pw); } catch (SQLException e){
		 * System.out.println("연결 실패"); } catch (ClassNotFoundException e){
		 * System.out.println("드라이버를 찾을 수 없습니다."); }
		 */
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, id, pw);
		} catch (SQLException e) {
			System.out.println("연결 실패");
			return;
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
			return;
		}

//		 insertStudent(1, 1, 1, "김철수");
		// 메소드로 만들어도 정상동작 합니다.

		
		  if(updateStudent(1, 1, 1, 3, 3, 3, "김철수")) {
		  System.out.println("[수정 완료]"); }else { System.out.println("[수정 실패]"); }
		
		
		/*
		 *  if (deleteStudent(3,3,3)) { System.out.println("삭제 완료"); }else {
		 * System.out.println("삭제 실패"); }
		 */
		// insertStudent(2, 2, 1, "배철수");
		// insertStudent(2, 2, 2, "박영희");

		ArrayList<Student> list = selectStudent();
		if (list == null) {
			System.out.println("검색중 문제 발생");
			return;
		}
		if (list.size() == 0) {
			System.out.println("검색결과 없음");
		}
		for (Student std : list) {
			System.out.println(std);
		}

	}

	public static boolean deleteStudent(int grade, int classNum, int num) {
		if (con == null) {
			return false;
		}

		String sql = "delete from student where grade = "+ grade +" and class = "+classNum +" and num = " + num;
		
		try {
			st = con.createStatement();
			return st.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public static boolean updateStudent(int oldGrade, int oldClassNum, int oldNum, int newGrade, int newClassNum,
			int newNum, String newName) {
		if (con == null) {
			return false;
		}
		String pattern = "update student set grade = {0}, class={1}, num = {2}, name=\"{3}\" "
				+ "where grade = {4} and class = {5} and num = {6}";
		String sql = MessageFormat.format(pattern, newGrade, newClassNum, newNum, newName, oldGrade, oldClassNum, oldNum);
				try {
			st = con.createStatement();
			st.execute(sql);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public static boolean insertStudent(int grade, int classNum, int num, String name) {

		if (con == null) {
			return false;
		}
		String sql = "insert into student(grade, class, num, name) values(" + grade + ", " + classNum + ", " + num
				+ ", '" + name + "') ";

		try {
			st = con.createStatement();
			return st.execute(sql);
			// 0 이면 추가된 DB가 없는것
			// 정수값을 리턴. 반영된 값 반영된 행의 갯수를 리턴한다. 쿼리의 row 어쩌구랑 같음
			// execute : 실행하다.

		} catch (SQLException e) {
			// SQLException : 새로운 경고
			e.printStackTrace();
			return false;
		}

	}

	public static ArrayList<Student> selectStudent() {
		

		if (con == null) {
			return null;
		}

		String sql = "select studentNum, grade, class, num, name from student";
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			ArrayList<Student> list = new ArrayList<Student>();

			while (rs.next()) {
				int studentNum = rs.getInt(1);
				int grade = rs.getInt(2);
				int classNum = rs.getInt(3);
				int num = rs.getInt(4);
				String name = rs.getString(5);
				Student std = new Student(studentNum, grade, classNum, num, name);
				list.add(std);
			}

			return (ArrayList<Student>) list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}

@Data
@AllArgsConstructor
class Student2 {
	private int studentNum;
	private int grade, classNum, num;
	private String name;

	@Override
	public String toString() {
		return studentNum + ": number , " + grade + "학년," + classNum + "반 , " + num + "번호 , 이름 " + name;
	}

}
