package testngdemos.reports;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Test_MercuryTours_Login {

	//public WebDriver driver;
	public Page_MercuryTours_Login login;
	
	@BeforeClass
	void setup() {
		login = new Page_MercuryTours_Login(new ChromeDriver());
		//login.driver = new ChromeDriver();
		login.driver.manage().window().maximize();
		login.driver.manage().deleteAllCookies();
		login.driver.get("https://demo.guru99.com/test/newtours/index.php");
	}
	
	@Test(priority=1)
	void loginWithValidDetails() {
		login.enterUserName("mercury");
		login.enterPassword("mercury");
		login.clickLoginButton();
		String welcomeString = login.driver.findElement(By.xpath("//h3[normalize-space()='Login Successfully']")).getText();
		AssertJUnit.assertEquals(welcomeString, "Login Successfully");
		
		login.logOutLink.click();
	}
	
	@Test(priority = 2)
	void loginWithInValidDetails() {
		login.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		login.enterUserName("m1");
		login.enterPassword("m1");
		login.clickLoginButton();
		String welcomeString = login.driver.findElement(By.xpath("//h3[normalize-space()='Login Successfully']")).getText();
		AssertJUnit.assertEquals(welcomeString, "Enter your userName and password correct");
		
		//login.logOutLink.click();
	}
	
	@AfterClass
	void closeBrowser() {
		login.driver.quit();
	}
}
