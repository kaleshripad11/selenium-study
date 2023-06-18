package javascript_executor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class JavaScriptExecDemo{

	/*
	 * JavaScriptExecuter => use executeScript() method to execute java script statements
	 * obj.executeScript("arguments[0].setAttribute('value','john')",WebElement);
	 * */

	WebDriver driver;
	
	public JavaScriptExecDemo(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.driver.get("https://testautomationpractice.blogspot.com/");
	}
	
	void performJavascriptActions() {
		
	}

	public static void main(String args[]) {
		JavaScriptExecDemo jsDemo = new JavaScriptExecDemo(new FirefoxDriver());
		jsDemo.driver.quit();
	}
	
}