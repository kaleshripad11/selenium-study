package javascript_executor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScrollUsingJavaScriptExec {
	
	WebDriver driver;
	public ScrollUsingJavaScriptExec(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.driver.get("https://testautomationpractice.blogspot.com/");
	}
	
	void scrollUsingJSE() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		// Locate the button by scrolling down
		jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='pagination']/li[2]/a")));
	}

	public static void main(String[] args) {
		ScrollUsingJavaScriptExec scroll_demo = new ScrollUsingJavaScriptExec(new FirefoxDriver());
		scroll_demo.scrollUsingJSE();
		scroll_demo.driver.quit();
	}
}
