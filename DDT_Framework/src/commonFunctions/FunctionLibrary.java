package commonFunctions;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import config.AppUtil;

public class FunctionLibrary  extends AppUtil{
	public static boolean check_login(String username,String password)

	{
		driver.get(conpro.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(conpro.getProperty("objuser"))).sendKeys("username");
		driver.findElement(By.xpath(conpro.getProperty("objpass"))).sendKeys("password");
		driver.findElement(By.xpath(conpro.getProperty("objlogin"))).click();
		String  Expected = "dashboard";
	String Actual=driver.getCurrentUrl();
	if (Actual.contains(Expected)) {
		return true;
		
		
	}
	else
	{
		return false;
	}
	}
}