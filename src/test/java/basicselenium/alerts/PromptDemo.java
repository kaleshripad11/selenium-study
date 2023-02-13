package basicselenium.alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class PromptDemo {

	AlertConfig ac;
	
	void performPromptActions() throws InterruptedException {
		ac = new AlertConfig();
		ac.setupBrowser();
		ac.driver.findElement(By.id("promtButton")).click();
		Alert alert = ac.driver.switchTo().alert();
		alert.sendKeys("Shripad");
		Thread.sleep(1000);
		alert.accept();
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		PromptDemo pd = new PromptDemo();
		pd.performPromptActions();
		pd.ac.driver.quit();
	}

}
