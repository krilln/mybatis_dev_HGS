package kr.or.yi.mybatis_dev_HGS;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.mybatis_dev_HGS.dao.StudentMapper;
import kr.or.yi.mybatis_dev_HGS.dao.StudentMapperImpl;
import kr.or.yi.mybatis_dev_HGS.dto.PhoneNumber;
import kr.or.yi.mybatis_dev_HGS.dto.Student;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StudentMapperTest extends AbstractTest{

	private static StudentMapper dao = new StudentMapperImpl();
	   
	   @Test
	   public void test01selectStudentById() {
		   log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		      Student newstd = new Student();
		      newstd.setStudId(2);
		      Student searchstd =dao.selectStudentById(newstd);
		      Assert.assertEquals(newstd.getStudId(),newstd.getStudId());
	   }
	   @Test
	   public void test02selectStudentByAll() {
		   List<Student> lists = dao.selectStudentByAll();
		   Assert.assertNotNull(lists);
	   }
	   
	   @Test
	   public void test03inserStudent() {
	      Calendar newDate = GregorianCalendar.getInstance();
	      newDate.set(1990, 2, 28);
	      
	      Student student = new Student();
	      student.setName("홍길동3");
	      student.setEmail("lee@test.co.kr");
	      student.setDob(newDate.getTime());
	      student.setPhone(new PhoneNumber("010-1234-1234"));
	      
	      int res = dao.insertStudent(student);
	      Assert.assertEquals(1, res);
	   }
	   
	  /* @Test
	   public void test04updateStudent() {
	      Student student = new Student();
	      student.setStudId(10);
	      student.setName("홍길동30");
	      student.setEmail("hong@test.co.kr");
	      student.setPhone(new PhoneNumber("010-1111-2222"));
	      
	      Calendar newDate = GregorianCalendar.getInstance();
	      newDate.set(2000, 4, 28);
	      
	      student .setDob(newDate.getTime());
	      
	      int res = dao.updateStudent(student);
	      Assert.assertEquals(1, res);
	   }
	   
	   @Test
	   public void test05deleteStudent() {
	      int res = dao.deleteStudent(10);
	      Assert.assertEquals(1, res);
	   }*/
	   
	   @Test
	   public void test07selectStudentByAllForResult() {
	      List<Student> lists = dao.selectStudentByAllForResults();
	      Assert.assertNotNull(lists);
	   }
	   
	   @Test
	   public void test08selectStudentByAllForResultsMap() {
	      List<Map<String, Object>> maps = dao.selectStudentByAllForResultsMap();
	      Assert.assertNotNull(maps);
	   }
	   @Test
	   public void test09selectStudentByAllForMapper() {
		  List<Student> lists = dao.selectStudentByAllForMapper();
	      Assert.assertNotNull(lists);
	   }
	   
	   @Test
	   public void test10selectStudentByAllForResultMapExt() {
		  List<Student> lists = dao.selectStudentByAllForResultMapExt();
	      Assert.assertNotNull(lists);
	   }

}
