package testngdemos.reports;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public class Page_MercuryTours_Login {
	
	WebDriver driver;
	public Page_MercuryTours_Login(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "userName") WebElement userName;
	@FindBy(name = "password") WebElement userPass;
	@FindBy(xpath = "//*[@value='Submit']") WebElement btnLogin;
	@FindBy(xpath = "//a[normalize-space()='SIGN-OFF']") WebElement logOutLink;
	@FindBy(xpath = "//span[normalize-space()='Enter your userName and password correct']") WebElement warningMessage;
	
	void enterUserName(String user) {
		userName.sendKeys(user);
	}

	void enterPassword(String pass) {
		userPass.sendKeys(pass);
	}
	
	void clickLoginButton() {
		btnLogin.click();
	}
	
}

