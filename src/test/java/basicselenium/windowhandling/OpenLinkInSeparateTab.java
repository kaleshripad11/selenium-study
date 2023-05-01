package basicselenium.windowhandling;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenLinkInSeparateTab {
	/*
	 * Selenium 4 feature : Can be opened new tabs/Windows using selenium code
	 */
	
	WebDriver driver;
	
	public OpenLinkInSeparateTab(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.driver.manage().window().maximize();
		this.driver.get("https://the-internet.herokuapp.com/");
	}
	
	void openNewTab() {
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://the-internet.herokuapp.com/drag_and_drop");
	}
	
	void openNewWindow() {
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://demo.opencart.com/");
	}

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		OpenLinkInSeparateTab windowHandling = new OpenLinkInSeparateTab(new FirefoxDriver());
		windowHandling.openNewTab();
		Thread.sleep(500);
		windowHandling.openNewWindow();
		Thread.sleep(500);
		windowHandling.driver.quit();
	}

}
