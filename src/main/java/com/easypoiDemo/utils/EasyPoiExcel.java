package com.easypoiDemo.utils;

import java.util.Collection;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.enmus.ExcelType;
import org.jeecgframework.poi.excel.export.ExcelExportServer;

public class EasyPoiExcel {
	
	/**
	 * 导出excel
	 * @param params 导出参数设置
	 * @param clazz  javaBean对象Class
	 * @param dataSet 数据
	 */
	public static <T> Workbook exportExcel(ExportParams params,Class<? extends T> clazz,Collection<? extends T> dataSet){
		Workbook workbook=null;
		if(ExcelType.HSSF.equals(params.getType())){
			workbook=new HSSFWorkbook();
		}else if(dataSet.size()<1000){//数据量较大采用2007导出，文件小，效率高
			workbook=new XSSFWorkbook();
		}else{
			workbook=new SXSSFWorkbook();
		}
		new ExcelExportServer().createSheet(workbook, params, clazz, dataSet);
		return workbook;
	}

}
