package testngdemos.pomdemo.withpagefactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Page_OpenCart_Login {
	
	/*
	 * PageFactory is a class provided by selenium. It is present in support package
	 * Also we use @FindBy annotation
	 * Syntax : 
	 * PageFactory.initElements(driverObj, this);		// Inside constructor
	 * FindBy(xpath="<value>") WebElement <Element Name>;
	 */
	
	// Webdriver reference variable
	WebDriver driver;
	
	// Create WebElements referances for the fields on Login page
	@FindBy(xpath="//input[@id='input-email']") WebElement userText;
	@FindBy(xpath="//input[@id='input-password']") WebElement userPass;
	@FindBy(xpath="//button[@type='submit']") WebElement btnLogin;
	
	
	// otto.anderson@example.com; otto@123
	
	
	// Instantiate driver
	public Page_OpenCart_Login(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;			//Instantiate webdriver
		PageFactory.initElements(driver,this);
	}
	
	
	// Action methods
	
	public void enterUserName(String uname) {
		userText.sendKeys(uname);
	}
	
	public void enterUserPass(String upass) {
		userPass.sendKeys(upass);
	}
	
	public void clickBtnLogin() {
		btnLogin.click();
	}	
	
}
