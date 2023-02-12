package basicselenium.dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Asgn_DropDownHandling {
	/*
	 * Assignment - Handle phppot dropdown without using Select class
	 */
	
	BasicDropDown dropdown;
	List<WebElement> countries,states;
	
	void locatePhpPotDropDown() {
		dropdown = new BasicDropDown();
		dropdown.setupWebDriver();
		dropdown.driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		//Get options in the list
		countries = dropdown.driver.findElements(By.xpath("//select[@id='country-list']/option"));
	}
	
	void listItemsInDropDown() {
		System.out.println("Available countries in the list : ");
		for(WebElement listItems : countries) {
			System.out.println(listItems.getText());
		}
		System.out.println("Count of countries in the list : "+countries.size());
	}
	
	void selectCountries() throws InterruptedException {
		for(WebElement listItems : countries) {
			//Compare each item in the country dropdown with argument "India"
			if(listItems.getText().equals("India")) {
				Thread.sleep(1000);
				listItems.click();
				System.out.println("Selected country : "+listItems.getText().toString());
				break;
			}
		}
		selectStates();
	}
	
	void selectStates() throws InterruptedException {
		states = dropdown.driver.findElements(By.xpath("//select[@id='state-list']/option"));
		System.out.println("Available states in selected country : ");
		for(WebElement x : states) {
			System.out.print(x.getText()+" ");
		}
		System.out.println();
		
		for(WebElement y : states) {
			//Compare each item in the country dropdown with argument "India"
			if(y.getText().equals("Delhi")) {
				Thread.sleep(1000);
				y.click();
				System.out.println("Selected state : "+y.getText().toString());
				break;
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Asgn_DropDownHandling dropdown_assignment = new Asgn_DropDownHandling();
		dropdown_assignment.locatePhpPotDropDown();
		dropdown_assignment.listItemsInDropDown();
		dropdown_assignment.selectCountries();
		dropdown_assignment.dropdown.driver.quit();
	}
}
