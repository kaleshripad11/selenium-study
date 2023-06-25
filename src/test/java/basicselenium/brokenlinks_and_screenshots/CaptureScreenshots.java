package basicselenium.brokenlinks_and_screenshots;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;			


public class CaptureScreenshots {

	/*
	 * 'TakeScreenshots' is an interface in selenium 3 and higher versions
	 * It is an parent interface of 'WebDriver' interface
	 */
	
	WebDriver driver;
	
	public CaptureScreenshots(WebDriver d) {
		// TODO Auto-generated constructor stub
		driver = d;
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
	}
	
	void getFullPageScreenshot() throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot)driver;
	
		// Define temp screenshot file type and store it to file variable
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		
		// Define the destination location to store the temp screenshot file
		File destination = new File("/Users/shripadkale/Documents/Selenium_Java/selenium-study/screenshots/TestAutomationPractice.png");
		
		// Use FileUtils class to copy the temp file to the destination
		FileUtils.copyFile(source, destination);
	}
	
	void getPartialScreenshot() throws IOException {
		/*
		 * This feature is part of selenium 4 and newer versions
		 * No need to use 'TakeScreenshot' interface to capture partial screenshots
		 */
		
		WebElement table = driver.findElement(By.xpath("//*[@id='HTML1']/div[1]/table"));
		
		File src = table.getScreenshotAs(OutputType.FILE);
		
		File dest = new File("/Users/shripadkale/Documents/Selenium_Java/selenium-study/screenshots/TableOnly.png");
		
		FileUtils.copyFile(src, dest);
	}
	
	public static void main(String[] args) throws IOException  {
		CaptureScreenshots captureScreenshot = new CaptureScreenshots(new FirefoxDriver());
		captureScreenshot.getFullPageScreenshot();
		captureScreenshot.getPartialScreenshot();
		captureScreenshot.driver.quit();
	}
}
