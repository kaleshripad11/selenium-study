package basicselenium.keyboardactions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActionsDemo {
	
	/*
	 * Demonstrate keyboard actions
	 */
	
	WebDriver driver;
	String src = null, dest = null;
	
	public KeyboardActionsDemo(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.driver.manage().window().maximize();
		this.driver.get("https://text-compare.com/");
	}

	void copyPasteText() {
		// First will put string in first textbox
		driver.findElement(By.id("inputText1")).sendKeys("Selenium demo");
		Actions act = new Actions(driver);
		
		// act.keyDown()
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
