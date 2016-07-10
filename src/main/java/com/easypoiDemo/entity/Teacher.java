package com.easypoiDemo.entity;

import java.util.List;

import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelCollection;
import org.jeecgframework.poi.excel.annotation.ExcelTarget;

@ExcelTarget("teacher")
public class Teacher extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Excel(name = "编号")
	private int id;

	@Excel(name = "教师姓名")
	private String name;

	@Excel(name = "地址")
	private String address;

	@ExcelCollection(name = "所教学生")
	private List<Student> students;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
