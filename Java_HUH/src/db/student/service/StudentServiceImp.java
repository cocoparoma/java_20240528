package db.student.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.student.dao.StudentDAO;
import db.student.model.vo.StudentVO;


public class StudentServiceImp implements StudentService {

	private StudentDAO studentDao;
	
	
	public StudentServiceImp(){
		String resource = "db/student/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			studentDao = session.getMapper(StudentDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public boolean insertStudent(StudentVO std) {
		if(std == null){
			return false;
		}
		//이미등록된 학생인지 확인
		//학년, 반, 번호가 있는 학생 정보를 주면서, 학년, 반 번호와 일치하는 학생 정보를 가지고 와 달라고 요청
		StudentVO dbStd = studentDao.selectStudent(std);
		System.out.println(dbStd);
		if (dbStd != null) {
			System.out.println("[중복된 학생]");
			return false;
		}
		return studentDao.insertStudent(std);
	}


	public boolean contains(StudentVO std) {
		if (std == null) {
			return false;
		}
		StudentVO dbStd = studentDao.selectStudent(std);
		if (dbStd != null) {
			return true;
		}
		return false;
	}


	public boolean updateStudent(StudentVO std, StudentVO newStd) {
		if (std == null || newStd == null) {
			return false;
		}
		
		//기본값(key)을 가져오기 위해서 , 아직 키값이 없음
		std = studentDao.selectStudent(std);
		
		StudentVO dbStd = studentDao.selectStudent(newStd);
		if (!std.equals(dbStd)) {
			return false;
		}
		
		//새 학생 정보가 있는 학생이면 안되기에 확인
		newStd.setSt_key(std.getSt_key());
		return studentDao.updateStudent(newStd);
	}


	public boolean deleteStudent(StudentVO std) {
		if (std == null) {
			return false;
		}
		return studentDao.deleteStudent(std);
	}


	public StudentVO selectStudent(StudentVO std) {
		return studentDao.selectStudent(std);
	}
	
	
	
	
}
