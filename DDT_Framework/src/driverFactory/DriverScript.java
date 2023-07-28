package driverFactory;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.Test;

import commonFunctions.FunctionLibrary;
import config.AppUtil;
import utilities.ExcelFileUtil;

public class DriverScript extends AppUtil {
	String inputpath = "./FileInput/Logindata.xlsx";
	String outputpath="./FileOutput/DataDrivenResults.xlsx";
	@Test
	public void StartTest() throws Throwable
	{
		//create Referenced object for Excelfile util
		ExcelFileUtil xl= new ExcelFileUtil(inputpath);
		//count no of row in login sheet
		int rc=xl.rowCount("login");
		Reporter.log("no of rows are::"+rc,true);

		//iterate all rows in login sheet
		for (int i = 1; i <= rc; i++) 
		{
			//read username and password cells
			String user=xl.getCelldata("Login", i, 0);
			String pass=xl.getCelldata("Login", i, 1);
			//call login method
			boolean res = FunctionLibrary.check_login(user, pass);

			if (res) 
			{
				//write as login sucess into results cell
				xl.setcelldata("Login", i, 2, "Login sucess",outputpath);
				xl.setcelldata("Login", i, 3, "pass", outputpath);

			}
			else
			{
				File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screen, new File("./screenshot/iteraton/"+i+"Loginpage.png"));
				//if res is true capture error message and write into results cell
				String Error_Message= driver.findElement(By.xpath(conpro.getProperty("objErrormessage"))).getText();
				xl.setcelldata("Login", i, 2,Error_Message, outputpath);
				xl.setcelldata("Login", i, 3, "fail", outputpath);


			}

		}			
	

	}
	}








