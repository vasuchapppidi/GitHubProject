package config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import applicationLayer.AdminLoginPage;
import applicationLayer.AdminLogoutPage;

public class AppUtil {
public static WebDriver driver;
@BeforeTest
public static void setUp() throws Throwable
{
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://orangehrm.qedgetech.com/");
	Thread.sleep(5000);
	AdminLoginPage login =PageFactory.initElements(driver, AdminLoginPage.class);
	login.check_Login("Admin", "Qedge123!@#");
}
@AfterTest
public static void tearDown()
{
	AdminLogoutPage logout =PageFactory.initElements(driver, AdminLogoutPage.class);
	logout.check_Logout();
	driver.quit();
}
}
