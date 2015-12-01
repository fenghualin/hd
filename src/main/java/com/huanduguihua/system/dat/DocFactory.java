/**
 * IPM 知识产权管理软件
 * cn.ipmsoft.common.core
 * DocFactory.java
 * 
 * 2013-8-28-上午10:19:54
 *  2013成都酷信科技公司-版权所有
 * 
 */
package com.huanduguihua.system.dat;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * 
 * 文档工厂，用于操作：excel、word、xml等等
 * 2013-8-28 上午10:19:54
 * 
 * @author KangJia
 * @version 1.0.0
 * 
 */
public class DocFactory {

	public static Excel createExcel() {
		return new DocFactory().new Excel();
	}
	
	public static File exportExcel(Excel excel, String expFile) {
		try {
			File file = new File(expFile);
			if (!file.exists()) file.createNewFile();
	        // 打开文件
	        WritableWorkbook book = Workbook.createWorkbook(file);
	        // 生成名为“第一页”的工作表，参数0表示这是第一页
	        WritableSheet sheet = book.createSheet("第一页", 0);
	      
	        if (excel.getDatas()!=null && excel.getDatas().size()>0) {
	        	
	        	int[] lineheight = new int[excel.getColumns().size()];
	        	for (int i=0; i<excel.getColumns().size(); i++) {
//	        		WritableFont font1 = new WritableFont(WritableFont.TIMES,16,WritableFont.BOLD);
//	        		WritableCellFormat format1=new WritableCellFormat(font1);
//	        		Label _label = new Label(1+i, 0, excel.getColumns().get(i).getName(),format1);
	        		Label _label = new Label(1+i, 0, excel.getColumns().get(i).getName());
	        		sheet.addCell(_label);
	        		sheet.setRowView(0,480);
	        		lineheight[i] = excel.getColumns().get(i).getName().length()*4;
	        	}
	        	
	        	for (int i=0; i<excel.getDatas().size(); i++) {
	        		Map<String, Object> data = (Map<String, Object>) excel.getDatas().get(i);
	    			for (int j=0; j<excel.getColumns().size(); j++) {
	    				String val = data.get(excel.getColumns().get(j).getMapping())==null? "" : data.get(excel.getColumns().get(j).getMapping())+"";
	    				Label _label = new Label(1+j,1+i, val);
	        			sheet.addCell(_label);
	        			int line = lineheight[j];
	        			if (val.length()*2 > line) {
	        				lineheight[j] = val.length()*2;
	        			}
	    			}
	        		Label _label = new Label(0, 1+i, i+1+"");
	        		sheet.addCell(_label);
	        		sheet.setRowView(1+i,400);
	        	}
	        	for (int i=0; i<lineheight.length; i++) {
	        		 sheet.setColumnView(i+1,lineheight[i]);
	        	}
	        }
	        // 写入数据并关闭文件
	        book.write();
	        book.close();
	        System.out.println("导出成功：" + file.getAbsolutePath());
	        return file;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public class Excel {
		private List<Map<String, Object>> datas;
		private List<Column> columns = new ArrayList<DocFactory.Excel.Column>(0);
		
		public List<Map<String, Object>> getDatas() {
			return datas;
		}
		public void setDatas(List<Map<String, Object>> datas) {
			this.datas = datas;
		}
		public List<Column> getColumns() {
			return columns;
		}
		public void setColumns(List<Column> columns) {
			this.columns = columns;
		}
		public void addColumn(Column column) {
			this.columns.add(column);
		}


		//列映射对象
		public class Column {
			private String name;
			private String mapping;
			
			public Column(String name, String mapping) {
				this.name = name;
				this.mapping = mapping;
			}
			public String getName() {
				return name;
			}
			public String getMapping() {
				return mapping;
			}
		}
	}
}
