package kr.or.yi.mybatis_dev_HGS.dao;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.yi.mybatis_dev_HGS.dto.Student;
import kr.or.yi.mybatis_dev_HGS.jdbc.MyBatisSqlSessionFactory;

public class StudentMapperImpl implements StudentMapper {

	private static final String namespace = "kr.or.yi.mybatis_dev_HGS.dao.StudentMapper";
	   @Override
	   public Student selectStudentById(Student student) {
	      try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
	         return sqlSession.selectOne(namespace+".selectStudentById",student );
	      }
	   }

	   @Override
	   public List<Student> selectStudentByAll() {
	      try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
	         return sqlSession.selectOne(namespace+".selectStudentByAll");
	      }

	   }
}
