package basicselenium.endtoendcases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class Test_BlazeDemo_Ticket {
	/*
	 * Test case : User is able to book the ticket for the lowest price on Blazedemo
	 */
	
	WebDriver driver;
	List<WebElement> source,destination;
	List<WebElement> price;

	public Test_BlazeDemo_Ticket(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.driver.manage().window().maximize();
		this.driver.get("https://blazedemo.com/");
	}
	
	// Select source and destination
	void searchFlights() {
		// Get all the locations in source
		source = driver.findElements(By.xpath("//select[@name='fromPort']/option"));
		
		// Get all the location in destination
		destination = driver.findElements(By.xpath("//select[@name='toPort']/option"));
		
		source.get(3).click();
		destination.get(5).click();
		
		driver.findElement(By.cssSelector("input.btn[value='Find Flights']")).click();
	}
	
	void findLowestFaredTicket() {
		for(int i=1;i<6;i++) {
			price = driver.findElements(By.xpath("//tbody/tr["+i+"]/td[6]"));
			System.out.println(price.size());
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Test_BlazeDemo_Ticket bookTicket = new Test_BlazeDemo_Ticket(new FirefoxDriver());
		bookTicket.searchFlights();
		
		bookTicket.findLowestFaredTicket();
		
		Thread.sleep(1000);
		bookTicket.driver.quit();
	}

}
