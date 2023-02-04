package basicselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TEST_NopCommerce_Login {
	/*
	 * Test login functionality
	 * 1) Launch browser
	 * 2) Open url URL: https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F
	 * 3) Provide username 
	 * 4) Provide password 
	 * 5) Click on Login button 
	 * 6) Verify the Heading of dashboard page [Exp title : Dashboard / nopCommerce administration]
	 * 7) If dashboard page is not displayed, login is failed
	 */
	
	WebDriver driver;
	String dashboard_title;
	String error_message = "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found\r\n";
	
	void setupBrowser() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
	}
	
	
	void performLogin(String uname,String pass) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Email")).sendKeys(uname);
		driver.findElement(By.id("Password")).sendKeys(pass);
		driver.findElement(By.cssSelector("button.login-button[type='submit']")).click();
	}
	
	void validLoginTest() throws InterruptedException {
		performLogin("admin@yourstore.com", "admin");
		dashboard_title = driver.getTitle();
		if(dashboard_title.equals("Dashboard / nopCommerce administration")) {
			System.out.println("Login test is successful with valid user name and valid password");
		}
		Thread.sleep(500);
		logout();
		driver.quit();
	}
	
	void invalidLogin_FirstTest() throws InterruptedException {
		setupBrowser();
		performLogin("admins@yourstore.com", "admin");
		String div_error = driver.findElement(By.cssSelector("div.message-error")).getText();
		if(div_error.equals(error_message)) {
			System.out.println("Login test is successful with invalid user name and valid password\n"
					+ "Received error message as expected");
		}
	}

	void logout() throws InterruptedException {
		Thread.sleep(500);
		Actions act =  new Actions(driver);
		act.moveToElement(driver.findElement(By.linkText("Logout"))).click().perform();
		System.out.println("Logged out successfully");
		/*System.out.println("Logging out the session!!!");
		driver.findElement(By.linkText("Logout")).click();*/
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		TEST_NopCommerce_Login login = new TEST_NopCommerce_Login();
		
		System.out.println("Setting up firefox driver and opening browser...");
		login.setupBrowser();
		
		System.out.println("Trying to login..");
		login.validLoginTest();
		login.invalidLogin_FirstTest();
		
		System.out.println("Closing browser");
		Thread.sleep(2000);
		login.driver.quit();
		System.out.println("All tests completed successfully");
	}
}
