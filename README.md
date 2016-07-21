# easypoiDemo
easypoiDemo
EasyPoi的几个入口工具类
---------------------------
	1.ExcelExportUtil Excel导出(普通导出,模板导出)
	2.ExcelImportUtil Excel导入
	3.WordExportUtil Word导出(只支持docx ,doc版本poi存在图片的bug,暂不支持)

---------------------------
关于Excel导出XLS和XLSX区别
---------------------------

	1.导出时间XLS比XLSX快2-3倍
	2.导出大小XLS是XLSX的2-3倍或者更多
	3.导出需要综合网速和本地速度做考虑

--------------------------
注解
--------------------------
###Excel
- @ExcelTarget：设置到导出实体类上作为实体类的唯一标识
			
		@ExcelTarget("student")
		public class Student extends BaseEntity {
		
		}
- @Excel：导出基础注解-->设置到普通属性上
- @ExcelEntity：设置到导出实体类中的复合属性上
- @ExcelCollection： 标示集合
- @ExcelIgnore： 忽略字段--->去除迭代循环进入死循环
- ExportParams：导出参数设置，title(表的标题)

--------------------------
EasyPoi 模板 表达式支持
--------------------------
- 空格分割
- 三目运算  {{test ? obj:obj2}}
- n: 表示 这个cell是数值类型 {{n:}}
- le: 代表长度{{le:()}} 在if/else 运用{{le:() > 8 ? obj1 :  obj2}}
- fd: 格式化时间 {{fd:(obj;yyyy-MM-dd)}}
- fn: 格式化数字 {{fn:(obj;###.00)}}
- fe: 遍历数据,创建row
- !fe: 遍历数据不创建row 
- $fe: 下移插入,把当前行,下面的行全部下移.size()行,然后插入
- !if: 删除当前列 {{!if:(test)}}
- 单引号表示常量值 ''  比如'1' 那么输出的就是 1
- &NULL& 控制
- ]] 换行符

1. 模板导出
	1. ExcelExportUtil.exportExcel(params, map);//第二个参数为模板参数，key为模板中定义的名称  value为赋予的值
	2. {{!fe:list t.name   其中list标识在excle模板中定义的名称，将作为map传值时使用的key
	3. 注意事项：
		1. {{--->用于表示循环迭代数据开始
        2. }}--->用于表示结束


