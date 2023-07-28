
	package applicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AddEmpPage {
WebDriver driver;
public AddEmpPage(WebDriver driver)
{
	this.driver=driver;
}
//define Repository
@FindBy(xpath = "//b[normalize-space()='PIM']")
WebElement clickPim;
@FindBy(name="btnAdd")
WebElement clickAdd;
@FindBy(name = "firstName")
WebElement FirstName;
@FindBy(name = "middleName")
WebElement MiddleName;
@FindBy(name = "lastName")
WebElement LastName;
@FindBy(name = "employeeId")
WebElement beforeEid;
@FindBy(id = "btnSave")
WebElement clicksavebtn;
@FindBy(name = "personal[txtEmployeeId]")
WebElement Aftereid;
public boolean check_AddEmp(String FirstName,String MiddleName,String LastName)
{
	Actions ac = new Actions(driver);
	ac.moveToElement(this.clickPim).click().perform();
	ac.moveToElement(this.clickAdd).click().perform();
	this.FirstName.sendKeys(FirstName);
	this.MiddleName.sendKeys(MiddleName);
	this.LastName.sendKeys(LastName);
	String ExpectedEid =this.beforeEid.getAttribute("value");
	this.clicksavebtn.click();
	String Actualeid =this.Aftereid.getAttribute("value");
	if(ExpectedEid.equals(Actualeid))
	{
		Reporter.log("Add Emp Success::"+ExpectedEid+"    "+Actualeid,true);
		return true; 
		
	}
	else
	{
		Reporter.log("Add Emp Fail::"+ExpectedEid+"    "+Actualeid,true);
		return false;
	}
	
}
}
