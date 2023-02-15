package basicselenium.alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.Alert;

public class Asgn_RediffAlert {
	WebDriver driver;
	String alertText;
	
	public Asgn_RediffAlert(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	void setUpBrowser() {
		driver.manage().window().maximize();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	}
	
	void getAlertBox() {
		driver.findElement(By.cssSelector("input.signinbtn[type='submit']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert rediffAlert = driver.switchTo().alert();
		alertText = rediffAlert.getText();
		System.out.println(alertText);
		rediffAlert.accept();
	}
	
	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		Asgn_RediffAlert rediff = new Asgn_RediffAlert(new FirefoxDriver());
		rediff.setUpBrowser();
		Thread.sleep(1000);
		rediff.getAlertBox();
		Thread.sleep(1000);
		rediff.driver.quit();
	}

}
