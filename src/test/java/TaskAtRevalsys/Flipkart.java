package TaskAtRevalsys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Commonutils.Utils;
import Elements.PdpPageElements;

public class Flipkart extends Utils {
	public PdpPageElements Element;
	public Utils commonutils;
	@BeforeClass
	public void setUp() {
		baseSetup();
		Element = PageFactory.initElements(driver, PdpPageElements.class);
	}

	@Test
	public void FlipkartAutomationTest() {
		Thread_Sleep(3);
		Element.Closebtn.click();
		Thread_Sleep(3);
		WebElement fashionBtn = Element.fashion_menu;
		Thread_Sleep(3);
		Actions a = new Actions(driver);
		a.click(fashionBtn).build().perform();
		Thread_Sleep(3);
		WebElement mainmenu = Element.Main_Menu_btn;
		Actions a2 = new Actions(driver);
		a2.click(mainmenu).build().perform();
		Thread_Sleep(3);
		Element.Tshirts.click();
		Thread_Sleep(3);
		List<WebElement> allpricesofTshirts = Element.TshirtsPrice;
		Thread_Sleep(3);
		System.out.println("all prices of Tshirts" + allpricesofTshirts.size());
		Thread_Sleep(3);
		Utils.scrollTOElement(Element.PriceElement, driver);
		Thread_Sleep(3);
		Actions a3=new Actions(driver);
		a3.dragAndDropBy(Element.Slider, 200, 0).build().perform();
		/*Iterator<WebElement> list = allpricesofTshirts.iterator();
		Thread_Sleep(3);
		ArrayList<Integer> myNumbers = new ArrayList<Integer>();
		while (list.hasNext()) {
			// System.out.println(list.next().getText());
			String product_details = list.next().getText();
			System.out.println("Price" + product_details);
			product_details = product_details.replace("₹", "");
			product_details = product_details.replace(",", "");
			Thread_Sleep(3);
			int productprice = Integer.parseInt(product_details);
			Thread_Sleep(3);
			myNumbers.add(productprice);
		//	String[] split_details = product_details.split("?");
		//	String req_price = split_details[1];
		//	System.out.println("price of product" + req_price);
		}
		System.out.println(myNumbers);
		Integer least = Collections.max(myNumbers);
		Thread_Sleep(3);
		System.out.println("the least price is" + least);
		int leastprice = myNumbers.indexOf(least);
		List<WebElement> ele1 = Element.TshirtsPrice;
		String LeastpriceproductName = ele1.get(leastprice).getText();
		ele1.get(leastprice).click();
		System.out.println("this is least product name" + LeastpriceproductName);
	}
	*/
	
}}
