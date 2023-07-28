package applicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLoginPage {
//define Repository
	@FindBy(name = "txtUsername")
	WebElement user;
	@FindBy(name = "txtPassword")
	WebElement pass;
	@FindBy(name = "Submit")
	WebElement loginbtn;
	public void check_Login(String username,String password)
	{
		user.sendKeys(username);
		pass.sendKeys(password);
		loginbtn.click();
	}
	
}
