package kr.or.yi.mybatis_dev_HGS;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import kr.or.yi.mybatis_dev_HGS.dao.StudentMapper;
import kr.or.yi.mybatis_dev_HGS.dao.StudentMapperImpl;
import kr.or.yi.mybatis_dev_HGS.dto.Student;

public class StudentMapperTest extends AbstractTest{

	private static StudentMapper dao = new StudentMapperImpl();
	   
	   @Test
	   public void test01selectStudentById() {
	      log.debug("test01selectStudentById()");
	      Student newStd = new Student();
	      newStd.setStudId(1);
	      
	      Student searchStd = dao.selectStudentById(newStd);
	      
	      Assert.assertEquals(newStd.getStudId(), searchStd.getStudId());
	   }
	   
	   public void test02selectStudentByAll() {
		   List<Student> lists = dao.selectStudentByAll();
		   Assert.assertNotNull(lists);
	   }

}
