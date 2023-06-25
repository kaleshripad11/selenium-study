package basicselenium.brokenlinks_and_screenshots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadlessTest {
	/*
	 * To perform headless test Options class can be used
	 */
	
	
	
	WebDriver driver;
	
	public HeadlessTest(WebDriver d) {
		// TODO Auto-generated constructor stub
		
		// Below two lines code will run this code in Headless mode
		
		//options.addArguments("--headless=true");
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
		FirefoxOptions options = new FirefoxOptions();
		// options.setHeadless(true); //=> Deprecated method setHeadless();
		options.addArguments("-headless");
		HeadlessTest headless = new HeadlessTest(new FirefoxDriver());
		headless.getFullPageScreenshot();
		headless.getPartialScreenshot();
		headless.driver.quit();
	}
}
