package basicselenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumLocators {
	/*
	 * Selenium locators are the methods in selenium. 
	 * Using these methods an automation engineer can locate the elements on a webpage in a webapplication
	 * Below are selenium locators
	 * 1. Id 					===> id()
	 * 2. name					===> name()
	 * 3. CSSSelector			===> cssSelector()
	 * 4. TagName				===> tagName()
	 * 5. LinkText				===> linkText()
	 * 6. PartialLinkText		===> partialLinkText()
	 * 7. XPath					===> xpath()
	 */
	
	WebDriver web;
	
	void setupBrowser() {
		web = new ChromeDriver();
		web.manage().window().maximize();
		web.get("https://demo.openmrs.org/openmrs/login.htm");
	}
	
	void locatorsDemo() throws InterruptedException {
		System.out.println("1. Selenium locator - ID");
		web.findElement(By.id("username")).sendKeys("Admin");
		
		System.out.println("2. Selenium locator - Name");
		web.findElement(By.name("password")).sendKeys("Admin123");
		
		System.out.println("3. Selenium locator - TagName");
		web.findElement(By.tagName("li")).click();
		
		System.out.println("6. Selenium locator - CSSSelector");
		web.findElement(By.cssSelector("input#loginButton[type='submit']")).click();
		
		System.out.println("4. Selenium locator - LinkText");
		web.findElement(By.linkText("Find Patient Record")).click();
		
		System.out.println("7. Selenium locator - XPath");
		web.findElement(By.xpath("//input[@id='patient-search']")).sendKeys("John".toLowerCase());
		
		Thread.sleep(1000);
		System.out.println("5. Selenium locator - PartialLinkText");
		web.findElement(By.partialLinkText("ogou")).click();
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		SeleniumLocators locator = new SeleniumLocators();
		locator.setupBrowser();
		locator.locatorsDemo();
		Thread.sleep(2500);
		locator.web.quit();
	}

}
