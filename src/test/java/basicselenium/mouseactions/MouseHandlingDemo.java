package basicselenium.mouseactions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHandlingDemo {
	/*
	 * In selenium we can perform mouse actions using Actions class present interactions package
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
	
	void mouseRightClickDemo() throws InterruptedException {
		/*
		 * Right click is also known as Context Click 
		 * Use contextClick(WebElement) to peform right click
		 */
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		WebElement btn_rght_click = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		Actions rightClick = new Actions(driver);
		
		// Perform right click first
		rightClick.contextClick(btn_rght_click).build().perform(); //Dont use click() as doubleClick() is already in use
		Thread.sleep(500);
		
		// Click on any option in Context menu
		driver.findElement(By.xpath("//ul/li/span[text()='Cut']")).click();
		Thread.sleep(500);
		
		// Alert will be displayed, so switch to alert and accept it
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	void mouseDoubleClickDemo() {
		// Perform double click
		WebElement btn_dbl_click = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
		Actions double_click = new Actions(driver);
		double_click.doubleClick(btn_dbl_click).build().perform(); //Dont use click() as doubleClick() is already in use
		Alert alrt = driver.switchTo().alert();
		alrt.accept();
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		MouseHandlingDemo mouse = new MouseHandlingDemo(new FirefoxDriver());
		mouse.mouseHoverDemo();
		Thread.sleep(500);
		mouse.mouseRightClickDemo();
		Thread.sleep(500);
		mouse.mouseDoubleClickDemo();
		Thread.sleep(1000);
		mouse.driver.quit();
	}

}
