package Elements;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PdpPageElements {
	
@FindBy(how=How.XPATH,using="//div[@class='_2QfC02']/button")
public WebElement Closebtn;

@FindBy(how=How.XPATH,using="//img[@alt='Fashion']")
public WebElement fashion_menu;

@FindBy(how=How.XPATH,using="//*[text()='Men']")
public WebElement Main_Menu_btn;

@FindBy(how=How.XPATH,using="//*[text()='T-Shirts']")
public WebElement Tshirts;


@FindBy(how=How.XPATH,using="//*[@class='_30jeq3']")
public List<WebElement> TshirtsPrice;

@FindBy(how=How.XPATH,using="(//*[text()='Price'])[1]")
public WebElement PriceElement;

@FindBy(how=How.XPATH,using="//*[@class='_12FhcQ']")
public WebElement Slider;


}
