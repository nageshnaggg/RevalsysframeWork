package Elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterElements {
	@FindBy(how = How.XPATH,using = "//*[text()='Register']")
	public WebElement Register_Link;
	
	@FindBy(how = How.XPATH,using = "//input[@id='customer.firstName']")
	public WebElement FirstName_TextField;
	
//	@FindBy(how = How.XPATH,using = "//span[text()='Login']")
//	public WebElement Login;
//	
//	@FindBy(how = How.XPATH,using = "//*[@id='ctl00_ContentPlaceHolder1_chkIsPublished']")
//	public WebElement publish_btn;
//	
}
