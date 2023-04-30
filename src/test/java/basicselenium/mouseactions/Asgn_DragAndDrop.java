package basicselenium.mouseactions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Asgn_DragAndDrop {

	/*
	 * Assignment :
	 * 1. Open URL => https://demo.guru99.com/test/drag_drop.html
	 * 2. Drag buttons to the right columns
	 * 3. Validate the button text after successful drag and drop 
	 */
	
	WebDriver driver;
	
	public Asgn_DragAndDrop(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.driver.manage().window().maximize();
		this.driver.get("https://demo.guru99.com/test/drag_drop.html");
	}
	
	void performDragAndDrop() throws InterruptedException {
		// Locate sources
		WebElement bank,amt1,sales,amt2;
		bank = driver.findElement(By.xpath("//li[@id='credit2']/a"));
		amt1 = driver.findElement(By.xpath("//li[@data-id='2']"));
		sales = driver.findElement(By.xpath("//li[@id='credit1']"));
		amt2 = driver.findElement(By.xpath("//li[@data-id='2']"));
		
		// Locate destinations
		WebElement destBank, destAmt1,destSales,destAmt2;
		destBank = driver.findElement(By.xpath("//ol[@id='bank']"));
		destAmt1 = driver.findElement(By.xpath("//ol[@id='amt7']"));
		destSales = driver.findElement(By.xpath("//ol[@id='loan']"));
		destAmt2 = driver.findElement(By.xpath("//ol[@id='amt8']"));
		
		Actions act = new Actions(driver);
		act.dragAndDrop(bank, destBank).build().perform();
		Thread.sleep(250);
		
		act.dragAndDrop(amt1, destAmt1).build().perform();
		Thread.sleep(250);
		
		act.dragAndDrop(sales, destSales).build().perform();
		Thread.sleep(250);
		
		act.dragAndDrop(amt2, destAmt2).build().perform();
		
		String validationText = driver.findElement(By.xpath("//div[@id='equal']//a")).getText();
		if(validationText.equalsIgnoreCase("perfect!")) {
			System.out.println("Test passed");
		}
		else {
			System.out.println("Test failed");
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Asgn_DragAndDrop assignment = new Asgn_DragAndDrop(new FirefoxDriver());
		assignment.performDragAndDrop();
		Thread.sleep(1000);
		assignment.driver.quit();
	}

}
