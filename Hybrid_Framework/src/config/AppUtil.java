package config;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class AppUtil {
	public static Properties conpro;
	public static WebDriver driver;


	
	@BeforeSuite
	public static void setup()throws Throwable
	{
		conpro = new Properties();
		conpro.load(new FileInputStream("./PropertyFile/Envirnonment.properties"));
		if (conpro.getProperty("Browser").equalsIgnoreCase("chrome"));
		{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(conpro.getProperty("Url"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		}
		elseif (conpro.getProperty("Browser").equalsIgnoreCase("firefox"));
		{
			driver = new ChromeDriver();

			driver.get(conpro.getProperty("Url"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}
		
		{
			Reporter.log("Browser value is not matching ",true);	
		}
		

	}

	private static void elseif(boolean equalsIgnoreCase) {
		// TODO Auto-generated method stub
		
	}

	@AfterSuite
	public static void teardown()
	{
		driver.quit();
	}
}

