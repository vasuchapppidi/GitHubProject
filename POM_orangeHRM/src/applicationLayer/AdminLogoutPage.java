package applicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogoutPage {
@FindBy(xpath = "//a[@id='welcome']")
WebElement clickWelcome;
@FindBy(xpath = "//a[normalize-space()='Logout']")
WebElement clickLogout;
public void check_Logout()
{
	clickWelcome.click();
	clickLogout.click();
}
}


