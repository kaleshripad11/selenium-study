package basicselenium.alerts.demoblaze;
//import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoBlazeConfig {
	WebDriver driver;
	public DemoBlazeConfig() {
		driver = new FirefoxDriver();
	}
	
	protected void setupDriver() {
		driver.manage().window().maximize();
		driver.get("https://www.demoblaze.com/");
	}
}
