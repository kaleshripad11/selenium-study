package basicselenium.mouseactions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.checkerframework.checker.units.qual.m;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHandlingDemo {
	/*
	 * In selenium we can perform mouse actions using Actions class present interactions package
	 * https://demo.guru99.com/test/simple_context_menu.html
	 */
	
	WebDriver driver;
	
	public MouseHandlingDemo(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.driver.manage().window().maximize();
		this.driver.get("https://demo.opencart.com/");
	}
	
	void mouseHoverDemo() throws InterruptedException {
		// Locate desktop element on the UI 
		WebElement desktop = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
		WebElement windows = driver.findElement(By.xpath("//a[normalize-space()='PC (0)']"));
		
		// Create object of Actions class 
		Actions perform_action = new Actions(driver);
		
		/*
		 *  Use moveToElement(WebElement/Element) method to perform mouse hover actions
		 *  Use build().perform() to build and complete the action
		 *  Method build() will only build the action.
		 *  In-order to complete the action need to use perform() method
		 */
		perform_action.moveToElement(desktop).moveToElement(windows).click().build().perform();
	}
	
	void mouseRightClickDemo() {
		/*
		 * Right click is also known as Context Click 
		 * 
		 */
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		Actions rightClick = new Actions(driver);
	}
	
	void mouseDoubleClickDemo() {
		//
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		MouseHandlingDemo mouse = new MouseHandlingDemo(new FirefoxDriver());
		mouse.mouseHoverDemo();
		Thread.sleep(5000);
		mouse.driver.quit();
	}

}
