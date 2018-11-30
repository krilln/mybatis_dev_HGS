package kr.or.yi.mybatis_dev_HGS;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.mybatis_dev_HGS.dao.StudentMapper;
import kr.or.yi.mybatis_dev_HGS.dao.StudentMapperImpl;
import kr.or.yi.mybatis_dev_HGS.dto.PhoneNumber;
import kr.or.yi.mybatis_dev_HGS.dto.Student;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentMapperTest extends AbstractTest {
	private StudentMapper dao = new StudentMapperImpl();
	@Test
	public void test01selectStudentByNo() {
		log.debug("test01selectStudentByNo()");
		Student searchStd = new Student();
		searchStd.setStudId(1);
		
		Student searchedStd = dao.selectStudentByNo(searchStd);
		Assert.assertNotNull(searchedStd);
	}
	@Test
	public void test02selectStudentByAll() {
		log.debug("test02selectStudentByAll()");
		List<Student> lists = dao.selectStudentByAll();
		Assert.assertNotNull(lists);
	}
	
	@Test
	public void test03insertStudent() {
		log.debug("test01insertStudent()");
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1990, 2, 28);
		Student student = new Student();
		student.setStudId(3);
		student.setName("홍길동4");
		student.setEmail("lee4@test.co.kr");
		student.setDob(newDate.getTime());
		student.setPhone(new PhoneNumber("010-1234-1234"));
		int res = dao.insertStudent(student);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test04updateStudent() {
		log.debug("test04updateStudent()");
		Student student = new Student();
		student.setStudId(1);
		student.setName("Timothy");
		student.setEmail("test@test.co.kr");
		student.setDob(new Date());
		student.setPhone(new PhoneNumber("987-654-3211"));
		
		int result = dao.updateStudent(student);
		Assert.assertSame(1, result);
		
		student.setEmail("timothy@gmail.com");
		student.setPhone(new PhoneNumber("123-123-1234"));
		student.setDob(new GregorianCalendar(1988, 04, 25).getTime());
		result = dao.updateStudent(student);
		Assert.assertSame(1, result);
	}
	@Test
	public void test06deleteStudent() {
		log.debug("test05deleteStudent()");
		int deleteStudent = dao.deleteStudent(3);
		Assert.assertSame(1,deleteStudent);
	}
	
	@Test
	public void test07selectStudentByAllForResultMap() {
		log.debug("test07selectStudentByAllForResultMap()");
		List<Student> lists = dao.selectStudentByAllForResultMap();
		Assert.assertNotNull(lists);
	}
	
	@Test
	public void test08selectStudentByAllForHashMap() {
		log.debug("test07selectStudentByAllForResultMap()");
		List<Map<String, Object>> lists = dao.selectStudentByAllForHashMap();
		
		System.out.println("lists.size() => " + lists.size());
		for(int i=0; i<lists.size(); i++) {
			Map<String, Object> m =lists.get(1);
			Iterator<String> it = m.keySet().iterator();
			while(it.hasNext()) {
				String key = it.next();
				System.out.println("key = " + key + "value = " + m.get(key));
			}
		}
		
		for(Map<String, Object> m : lists) {
			for(Entry<String, Object> e : m.entrySet()) {
				log.debug(String.format("\tkey(%s)-value(%s)",e.getKey(), e.getValue()));
			}
			System.out.println();
		}
		Assert.assertNotNull(lists);
	}
	@Test
	public void test09selectStudentByNoForResultMapExtends() {
		log.debug("test09selectStudentByNoForResultMapExtends()");
		Student student = new Student();
		student.setStudId(1);
		Student extStd = dao.selectStudentByNoForResultMapExtends(student);
		Assert.assertNotNull(extStd);
	}
	
	@Test
	public void test10selectStudentByNoForResultMapExtends2() {
		log.debug("test10selectStudentByNoForResultMapExtends2()");
		Student lists = dao.selectStudentByNoForResultMapExtends2(1);
		Assert.assertNotNull(lists);
	}
}
