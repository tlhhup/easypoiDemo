package com.easypoiDemo.entity;

import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelEntity;
import org.jeecgframework.poi.excel.annotation.ExcelIgnore;
import org.jeecgframework.poi.excel.annotation.ExcelTarget;

@ExcelTarget("student")
public class Student extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Excel(name = "编号")
	private int id;

	@Excel(name = "姓名")
	private String name;

	@Excel(name = "地址")
	private String address;

	@Excel(name = "联系电话")
	private String tel;

	@Excel(name = "年龄")
	private int age;

	@Excel(name = "成绩")
	private float score;

	@Excel(name = "性别")
	private char sex;

	@ExcelIgnore
	@ExcelEntity
	private Teacher teacher;

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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}
