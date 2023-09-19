package testngdemos;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
	
	@BeforeClass
	void setupWebDriver() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@Test(priority=1, dataProvider="swaglabs")
	void loginTest(String username, String password) {
		driver.get("https://www.saucedemo.com/");
		String homePage = "Products";
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		String actualTitle = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
		assertEquals(homePage, actualTitle);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
	}
	
	
	@DataProvider(name="swaglabs")
	String[][] jpetStoreLoginData(){
		String[][] credentials = {
				{"standard_user","secret_sauce"}, //Only valid & correct credential
				{"stduser","secret_sauce"},
				{"standerd_user","secret_sauces"},
				{"locked_out_user","secret_sauce"},
				{"Standard_user","secret_sauce"},
				{"StandardUser","secret_sauce"},
				{"StanderDuser","secret_sauce"},
				{"standard_user","secret_sauce"},
				{"standard_user","Secret_sauce"},
				{"standard_user","secret_Sauce"},
		};
		return credentials;
	}
	
	@Test(dependsOnMethods= {"loginTest"})
	void logout() {
		//driver.findElement(By.xpath("//*/div[@class='bm-burger-button']//button[@id='react-burger-menu-btn']")).click();
		//driver.findElement(By.id("react-burger-menu-btn")).click();
		//driver.findElement(By.xpath("//*/div/nav[@class='bm-item-list']//a[@id='logout_sidebar_link']")).click();
		driver.findElement(By.id("react-burger-menu-btn")).click();
	    driver.findElement(By.id("logout_sidebar_link")).click();
	}
	
	@AfterClass
	void closeBrowser() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.quit();
	}
}
