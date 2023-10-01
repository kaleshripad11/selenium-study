package testngdemos;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Parameterization_Demo {
	
	/*
	 * Without using any looping statements we can repeat data use using data providers, which is part of Parameterization concept
	 * Parameterization can be achieved using annotation "@DataProvider" which present in "org.testng.annotations" package
	 * The annotation "@DataProvider" will use parameter called as "name" in order to set the name for dataprovider and this name can be called in @Test parameter "dataprovider"
	 * Any method with the annotation "@DataProvider" will be treated as data provider
	 * And also these methods can get entire data from excel or spreadsheets and pass it in our test methods without using any loops
	 * 
	 * dataprovider method always returns two dimensional array
	 * For dataprovider method, we can return array as well,
	 * example :
	 * String[][] testData(){
	 * 		String data[][] = {};
	 * 		return data;
	 * }
	 * 
	 * If array contains multiple type of data we have to use "object" type for array
	 * While executing the test method, have to pass "dataprovider" parameter to the "@Test" annotation
	 * Ex : @Test(dataprovider="data")
	 * 
	 * indices parameter can be used to use specific element for the given index as parameter to test method
	 */
	
	
	WebDriver driver;
	public WebDriverWait wait;
	
	WebElement userText, userPass, btnLogin, linkLogout;
	String nopCommerce = "https://demo.nopcommerce.com/login";


	public Parameterization_Demo() {
		System.out.println("Initiating webdriver");
		// TODO Auto-generated constructor stub
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		
	}
	
	@Test(priority=1,dataProvider="nopc")
	void loginTest(String name, String pass) {
		driver.get(nopCommerce);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		System.out.println("Starting test");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Email"))).clear();
		driver.findElement(By.id("Email")).sendKeys(name);
			
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Password"))).clear();
		driver.findElement(By.id("Password")).sendKeys(pass);
			
		wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//button[normalize-space()='Log in']")))).click();
		
		String expText = "nopCommerce demo store";
		String actText = driver.getTitle();
		
		Assert.assertEquals(expText, actText);
	}
	
	@Test(dependsOnMethods= {"loginTest"})
	void logOut() {
		System.out.println("Logout");
		wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//a[normalize-space()='Log out']")))).click();
	}
	
	@AfterClass
	void closeBrowser() {
		driver.quit();
	}
	
	@DataProvider(name="nopc")
	String[][] jpetStoreLoginData(){
		String[][] credentials = {
				{"admin@yourstore.com","admin"}, 	//JPetStore Demo valid login
				{"demouser@2023","demo@123"},	//JPetStore Demo valid login
				{"admin","Adm1n123"},
				{"john.wick@example.com","john@123"},
				{"testNguser@example.com","test123"},
				{"Admin","admin123"},
				{"Admin","Admin@123"},
				{"admin","Admin@123"},
				{"Admin","admin@123"},
				{"TestNg1@test","testng1@123"},
				{"admin","Admin@123"},
				{"Admin","admin@123"},
		};
		return credentials;
	} 
	
	/*
	WebDriver driver;
	
	@BeforeClass
	void setup()
	{
		driver=new EdgeDriver();
	}
	
	@Test(dataProvider="dp")
	void testLogin(String email, String pwd)
	{
		driver.get("https://demo.nopcommerce.com/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();

		String exp_title = "Dashboard / nopCommerce administration";
		String act_title = driver.getTitle();

		Assert.assertEquals(exp_title, act_title);
	}
	
	@AfterClass
	void tearDown()
	{
		driver.close();
	}
	
	@DataProvider(name="dp"/*, indices= {0,1,4})
	String [][] loginData()
	{
		String data[][]= {  
							{"testNguser@example.com","test@123"},
							{ "abc@gmail.com", "test123" }, 
							{ "pavanol@gmail.com", "test@123" },
							{ "pavanoltraining@gmail.com", "test3" },
							{ "pavanoltraining@gmail.com", "test@123" },
							{ "pavanoltraining@gmail.com", "test@123" } 
						};
		
		return data;
	}
	*/
}
