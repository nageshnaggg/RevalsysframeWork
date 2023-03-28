package Testcases;

import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Commonutils.Utils;
import Elements.LoginElements;
import Excels.ExcelClass;
import jxl.Sheet;

public class Hrms extends Utils{
	public LoginElements elements;
	public Sheet s;
	public String baseURl = "https://opensource-demo.orangehrmlive.com";
	@BeforeClass
	public void setUp() {
		OpenBrowser("Chrome");
		Utils.ModuleName = "Login";
		Utils.Reports("login.html", "Store");
		s = Utils.readExcelSheet(ExcelClass.filepath3 + "Login.xls", 0);
		elements = PageFactory.initElements(driver, LoginElements.class);
	}

	@Test(priority = 0)
	public void Tc_001() throws IOException {
		Utils.Thread_Sleep(5);
		for(int i=0;i<5;i++) {
			driver.get(baseURl);
			Utils.Thread_Sleep(5);
			elements.Username.sendKeys(Utils.getExcelData(0, i, s));
			Utils.Thread_Sleep(5);
			elements.Password.sendKeys(Utils.getExcelData(1, i, s));
			Utils.Thread_Sleep(5);
			elements.LoginButton.click();
			Utils.Thread_Sleep(5);
			elements.PaulCollings.click();
			Utils.Thread_Sleep(5);
			Actions a =new Actions(driver);
			a.click(elements.LogoutButton).build().perform();
		}
	}
}
