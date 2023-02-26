package basicselenium.windowhandling;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Set;
import java.time.Duration;
//import java.util.List;
import java.util.ArrayList;

public class WindowHandlingDemo {
	
	WebDriver driver;
	String parentTab,chieldTab;
	
	public WindowHandlingDemo(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		driver.manage().window().maximize();
	}
	
	void openOrangeHRM() throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		
		//Get window id's using getWindowHandles() and store in set collection as getWindowHandles() returns Set collection
		Set<String> windows = driver.getWindowHandles();
		
		//Convert above Set variable 'windows' to ArrayList. Set does not support indexing and hence cannot use get() 
		ArrayList<String> winodwIds = new ArrayList<String>(windows);
		
		//Store the tab id's in String variable
		parentTab = winodwIds.get(0);
		chieldTab = winodwIds.get(1);
		
		Thread.sleep(1000);
		
		//Perform login in first tab
		//driver.switchTo().window(parentTab);
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		driver.switchTo().window(chieldTab);
		chieldWindow();
	}
	
	void chieldWindow() {
		driver.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//li[1]//a[1]")).click();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WindowHandlingDemo handleWindow = new WindowHandlingDemo(new FirefoxDriver());
		handleWindow.openOrangeHRM();
		Thread.sleep(500);
		handleWindow.driver.quit();
	}

}
