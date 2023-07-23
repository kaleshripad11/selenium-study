package testngdemos;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTestUsingTestNG {
	
	WebDriver driver;
  @BeforeTest
  public void setUpDriver() {
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.get("https://jpetstore.aspectran.com/catalog/");
  }
  
  @Test
  public void loginJPetStore() {
	  driver.findElement(By.linkText("Sign In")).click();
	  driver.findElement(By.name("username")).clear();
	  driver.findElement(By.name("username")).sendKeys("TestUser");
	  driver.findElement(By.name("password")).clear();
	  driver.findElement(By.name("password")).sendKeys("test@123");
	  driver.findElement(By.xpath("//*[@id=\"Signon\"]/form/div/div/button")).click();
	  //validateHomePageAfterLogin();
  }
  
  @Test
  public void validateHomePageAfterLogin() {
	  String homepageText = "JPetStore Demo";
	  String actualText = driver.findElement(By.xpath("//*[@id=\"masthead\"]/div[1]/div/div/header/h1")).getText();
	  
	  if(actualText.equals(homepageText)) {
		  System.out.println("Test passed successfully");
	  }
	  else {
		  System.out.println("Test failed!!!");
	  }
  }
  
  @AfterTest
  void logoutJPetStore() {
	  driver.findElement(By.linkText("Sign Out")).click();
	  driver.quit();
  }
}
