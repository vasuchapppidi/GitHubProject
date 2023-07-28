package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import applicationLayer.AddEmpPage;
import config.AppUtil;
import utilities.ExcelFileUtil;

public class TestScript extends AppUtil {
	String inputpath ="./FileInput\\EMP.xlsx";
	String outputpath ="./FileOutput/DataDrivenResults.xlsx";
	@Test
	public void startTest()throws Throwable
	{
		ExcelFileUtil xl = new ExcelFileUtil(inputpath);
		int rc =xl.rowCount("Emp");
		Reporter.log("No of rows are::"+rc,true);
		for(int i=1;i<=rc;i++)
		{
			String fname = xl.getCelldata("Emp", i, 0);
			String mname = xl.getCelldata("Emp", i, 1);
			String lname = xl.getCelldata("Emp", i, 2);
			AddEmpPage employee =PageFactory.initElements(driver, AddEmpPage.class);
			boolean res =employee.check_AddEmp(fname, mname, lname);
			if(res)
			{
				xl.setcelldata("Emp", i, 3, "Pass", outputpath);
				
			}
			else
			{
				xl.setcelldata("Emp", i, 3, "Fail", outputpath);
			}
		}
		}
	}

	



