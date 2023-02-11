package basicselenium.waits;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ImplicitWaitExample {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String openrms = "https://demo.openmrs.org/openmrs/login.htm";
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		System.out.println("Opening URL : "+openrms);
		driver.get(openrms);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("username")).sendKeys("Admin");
		driver.findElement(By.id("password")).sendKeys("Admin123");
		driver.findElement(By.xpath("//li[contains(text(),'Registration Desk')]")).click();
		driver.findElement(By.id("loginButton")).click();
		
		driver.quit();
	}

}
