package testngdemos.pomdemo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class Page_OpenCart_Login {
	
	// Webdriver reference variable
	WebDriver driver;
	
	// Locate elements required for Login
	By userText = By.xpath("//input[@id='input-email']");
	By userPass = By.xpath("//input[@id='input-password']");
	By btnLogin = By.xpath("//button[@type='submit']");
	
	// otto.anderson@example.com; otto@123
	
	
	// Instantiate driver
	public Page_OpenCart_Login(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;			//Instantiate webdriver
		this.driver.manage().window().maximize();
		this.driver.get("https://demo.opencart.com/index.php?route=account/login");
	}
	
	
	// Action methods
	
	public void enterUserName(String uname) {
		driver.findElement(userText).sendKeys(uname);
	}
	
	public void enterUserPass(String upass) {
		driver.findElement(userPass).sendKeys(upass);
	}
	
	public void clickBtnLogin() {
		driver.findElement(btnLogin).click();
	}	
	
}
