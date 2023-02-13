package basicselenium.alerts;
import org.openqa.selenium.By;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

public class BasicAlertDemo {
	/*
	 * Handling alerts/popups in selenium
	 * - Use Aler class present in selenium
	 * - First switch the control over the alert using switchTo() and store this in Alert class object
	 * - Use Alert class builtin functions to perform actions on them
	 */
	

	AlertConfig ac;
	Alert alert;
	
	void locateAlerts() {
		ac = new AlertConfig();
		ac.setupBrowser();
		ac.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ac.driver.findElement(By.cssSelector("button#alertButton[type='button']")).click();
		alert = ac.driver.switchTo().alert();
		System.out.println("Clicking 'Ok' button..");
		alert.accept();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicAlertDemo alertDemo = new BasicAlertDemo();
		alertDemo.locateAlerts();
		alertDemo.ac.driver.quit();
	}

}
