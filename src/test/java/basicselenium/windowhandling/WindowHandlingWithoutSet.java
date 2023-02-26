package basicselenium.windowhandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Set;

public class WindowHandlingWithoutSet {
	
	WebDriver driver;
	String parentWindow,chieldWindow;
	Set<String> windowIds;
	
	public WindowHandlingWithoutSet(WebDriver driver) {
		this.driver = driver;
		driver.manage().window().maximize();
	}
	
	void performOperations() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		
		//Store window ids 
		windowIds = driver.getWindowHandles();
		
		for(String x : windowIds) {
			String windowTitle = driver.switchTo().window(x).getTitle();
			if(windowTitle.equals("OrangeHRM")) {
				performLogin();
			}
			else if(windowTitle.equals("Sign Up for a Free HR Software Demo | OrangeHRM | OrangeHRM")) {
				performContactSales();
			}
		}
	}
	
	void closeBrowserTabs() throws InterruptedException {
		for(String x : windowIds) {
			Thread.sleep(1000);
			driver.switchTo().window(x).close();
		}
	}

	void performLogin() {
		System.out.println("Inside Login function");
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	}
	
	void performContactSales() {
		System.out.println("Inside Contact Sales function");
		driver.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//li[1]//a[1]")).click();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WindowHandlingWithoutSet handleWindow = new WindowHandlingWithoutSet(new FirefoxDriver());
		handleWindow.performOperations();
		handleWindow.closeBrowserTabs();
		//handleWindow.driver.quit();
	}

}
