package basicselenium.selenium_methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebElementsMethods {
	/*
	 * 1. isDisplayed()
	 * 2. isSelected()
	 */
	
	WebDriver driver;
	
	WebElement button, checkbox, radiobutton;
	
	void setUpBrowser() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	void elementBooleanMethods() {
		System.out.println("Opening URL : ");
		driver.get("https://omayo.blogspot.com/");

		System.out.println("Check if button is visible :");
		button = driver.findElement(By.id("but2"));
		System.out.println(button.isDisplayed());
		System.out.println("Check if button is enabled or not : "+button.isEnabled());
		checkbox = driver.findElement(By.xpath("//input[@value='Pen' and @disabled='']"));
		System.out.println("Is 'Pen' checkbox selected? : "+checkbox.isSelected());
		radiobutton = driver.findElement(By.xpath("//input[@type='radio' and @name='vehicle' and @value='Car']"));
		System.out.println("Check if 'Car' checkbox is checked or not "+radiobutton.isSelected());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebElementsMethods web = new WebElementsMethods();
		web.setUpBrowser();
		web.elementBooleanMethods();
		web.driver.quit();
	}

}
