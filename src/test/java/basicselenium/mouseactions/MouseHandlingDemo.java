package basicselenium.mouseactions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
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
	
	void mouseClickDemo() {
		// Locate desktop element on the UI 
		WebElement desktop_hover = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
		Actions mouseAct = new Actions(driver);
		//desktop_hover
	}
	
	void mouseRightClickDemo() {
		
	}
	
	void mouseDoubleClickDemo() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MouseHandlingDemo mouse = new MouseHandlingDemo(new FirefoxDriver());
	}

}
