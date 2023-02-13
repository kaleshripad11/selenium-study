package basicselenium.alerts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertConfig {
	
	WebDriver driver;
	
	protected void setupBrowser() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");
	}
}
