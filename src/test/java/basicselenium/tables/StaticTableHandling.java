package basicselenium.tables;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StaticTableHandling {
	
	WebDriver driver;
	
	// Create constructor and initialize webdriver
	public StaticTableHandling(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		driver.manage().window().maximize();
	}
	
	void performTableOps() {
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		
		// Get the rows and columns count
		int cols = driver.findElements(By.xpath("//table[@id='customers']//tbody/tr/th")).size();
		int rows = driver.findElements(By.xpath("//table[@id='customers']//tbody/tr")).size();
		System.out.println("Size of the table is : "+rows+" X "+cols);
		
		System.out.println("Print the table heading");
		for(int i = 1;i<=cols;i++) {
			System.out.print(driver.findElement(By.xpath("//table[@id='customers']//tbody/tr[1]/th["+i+"]")).getText()+"		|	");
		}
		System.out.println();
		
		// Print rows in the table
		for(int i=2;i<=rows;i++) {
			for(int j=1;j<=cols;j++) {
				System.out.print(driver.findElement(By.xpath("//table[@id='customers']//tbody/tr["+i+"]/td["+j+"]")).getText()+"		|	");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticTableHandling tableHandling = new StaticTableHandling(new FirefoxDriver());
		tableHandling.performTableOps();
		tableHandling.driver.quit();
	}

}
