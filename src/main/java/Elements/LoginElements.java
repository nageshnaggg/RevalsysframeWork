package Elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginElements {


	@FindBy(how = How.XPATH,using = "//*[@name='username']")
	public WebElement Username;
	@FindBy(how = How.XPATH,using = "//*[@name='password']")
	public WebElement Password;
	@FindBy(how = How.XPATH,using = "//*[text()=' Login ']")
	public WebElement LoginButton;
	@FindBy(how = How.XPATH,using = "//*[text()='Paul Collings']")
	public WebElement PaulCollings;
	@FindBy(how = How.LINK_TEXT,using = "Logout")
	public WebElement LogoutButton;
	
}
