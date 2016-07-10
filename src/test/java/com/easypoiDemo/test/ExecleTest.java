package com.easypoiDemo.test;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.enmus.ExcelType;
import org.junit.Test;

import com.easypoiDemo.entity.Student;
import com.easypoiDemo.entity.Teacher;
import com.easypoiDemo.utils.EasyPoiExcel;

public class ExecleTest {

	@Test
	public void export() {
		String[] addresss = { "成都", "贵阳", "北京", "武汉", "上海" };
		char[] sexs = { '男', '女' };
		Random random = new Random();
		List<Student> students = new ArrayList<Student>();
		Student student = null;
		for (int i = 0; i < 100; i++) {
			student = new Student();
			student.setAddress(addresss[random.nextInt(addresss.length)]);
			student.setAge(random.nextInt(15) + 6);
			student.setId(i);
			student.setName("小明" + i);
			student.setScore(Float.parseFloat(Math.random() * 100 + ""));
			student.setTel("123123123" + i);
			student.setSex(sexs[random.nextInt(sexs.length)]);

			students.add(student);
			student = null;
		}

		Workbook workbook = null;
		FileOutputStream fos = null;
		try {
			ExportParams params = new ExportParams("期末考试", "成绩", ExcelType.XSSF);
			workbook = EasyPoiExcel.exportExcel(params, Student.class, students);
			fos = new FileOutputStream("成绩.xls");
			workbook.write(fos);
			fos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void exportMore2One() {
		Teacher teacher=new Teacher();
		teacher.setId(1);
		teacher.setName("张三");
		teacher.setAddress("成都");
		
		String[] addresss = { "成都", "贵阳", "北京", "武汉", "上海" };
		char[] sexs = { '男', '女' };
		Random random = new Random();
		List<Student> students = new ArrayList<Student>();
		Student student = null;
		for (int i = 0; i < 50; i++) {
			student = new Student();
			student.setTeacher(teacher);
			student.setAddress(addresss[random.nextInt(addresss.length)]);
			student.setAge(random.nextInt(15) + 6);
			student.setId(i);
			student.setName("小明" + i);
			student.setScore(Float.parseFloat(Math.random() * 100 + ""));
			student.setTel("123123123" + i);
			student.setSex(sexs[random.nextInt(sexs.length)]);

			students.add(student);
			student = null;
		}

		Workbook workbook = null;
		FileOutputStream fos = null;
		try {
			ExportParams params = new ExportParams("期末考试", "成绩", ExcelType.XSSF);
			workbook = EasyPoiExcel.exportExcel(params, Student.class, students);
			fos = new FileOutputStream("成绩.xls");
			workbook.write(fos);
			fos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void exportOne2Many() {
		Teacher teacher=new Teacher();
		teacher.setId(1);
		teacher.setName("张三");
		teacher.setAddress("成都");
		
		String[] addresss = { "成都", "贵阳", "北京", "武汉", "上海" };
		char[] sexs = { '男', '女' };
		Random random = new Random();
		List<Student> students = new ArrayList<Student>();
		Student student = null;
		for (int i = 0; i < 50; i++) {
			student = new Student();
			student.setTeacher(teacher);
			student.setAddress(addresss[random.nextInt(addresss.length)]);
			student.setAge(random.nextInt(15) + 6);
			student.setId(i);
			student.setName("小明" + i);
			student.setScore(Float.parseFloat(Math.random() * 100 + ""));
			student.setTel("123123123" + i);
			student.setSex(sexs[random.nextInt(sexs.length)]);

			students.add(student);
			student = null;
		}
		
		teacher.setStudents(students);
		
		List<Teacher> teachers=new ArrayList<Teacher>();
		teachers.add(teacher);

		Workbook workbook = null;
		FileOutputStream fos = null;
		try {
			ExportParams params = new ExportParams("期末考试", "成绩", ExcelType.XSSF);
			workbook = EasyPoiExcel.exportExcel(params, Teacher.class, teachers);
			fos = new FileOutputStream("成绩.xls");
			workbook.write(fos);
			fos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
