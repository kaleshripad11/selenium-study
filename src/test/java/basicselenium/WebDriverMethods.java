package basicselenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverMethods {
	/*
	 * 1. getTitle() => get web page title
	 * 2. get(url) => Open web application in browser window using webdriver
	 * 3. getWindowHandle() => get webbrowser window ID
	 * 4. getWindowHandles() => get webbrowsers window ID's\(use it for tab navigations
	 * 5. getCurrentUrl() => get current url(use it for validation)
	 * 6. getPageSource() => Check if an element is present or not in page source
	 */

	//get methods
	WebDriver driver;
	
	void setWebDriver(){
		driver = new FirefoxDriver();
		driver.manage().window().fullscreen();
	}
	
	void getMethods() {
		System.out.println("Get page source \n"+driver.getPageSource());
		System.out.println("Navigate to url using get()");
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		System.out.println("Login to system");
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys("admin@yourstore.com");
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("admin");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("Get current URL after successful login : "+driver.getCurrentUrl());
		System.out.println("Get current page title "+driver.getTitle());
		System.out.println("Get window ID : "+driver.getWindowHandle());
		Set <String> ids = driver.getWindowHandles();
		System.out.println("Get Window ID's"+ids);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverMethods methods = new WebDriverMethods();
		methods.setWebDriver();
		methods.getMethods();
		methods.driver.quit();
	}

}
