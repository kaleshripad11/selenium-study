package basicselenium.checkboxesandradios;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;

public class CheckBoxOperations {
	/*
	 * Case1 - Select multiple checkbox's
	 * Case2 - Select top 3 checkboxes
	 * Case3 - Select bottom 3 checkboxes
	 */

	WebDriver driver;
	List<WebElement> checkbox;
	
	void launchBrowser() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
	}
	
	void locateCheckBoxes() {
		// Use list collection to get all the checkbox
		checkbox = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		System.out.println("Total checkboxes : "+checkbox.size());
	}
	
	void selectAllCheckBoxes() {
		System.out.println("Selecting all checkboxes : ");
		for(WebElement checkElement : checkbox) {
			checkElement.click();
		}
	}

	void unSelectAllCheckBoxes() {
		System.out.println("Clearing all checkboxes : ");
		for(int i=0;i<checkbox.size();i++) {
			checkbox.get(i).click();
		}
	}
	
	void unSelectOnlySelectedCheckBoxes() {
		System.out.println("Clearing only selected checkboxes : ");
		for(int i=0;i<checkbox.size();i++) {
			if(checkbox.get(i).isSelected()) {
				checkbox.get(i).click();
			}
		}
	}
	
	void selectTopThreeCheckBoxes() {
		System.out.println("Select top 3 checkboxes : ");
		for(int i=0;i<checkbox.size();i++) {
			if(i<3) {
				checkbox.get(i).click();
			}
		}
	}
	
	void selectLastFiveCheckBoxes() {
		System.out.println("Select last 5 checkboxes : ");
		for(int i = 0;i<checkbox.size();i++) {
			if(i>2) {
				checkbox.get(i).click();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		CheckBoxOperations check = new CheckBoxOperations();
		check.launchBrowser();
		check.locateCheckBoxes();
		check.selectAllCheckBoxes();
		Thread.sleep(750);
		check.unSelectAllCheckBoxes();
		Thread.sleep(750);
		check.selectTopThreeCheckBoxes();
		Thread.sleep(500);
		check.unSelectOnlySelectedCheckBoxes();
		Thread.sleep(500);
		check.selectLastFiveCheckBoxes();
		check.driver.quit();
	}

}
