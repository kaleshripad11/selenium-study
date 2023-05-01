package basicselenium.keyboardactions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class KeyboardActionsDemo {
	
	/*
	 * Demonstrate keyboard actions
	 * Syntax to use Combinational Keys
	 * ActionsObj.keyDown(Keys.KEY).sendKeys(key).keyUp(Keys.KEY).build().perform();
	 * ex => actionsObj.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
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
		// Locate source and destination fields
		driver.findElement(By.id("inputText1")).sendKeys("Selenium demo");
		
		// Action sequence = CTRL+A => CTRL+C => TAB => CTRL+V
		Actions act = new Actions(driver);
		
		// Copy text => CTRL+A
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
		act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		
		// Move focus to second text field
		act.keyDown(Keys.TAB).keyDown(Keys.TAB).build().perform();
		
		// Paste text => CTRL + V
		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
		//act.keyDown()
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		KeyboardActionsDemo kb_demo = new KeyboardActionsDemo(new FirefoxDriver());
		kb_demo.copyPasteText();
		Thread.sleep(1000);
		kb_demo.driver.quit();
	}

}
