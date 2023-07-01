package basicselenium.brokenlinks_and_screenshots;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

class HeadlessTest{
	
	//@SuppressWarnings("deprecation")
	public static void main(String[] args) {
	
		FirefoxOptions foptions = new FirefoxOptions();
		foptions.addArguments("-headless");
		
		//foptions.setHeadless(true);
		WebDriver driver = new FirefoxDriver();
		//WebPage Heading - "Automation Testing Practice" [xpath - "//div/h1[@class='title']"]
		
		//HeadlessTest headless = new HeadlessTest();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//Validate page heading in Headless mode
		
		WebElement pageHeading = driver.findElement(By.xpath("//div/h1[@class='title']"));
		String expectedHeading = "Automation Testing Practice";
		
		if(pageHeading.getText().equals(expectedHeading)) {
			System.out.println("Expected heading and Actual heading are same! Hence test case passed!!");
		}
		else {
			System.out.println("Expected heading and Actual heading are not matching! Hence test case failed!!");
		}
		
		driver.quit();
	}
}