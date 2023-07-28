package driverFactory;

import org.testng.Reporter;
import org.testng.annotations.Test;

import commonFunctions.FunctionLibrary;
import config.AppUtil;
import utilities.ExcelFileUtil;

public class Driverscript extends AppUtil {
	String inputpath= "./FileInput/Controller.xlsx";
	String ouputpath="./FileOutput/HybridResults.xlsx";
	String Tcsheet="TestCases";
	String TSSheet="TestSteps";
	private Object tcid;
	@Test
	public void starttest() throws Throwable 
	{
		boolean res =false;
		String tcres="";
		ExcelFileUtil xl= new ExcelFileUtil(inputpath);
		//count no of rows in TCsheet and tssheet
		int TCCount = xl.rowCount(Tcsheet);
		int TSCount =xl.rowCount(Tcsheet);
		Reporter.log("no of rows in TCSheet::"+TCCount+"     "+"no of rows in TSSheet::"+TSCount,true);
		//iterate all rows in TCSheet
		for (int i = 1; i < TCCount; i++)
		{
			String Module_status=xl.getCelldata(Tcsheet, i, 2);
			if (Module_status.equalsIgnoreCase("y")) 
			{
				String tcid=xl.getCelldata(Tcsheet, i, 0);	
				//iterate all rows in TSSheet
				Object String;
				for (int j = 1; j < TSCount; j++)


				{
					String tsid=xl.getCelldata(TSSheet, j, 0);
					if (tcid.equalsIgnoreCase(tsid))
					{
						String keyword= xl.getCelldata(TSSheet, j, 3);
						if (keyword.equalsIgnoreCase("adminlogin"))
						{
							String para1=xl.getCelldata(TSSheet, j, 5);
							String para2=xl.getCelldata(TSSheet, j, 6);
							res=FunctionLibrary.pBLogin(para1, para2);
						}
						else if (keyword.equalsIgnoreCase("newbranch"))
						{
							String para1=xl.getCelldata(TSSheet, j, 5);
							String para2=xl.getCelldata(TSSheet, j, 6);
							String para3=xl.getCelldata(TSSheet, j, 7);
							String para4=xl.getCelldata(TSSheet, j, 8);
							String para5=xl.getCelldata(TSSheet, j, 9);
							String para6=xl.getCelldata(TSSheet, j, 10);
							String para7=xl.getCelldata(TSSheet, j, 11);
							String para8=xl.getCelldata(TSSheet, j, 12);
							String para9=xl.getCelldata(TSSheet, j, 13);
							FunctionLibrary.pbBranches();
							res=FunctionLibrary.pbNewBranch(para1, para2, para3, para4, para5, para6, para7, para9, para9);


						}
						else if (keyword.equalsIgnoreCase("branchupdate"))
						{
							String para1=xl.getCelldata(TSSheet, j, 5);
							String para2=xl.getCelldata(TSSheet, j, 6);
							String para3=xl.getCelldata(TSSheet, j, 9);
							String para4=xl.getCelldata(TSSheet, j, 10);
							FunctionLibrary.pbBranches();
							res=FunctionLibrary.pBBranchUpdate(para1, para2, para3, para4);

						}
						else if (keyword.equalsIgnoreCase("adminlogout")) 
						{
							res=FunctionLibrary.pbLogout();

						}
						String tsres="";
						if (res)
						{
							//if res is true write as pass into TSSheet
							tsres="pass";
							xl.setcelldata(TSSheet, j, 4, tsres, tsres);

						}
						else {
							//if res is false write as fail into TSSheet
							tsres="fail";
							xl.setcelldata(TSSheet, j, 4, tsres, ouputpath);
						}
						tcres=tsres;

					}


				}
				//write as tcres into TCSheet
				xl.setcelldata(Tcsheet, i, 3, tcres, ouputpath);

			}
			else 
			{
				//write as blocked into status cell which are flag to N
				xl.setcelldata(Tcsheet, i, 3, "Blocked", ouputpath);
			}
		}
	}
}
