package com.easypoiDemo.test;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.apache.poi.ss.usermodel.Workbook;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.junit.Test;

import com.easypoiDemo.entity.Employee;

public class ExecleTemplateExport {

	@Test
	public void export(){
		String[] addresss={"成都","贵阳","北京","湖南"};
		String[] sexs={"男","女"};
		List<Employee> employees=new ArrayList<Employee>();
		Employee employee=null;
		Random random=new Random();
		for(int i=0;i<50;i++){
			employee=new Employee();
			employee.setName("这个是第"+i+"条数据");
			employee.setAddress(addresss[random.nextInt(addresss.length)]);
			employee.setNumber(UUID.randomUUID().toString());
			employee.setSex(sexs[random.nextInt(sexs.length)]);
			employee.setTel(random.nextInt(100000)+"");
			employees.add(employee);
			employee=null;
		}
		String templateUrl="template/员工模板.xls";
		TemplateExportParams params=new TemplateExportParams(templateUrl, 0);
		//map对应的是模板参数
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("title", "员工信息表");
		
		//设置集合数据 其中list为在模板中定义的 fe 后面的值
		map.put("list", employees);
		try {
			//采用实体类加入注解的方式用于导出集合数据
//			Workbook workbook = ExcelExportUtil.exportExcel(params,Employee.class,employees, map);
			Workbook workbook = ExcelExportUtil.exportExcel(params, map);
			FileOutputStream fos = new FileOutputStream("template/tt.xls");
			workbook.write(fos);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
