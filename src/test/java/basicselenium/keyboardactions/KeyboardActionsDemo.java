package basicselenium.keyboardactions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActionsDemo {
	
	/*
	 * Demonstrate keyboard actions
	 * Syntax to use Combinational Keys
	 * ActionsObj.keyDown(Keys.KEY).sendKeys(key).keyUp(Keys.KEY).build().perform();
	 * ex => actionsObj.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
	 */
	
	WebDriver driver;
	
	public KeyboardActionsDemo(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.driver.manage().window().maximize();
		this.driver.get("https://text-compare.com/");
	}

	void copyPasteText_Windows() throws InterruptedException{
		// Locate source and destination fields
		driver.findElement(By.id("inputText1")).sendKeys("Selenium demo");
		
		// Action sequence = CTRL+A => CTRL+C => TAB => CTRL+V
		Actions act = new Actions(driver);
		
		// Copy text => CTRL+A
		/*
		 *  Use sendKeys(""), whenever its required to press a character in  combination along with keyboard action method. 
		 *  Ex : act.keyDown(Keys.CONTROL).sendKeys("X")
		 */
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
		
		act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		
		// Move focus to second text field
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		
		// Paste text => CTRL + V
		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
		//act.keyDown()
		Thread.sleep(1000);
	}
	
	void copyPasteText_Mac() throws InterruptedException{
		// Locate source and destination fields
		driver.findElement(By.id("inputText1")).sendKeys("Selenium demo");
		
		// Action sequence = CTRL+A => CTRL+C => TAB => CTRL+V
		Actions act = new Actions(driver);
		
		// Copy text => CTRL+A
		/*
		 *  Use sendKeys(""), whenever its required to press a character in  combination along with keyboard action method. 
		 *  Ex : act.keyDown(Keys.CONTROL).sendKeys("X")
		 */
		act.keyDown(Keys.COMMAND).sendKeys("A").keyUp(Keys.COMMAND).perform();
		
		act.keyDown(Keys.COMMAND).sendKeys("C").keyUp(Keys.COMMAND).perform();
		
		// Move focus to second text field
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();

		// Paste text => CTRL + V
		act.keyDown(Keys.COMMAND).sendKeys("V").keyUp(Keys.COMMAND).perform();
	
		//Thread.sleep(1000);
	}
	
	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		KeyboardActionsDemo kb_demo = new KeyboardActionsDemo(new FirefoxDriver());
		//kb_demo.copyPasteText_Windows();
		kb_demo.copyPasteText_Mac();
		Thread.sleep(500);
		kb_demo.driver.quit();
	}

}
