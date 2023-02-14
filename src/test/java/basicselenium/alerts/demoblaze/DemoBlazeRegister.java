package basicselenium.alerts.demoblaze;

import java.time.Duration;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DemoBlazeRegister {
	DemoBlazeConfig config;
	
	void openRegistrationModal() {
		config = new DemoBlazeConfig();
		config.setupDriver();
		config.driver.findElement(By.cssSelector("a#signin2[data-target='#signInModal']")).click();
	}
	
	void performRegistration() {
		config.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement signup = config.driver.switchTo().activeElement();
		signup.findElement(By.xpath("//input[@id='sign-username' and @class='form-control']")).sendKeys("shripad");
		signup.findElement(By.xpath("//input[@id='sign-password' and @type='password']")).sendKeys("shree@123$");
		signup.findElement(By.xpath("//button[@type='button' and @onClick='register()']")).click();
	}
}
