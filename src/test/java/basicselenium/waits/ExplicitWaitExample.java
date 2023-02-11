package basicselenium.waits;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		WebElement loginText, passwordText, optionText, loginBtn;
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.navigate().to("https://demo.openmrs.org/openmrs/login.htm");
		loginText = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("username"))));
		loginText.sendKeys("Admin");
		
		passwordText = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("password"))));
		passwordText.sendKeys("Admin123");
		
		optionText = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//li[contains(text(),'Registration Desk')]"))));
		optionText.click();
		
		loginBtn = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("loginButton"))));
		loginBtn.click();
		
		driver.quit();
	}

}
