package basicselenium.frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AsgnFrame {
	/*
	 * https://the-internet.herokuapp.com/iframe
	 * Go to above link and perform operations 
	 */
	
	WebDriver driver;
	WebElement inputFrame;
	String sampleString = "This is demo selenium text";
	
	public AsgnFrame(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.driver.manage().window().maximize();
	}
	
	void openHerokuApp() {
		driver.get("https://the-internet.herokuapp.com/iframe");
		inputFrame = driver.findElement(By.cssSelector("iframe.tox-edit-area__iframe"));
		driver.switchTo().frame(inputFrame);
		driver.findElement(By.cssSelector("body#tinymce")).clear();
		driver.findElement(By.cssSelector("body#tinymce")).sendKeys(sampleString);
	}

	public static void main(String[] args) throws InterruptedException {
		AsgnFrame assignment = new AsgnFrame(new FirefoxDriver());
		assignment.openHerokuApp();
		Thread.sleep(1000);
		assignment.driver.quit();
	}
}
