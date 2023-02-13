package basicselenium.alerts;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimerAlert {
	AlertConfig ac;
	WebDriverWait alertWait;
	
	public void alertAction() throws InterruptedException {
		ac = new AlertConfig();
		ac.setupBrowser();
		ac.driver.findElement(By.cssSelector("button#timerAlertButton[type='button']")).click();
		
		// Use explicit wait(WebDriverWait class) as alert is taking some time to get visible
		alertWait = new WebDriverWait(ac.driver, Duration.ofSeconds(10));
		// alrtIsPresent() will wait until the alert appears or laods in the DOM
		Alert timerAlert = alertWait.until(ExpectedConditions.alertIsPresent());
		ac.driver.switchTo().alert();
		timerAlert.accept();
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		TimerAlert timer = new TimerAlert();
		timer.alertAction();
		Thread.sleep(5);
		timer.ac.driver.quit();
	}

}
