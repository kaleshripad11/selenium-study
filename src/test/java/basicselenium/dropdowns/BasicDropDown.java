package basicselenium.dropdowns;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class BasicDropDown {
	/*
	 * 1. Open url for - https://itera-qa.azurewebsites.net/home/automation
	 * 2. Locate dropdown travel location
	 * 3. Get all countries list
	 * 4. Select any country from the list
	 * 5. List count of countries in dropdown 
	 */
	protected WebDriver driver;		// Protected elements/variables/methods will not be accessible outside packages
	Select countryDropdown;
	List<WebElement> allCountries;
	
	protected void setupWebDriver() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	void locateDropDown() {
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		countryDropdown = new Select(driver.findElement(By.className("custom-select")));
	}
	
	void getItemsInDropDown() {
		allCountries = countryDropdown.getOptions();
		System.out.println(allCountries.size());
		for(WebElement country: allCountries) {
			System.out.println(country.getText());
		}
	}
}
