package basicselenium.selenium_methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationalMethods {
	/*
	 * Selenium provide 4 types of navigational methods as follows -
	 * 1. navigate().to(URL);
	 * 2. navigate().forward();
	 * 3. navigate().back();
	 * 4. navigate().refresh();
	 */

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		System.out.println("Loading NopCommerce application : ");
		driver.navigate().to("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		
		System.out.println("Current Url : "+driver.getCurrentUrl());
		
		//Thread.sleep(500);
		System.out.println("Redirecting to different url : ");
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("Current url : "+ driver.getCurrentUrl());
		
		System.out.println("Refreshing the tab : ");
		driver.navigate().refresh();
		
		//Thread.sleep(500);
		System.out.println("Going back to previous page : NopCommerce ");
		driver.navigate().back();
		System.out.println("Get current url : "+driver.getCurrentUrl());
		
		//Thread.sleep(500);
		System.out.println("Loading page : orangeHRM ");
		driver.navigate().forward();
		System.out.println("Get current url : "+driver.getCurrentUrl());
		
		driver.quit();
	}

}
