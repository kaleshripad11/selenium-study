package javascript_executor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class JavaScriptExecDemo{

	/*
	 * Note : 'JavascriptExecutor' is an interface in Selenium which inherits 'SearchContext' as root interface
	 * JavaScriptExecuter => use executeScript() method to execute java script statements
	 * obj.executeScript("arguments[0].setAttribute('value','john')",WebElement);
	 * 
	 * Usage : JavaScript executer methods can be used when getting exceptions like 'ElementNotInterceptableException'
	 * */

	WebDriver driver;
	
	public JavaScriptExecDemo(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.driver.get("https://testautomationpractice.blogspot.com/");
	}
	
	void performJavascriptActions() {
		
		// Type cast webdriver reference variable with JavascriptExecutor interface
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		// Input user name in the textfield using javascript
		jse.executeScript("arguments[0].setAttribute('value','Nichole')", driver.findElement(By.cssSelector("input.form-control[id='name']")));
		
		// Input email id in the textfield using javascript
		jse.executeScript("arguments[0].setAttribute('value','nichole@xyz.com')", driver.findElement(By.cssSelector("input.form-control[id='email']")));
		
		// Input email id in the textfield using javascript
		jse.executeScript("arguments[0].setAttribute('value','8776745454')", driver.findElement(By.cssSelector("input.form-control[id='phone']")));
		
		// Input email id in the textfield using javascript
		// jse.executeScript("arguments[0].setAttribute('value','Kandhar, Afghanistan')", driver.findElement(By.xpath("//div/textarea[@id='textarea' and @class='form-control']")));
		
		// Perform click operations on Radio buttons, Checkboxes & buttons
		// driver.findElement(By.id("male")).click(); // => Using webdriver
		jse.executeAsyncScript("arguments[0].click();",driver.findElement(By.id("male"))); // Using Javascript Executor
	}

	public static void main(String args[]) {
		JavaScriptExecDemo jsDemo = new JavaScriptExecDemo(new FirefoxDriver());
		jsDemo.performJavascriptActions();
		jsDemo.driver.quit();
	}
	
}