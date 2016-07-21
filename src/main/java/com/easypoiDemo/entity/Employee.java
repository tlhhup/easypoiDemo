package com.easypoiDemo.entity;

import java.util.Date;

import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelTarget;

@ExcelTarget("Employee")
public class Employee extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Excel(name="姓名")
	private String name;
	
	@Excel(name="地址")
	private String address;

	@Excel(name="电话")
	private String tel;
	
	@Excel(name="编号")
	private String number;
	
	@Excel(name="日期",format="yyyy-MM-dd")
	private Date date=new Date();
	
	@Excel(name="性别")
	private char sex;

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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

}
