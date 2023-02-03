package basicselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Dashboard_TEST {
	/*
	 * Test login functionality
	 * 1) Launch browser
	 * 2) open url URL: https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F
	 * 3) Provide username  - admin@yourstore.com
	 * 4) Provide password  - admin
	 * 5) Click on Login button 
	 * 6) Verify the title of dashboard page Exp title : Dashboard / nopCommerce administration
	 * 7) Verify Dashboard
	 */
	
	public static WebDriver driver = new FirefoxDriver();
	public WebElement userText, userPass;
	String dashboard_label = "Dashboard";
	
	public void launchBrowser() {
		driver.manage().window().maximize();
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		userText = driver.findElement(By.id("Email"));
		userPass = driver.findElement(By.id("Password"));
	}
	
	void performLogin() {
		userText.clear();
		userText.sendKeys("admin@yourstore.com");
		userPass.clear();
		userPass.sendKeys("admin");
		driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")).click();
	}
	
	public void validLoginTest() throws InterruptedException{
		Thread.sleep(1000);
		performLogin();
		String dashboardLabel = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/h1")).getText();
		System.out.println(dashboardLabel);
		Thread.sleep(1500);
		if(dashboardLabel.equals(dashboard_label)) {
			System.out.println("Login successful, test case passed!");
			//driver.quit();
		}
		Thread.sleep(2000);
		logoutTest();
	}
	
	public void invalidLoginTest() throws InterruptedException {
		Thread.sleep(2000);
		//launchBrowser();
		userText.clear();
		userText.sendKeys("admin@yourstore.com");
		userPass.clear();
		userPass.sendKeys("admins");
		driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")).click();
		String pagelabel = driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[2]/strong")).getText();
		Thread.sleep(2500);
		if(pagelabel=="Welcome, please sign in!") {
			System.out.println("Login failed, test case failed!");
			//driver.quit();
		}
		
		//System.out.println(dashboardLabel);
	}
	
	void logoutTest() {
		driver.findElement(By.linkText("Logout")).click();
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Dashboard_TEST dt = new Dashboard_TEST();
		System.out.println("Launching firefox browser...");
		dt.launchBrowser();
		System.out.println("Trying to login...");
		//dt.performLogin();
		dt.validLoginTest();
		dt.invalidLoginTest();
		//dt.logoutTest();
		//driver.quit();
	}

}
