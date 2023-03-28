package Commonutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Excels.ExcelClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Utils {
	
    public static WebDriver driver;
	public static String newDateC;
	public static String newDateF;
	public static FileInputStream fii;
	public static Workbook wbb;
	public static Sheet sh;
	// static int time;
	public static DateFormat df = new SimpleDateFormat("dd MMM YYYY");
	public static Date d = new Date();
	public static String time = df.format(d);
	public static WebDriverWait Wait;
	public static Workbook wb;
	// public static ReturnOrder_Elements Elements;
	public static File file;
	public static DateFormat DateReport = new SimpleDateFormat("yyyy_MMM_dd hh_mm_ss a");
	public static Date daterep = new Date();
	public static String timereport = DateReport.format(daterep);
	public static String ModuleName;
	public static ExtentReports report = new ExtentReports(ExcelClass.filepath1);
	String baseURl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	public static ExtentTest logger = report.startTest("Report");

	public static void Reports(String ReportName, String ScriptName) {

		report = new ExtentReports(ExcelClass.filepath1 + ReportName);
		logger = report.startTest(ScriptName);
	}
	public static void captureScreenshot_pass(WebDriver driver, String ModuleName, String screenshotname, String data)
			throws IOException {
		File f1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f1,new File(ExcelClass.filepath2 + "/" + ModuleName + "/" + "/pass/" + screenshotname + "_" + time + ".png"));

		logger.log(LogStatus.PASS, "snapshot below:" + screenshotname + " ", logger.addScreenCapture(ExcelClass.filepath2 + "/" + ModuleName + "/" + "/pass/" + screenshotname + "_" + time + ".png"));
		logger.log(LogStatus.PASS, data);
		report.endTest(logger);
		report.flush();
	}

	public static void captureScreenshot_fail(WebDriver driver, String ModuleName, String screenshotname, String data) throws IOException {
		File f1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f1,new File(ExcelClass.filepath2 + "/" + ModuleName + "/" + "/fail/" + screenshotname + "_" + time + ".png"));
		logger.log(LogStatus.FAIL, "snapshot below:" + screenshotname + " ", logger.addScreenCapture(ExcelClass.filepath2 + "/" + ModuleName + "/" + "/fail/" + screenshotname + "_" + time + ".png"));
		logger.log(LogStatus.FAIL, data);
		report.endTest(logger);
		report.flush();
	}

	public static void scrollTOElement(By by, WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(by));
	}

	public static void scrollTOElement(WebElement el, WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
	}

	public static void scroll_down(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000);");
	}

	public static void scroll_up(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-1000);");
	}

	public static void scrollTo(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
	}

	public static String get_random_string() {
		return RandomStringUtils.random(15, true, false);
	}

	public static String get_random_alphaNumericString() {
		return RandomStringUtils.randomAlphanumeric(10);
	}

	public static long get_randomNumber() {
		Random rand = new Random();
		return (long) (rand.nextDouble() * 10000000000L);
	}
	public static void selectDropDownValue(WebElement locator, String type, String value) {
		Select select = new Select(locator);
		switch (type) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
		case "value":
			select.selectByValue(value);
			break;
		case "visibleText":
			select.selectByVisibleText(value);
			break;
		default:
			System.out.println("Please pass the correct selection criteria");
			break;
		}
	}
	public static int generateRandomDigits(int n) {
		int m = (int) Math.pow(10, n - 1);
		return m + new Random().nextInt(9 * m);
	}

	public static Sheet readExcelSheet(String fileLocation, int sheetNumber) {
		file = new File(fileLocation);
		try {
			wb = Workbook.getWorkbook(file);
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wb.getSheet(sheetNumber);
	}

	public static String getDate(int day, String dateFormat) {
		DateFormat dff = new SimpleDateFormat(dateFormat);
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, day);
		newDateF = dff.format(cal.getTime());
		return (newDateF);
	}

	public static String getExcelData(int postion1, int postion2, Sheet sheet) {
		return sheet.getCell(postion1, postion2).getContents();
	}

	public static void navigate(String URL) {
		driver.navigate().to(URL);
	}

	public static void logger_pass(WebDriver driver, String data) throws IOException {
		logger.log(LogStatus.PASS, data);
		report.endTest(logger);
		report.flush();
	}
	public static void logger_fail(WebDriver driver, String data) throws IOException {
		logger.log(LogStatus.FAIL, data);
		report.endTest(logger);
		report.flush();
	}
	public void baseSetup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		//driver.get("https://parabank.parasoft.com/");
		driver.manage().window().maximize();
	}
	
	public static void Thread_Sleep(long seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// APP_LOGS.error("Interrupted! " + e);
			// Restore interrupted state...
			Thread.currentThread().interrupt();
		}
	}
	
	
	@SuppressWarnings("deprecation")
	public void OpenBrowser(String browser) {
		switch (browser) {
		case "Chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--disable notifications");
			DesiredCapabilities dd=new DesiredCapabilities();
			dd.setCapability(ChromeOptions.CAPABILITY, options);
			options.merge(dd);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			//driver.get(baseURl);
			break;
		case "ff":
			WebDriverManager.firefoxdriver().create();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		//	driver.get(baseURl);
			break;
		case "Edge":
			WebDriverManager.edgedriver().create();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			//driver.get(baseURl);
			break;
		}
	}
	
	

}
