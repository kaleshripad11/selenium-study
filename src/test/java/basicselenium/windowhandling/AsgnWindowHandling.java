package basicselenium.windowhandling;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AsgnWindowHandling {
	/*
	 * Go to testautomationpractice.blogspot.com
	 * In the first searchbox enter search text
	 * and click each link in the result(This will open in new tab every time)
	 * Perform operations on those tabs
	 */
	
	WebDriver driver;
	Set<String> windowIds;
	
	
	public AsgnWindowHandling(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	void performSearch() {
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.findElement(By.cssSelector("input.wikipedia-search-input")).sendKeys("selenium");
		driver.findElement(By.cssSelector("input.wikipedia-search-button[type='submit']")).click();
	}
	
	void clickSearchResults() {
		driver.findElement(By.linkText("Selenium")).click();
		driver.findElement(By.partialLinkText("biology")).click();
		driver.findElement(By.partialLinkText("software")).click();
	}
	
	
	
	void getAllWindowHandles() {
		windowIds = driver.getWindowHandles();
		for(String x : windowIds) {
			String windowTitles = driver.switchTo().window(x).getTitle();
			System.out.println(windowTitles+" ");
			//driver.close(); //=>Closes only single browser tab at a time
		}
	}
	
	void handleWindows() {
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		AsgnWindowHandling asgn = new AsgnWindowHandling(new FirefoxDriver());
		asgn.performSearch();
		asgn.clickSearchResults();
		asgn.getAllWindowHandles();
		//asgn.handleWindows();
		Thread.sleep(1000);
		asgn.driver.quit(); //=>Quits entire browser session
	}
}
