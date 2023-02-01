package Testcases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Commonutils.Utils;
import Elements.RegisterElements;
import Excels.ExcelClass;
import jxl.Sheet;

public class RegisterPageTestcases extends Utils {

	public RegisterElements elements;
	public Sheet s;

	@BeforeClass
	public void setUp() {
		baseSetup();
		Utils.ModuleName = "Rigster";
		Utils.Reports("Register.html", "Store");
		s = Utils.readExcelSheet(ExcelClass.filepath3 + "RegisterData.xls", 0);
		elements = PageFactory.initElements(driver, RegisterElements.class);
	}

	@Test(priority = 0)
	public void Tc_001() throws IOException {
		try {
			if (elements.Register_Link.isDisplayed()) {

				captureScreenshot_pass(driver, "RegiserModule", "Tc_001", "RigisterLink is displaying");
				System.out.println("RigisterLink is displaying");

			}
		} catch (Exception e) {
			captureScreenshot_fail(driver, "RegiserModule", "Tc_001", "RigisterLink is displaying");
			System.out.println("RigisterLink is not displaying");

		}
	}

	@Test(priority = 1)
	public void Tc_002() throws IOException, InterruptedException {
		Thread.sleep(2000);
		elements.Register_Link.click();
		try {
			if (elements.FirstName_TextField.isDisplayed()) {

				captureScreenshot_pass(driver, "RegiserModule", "Tc_002","FirstName_TextField is displaying");
				System.out.println("FirstName_TextField is displaying");

			}
		} catch (Exception e) {
			captureScreenshot_fail(driver, "RegiserModule", "Tc_002", "FirstName_TextField is displaying");
			System.out.println("FirstName_TextField is not displaying");
		}
	}

	@Test(priority = 2)
	public void Tc_003() throws IOException, InterruptedException {
		Thread.sleep(2000);
		elements.FirstName_TextField.sendKeys(Utils.getExcelData(0, 1, s));
		Thread.sleep(2000);
		String name = elements.FirstName_TextField.getAttribute("Value");
		System.out.println("text"+name);
		Thread.sleep(2000);
		try {
			if (name.contains("Venkatesh")) {

				captureScreenshot_pass(driver, "RegiserModule", "Tc_003","FirstName_TextField is Accepting Alphabets");
				System.out.println("FirstName_TextField is Accepting Alphabets");
			}
		} catch (Exception e) {
			captureScreenshot_fail(driver, "RegiserModule", "Tc_003", "FirstName_TextField is not Accepting Alphabets");
			System.out.println("FirstName_TextField is not Accepting Alphabets");

		}
	}
}
