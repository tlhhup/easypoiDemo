package com.easypoiDemo.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.junit.Test;

import com.easypoiDemo.entity.Employee;

public class ExcleImportTest {

	@Test
	public void importExcle(){
		String path="template/tt.xls";
		File file=new File(path);
		if(file.exists()){
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(file);
				ImportParams params=new ImportParams();
				//设置表头的位置
				params.setTitleRows(1);
				List<Employee> datas = ExcelImportUtil.importExcel(fis, Employee.class, params);
				if(datas!=null&&!datas.isEmpty()){
					System.out.println("数据总计："+datas.size());
					for(Employee employee:datas){
						System.out.println(employee);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if(fis!=null){
					try {
						fis.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}else{
			System.out.println("文件不存在");
		}
	}
	
}
