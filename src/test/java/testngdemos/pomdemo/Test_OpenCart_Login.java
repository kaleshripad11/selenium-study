package testngdemos.pomdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Test_OpenCart_Login {
	
	WebDriver driver;
	Page_OpenCart_Login login;
	
	public Test_OpenCart_Login() {
		// TODO Auto-generated constructor stub
		driver = new FirefoxDriver();
	}

	@Test
	void loginTest() {
		login = new Page_OpenCart_Login(driver);
		login.enterUserName("otto.anderson@example.com");
		login.enterUserPass("otto@123");
		login.clickBtnLogin();
	}
	
	@AfterClass
	void closeBrowser() {
		driver.quit();
	}
}
