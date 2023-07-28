package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileUtil
{
	
	XSSFWorkbook wb;
	//constructor for reading excel path
	public ExcelFileUtil(String Excelpath) throws Throwable

	{
		FileInputStream fi = new FileInputStream(Excelpath);
		wb = new XSSFWorkbook(fi);
	}

	//method for counting no of rows in a sheet

	public int rowCount(String sheetname)
	{
		return wb.getSheet(sheetname).getLastRowNum();

	}
	//methods for counting no of cells in a first row
	public int cellcount(String sheetname)
	{
		return wb.getSheet(sheetname).getRow(0).getLastCellNum();
	}
	//read cell data from sheet
	@SuppressWarnings("deprecation")
	public String getCelldata(String sheetname,int row ,int column) {
		String data="";
		if (wb.getSheet(sheetname).getRow(row).getCell(column).getCellType()==Cell.CELL_TYPE_NUMERIC)
		{
			int celldata = (int) wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();		}

		return data;


	}
	//set cell data
	public void setcelldata(String sheename,int row,int column,String status,String writeExcel) throws IOException
	{
		//get sheet from wb
		XSSFSheet ws = wb.getSheet(sheename);
		//get row from sheet
		XSSFRow  rownum = ws.getRow(row);
		//create cell
		XSSFCell cell = rownum.createCell(column);
		//write status
		cell.getStringCellValue();
		if (status.equalsIgnoreCase("pass"))
		{
			XSSFCellStyle style = wb.createCellStyle();
			XSSFFont font = wb.createFont();
			font.setColor(IndexedColors.GREEN.getIndex());
			font.setBold(true);
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			style.setFont(font);
			ws.getRow(row).getCell(column).getCellStyle();
		}
		else if(status.equalsIgnoreCase("fail"))
		{
			XSSFCellStyle style = wb.createCellStyle();
			XSSFFont font =wb.createFont();
			font.setColor(IndexedColors.RED.getIndex());
			font.setBold(true);
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			style.setFont(font);
			ws.getRow(row).getCell(column).getCellStyle();
		}
		else if(status.equalsIgnoreCase("Blocked"))
		{
			XSSFCellStyle style = wb.createCellStyle();
			XSSFFont font =wb.createFont();
			font.setColor(IndexedColors.BLUE.getIndex());
			font.setBold(true);
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			style.setFont(font);
			ws.getRow(row).getCell(column).getCellStyle();
		}
		FileOutputStream fo = new FileOutputStream(writeExcel);
		wb.write(fo);

		}
	}









