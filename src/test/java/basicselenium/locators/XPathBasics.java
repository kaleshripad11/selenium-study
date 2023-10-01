package basicselenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class XPathBasics {
	/*
	 * xpath dynamic examples[https://www.saucedemo.com/] locate username field =
	 * "//input[@id='user-name' and @data-test='username']" locate username field =
	 * "//input[@id='user-name' or @data-test='username']" locate password field =
	 * "//input[contains(@data-test,'login')]"
	 * 
	 * Xpath functions - contains(), text(), start-with(), last()
	 * 
	 * Operators in xpaths - and, or
	 * 
	 * xpath axes - parent(parent) = ancestor chield(chield) = descendant
	 * 
	 * xpath axes for label "Sauce Labs Backpack"
	 * //div[@class='inventory_item_name']/parent::a
	 */
	WebDriver driver;
	
	void setBrowser() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://selectorshub.com/xpath-practice-page/");
	}
	
	void locateElementsWithXPathFunctions() {
		//contains() method will locate elements based on partial strings metioned in the xpaths
		System.out.println(driver.findElement(By.xpath("//span[@contains(text(),'how to automate')]")).getText());
		
		//driver.findElement(By.xpath("//*[@id='userId']")).sendKeys("xyz@example.com"); 
		// Use text() method to locate elements using text present in element
		System.out.println("Locate element using xpath text() method : ");
		System.out.println(driver.findElement(By.xpath("//button[text()='Users Table']")).getText());
		
		driver.findElement(By.xpath("")).click();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XPathBasics xpb = new XPathBasics();
		xpb.setBrowser();
		xpb.locateElementsWithXPathFunctions();
		xpb.driver.quit();
	}

}
