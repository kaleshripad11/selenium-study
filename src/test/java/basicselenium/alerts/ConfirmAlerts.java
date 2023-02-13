package basicselenium.alerts;

//import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmAlerts {
	AlertConfig ac;
	
	void actionsOnConfirmAlert() {
		ac = new AlertConfig();
		ac.setupBrowser();
		// Locate button on which alert appears
		ac.driver.findElement(By.cssSelector("button#confirmButton[type='button']")).click();
		/*
		WebDriverWait confirm = new WebDriverWait(ac.driver, Duration.ofSeconds(10));
		confirm.until(ExpectedConditions.alertIsPresent());
		*/
		Alert confirmStatus = ac.driver.switchTo().alert();
		System.out.println(confirmStatus.getText());
		confirmStatus.accept();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfirmAlerts ca = new ConfirmAlerts();
		ca.actionsOnConfirmAlert();
		ca.ac.driver.quit();
	}

}
