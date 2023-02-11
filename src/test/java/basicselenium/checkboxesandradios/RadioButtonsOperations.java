package basicselenium.checkboxesandradios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;

public class RadioButtonsOperations {
	
	/*
	 * Perform operations on Radiobuttons
	 * 1. Open url - https://itera-qa.azurewebsites.net/home/automation
	 * 2. Locate gender radio buttons
	 * 3. Select any gender 
	 * 5. Return its status
	 * 6. Based on any radio selection check status of others
	 */
	
	WebDriver driver;
	WebElement radioMale, radioFemale, radioOther;
	List<WebElement> genderRadio;
	
	void setupBrowser() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
	}
	
	void locateAllGenderRadios() throws InterruptedException {
		genderRadio = driver.findElements(By.xpath("//input[@class='form-check-input' and @name='optionsRadios']"));
		System.out.println(genderRadio.size());
		for(WebElement gender : genderRadio) {
			Thread.sleep(1000);
			gender.click();
		}
	}
	
	void selectAnyGender() {
		System.out.println("Selecting gender : ");
		radioMale = driver.findElement(By.id("male"));
		radioFemale = driver.findElement(By.id("female"));
		radioOther = driver.findElement(By.id("other"));
		radioMale.click();
		if(radioMale.isSelected()==true) {
			radioFemale.click();
		}else {
			radioMale.click();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		RadioButtonsOperations radiobuttons = new RadioButtonsOperations();
		radiobuttons.setupBrowser();
		radiobuttons.locateAllGenderRadios();
		radiobuttons.selectAnyGender();
		radiobuttons.driver.quit();
	}

}
