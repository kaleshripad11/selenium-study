package basicselenium.other;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_Login {
	/*
	 * Since selenium 4.6.0 we dont need to specify system properties and no need to use WebDriverManager class
	 * The selenium code will handle above operations internally 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// Create object of browser
		//WebDriverManager.chromedriver().setup(); //Handled by maven dependency
		//ChromeDriver chrome = new ChromeDriver(); 
		WebDriver driver = new FirefoxDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		/*
		 * WebElement username = driver.findElement(By.name("username"));
		 * WebElement userpass = driver.findElement(By.name("password"));
		 * username.sendKeys("Admin");
		 * userpass.sendKeys("admin123"); 
		 */
		driver.manage().window().maximize();
		Thread.sleep(1500);
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();		
		Thread.sleep(2000);
		String homepage = driver.getTitle();
		if(homepage.equals("OrangeHRM1")) {
			driver.quit();
		}else {
			System.out.println("Title does not matches!");
		}
		//driver.quit();
	}

}
