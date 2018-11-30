package kr.or.yi.mybatis_dev_HGS.dao;

import java.util.List;
import java.util.Map;

import kr.or.yi.mybatis_dev_HGS.dto.Student;

public interface StudentMapper {
	Student selectStudentByNo(Student student);
	List<Student> selectStudentByAll();
	int insertStudent(Student student);
	int updateStudent(Student student);
	int deleteStudent(int id);
	List<Student> selectStudentByAllForResultMap();
	List<Map<String, Object>> selectStudentByAllForHashMap();
	Student selectStudentByNoForResultMapExtends(Student student);
	Student selectStudentByNoForResultMapExtends2(int studId);
}
