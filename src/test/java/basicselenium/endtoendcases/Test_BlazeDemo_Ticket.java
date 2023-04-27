package basicselenium.endtoendcases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test_BlazeDemo_Ticket {
	/*
	 * Test case : User is able to book the ticket for the lowest price on Blazedemo
	 */
	
	WebDriver driver;
	List<WebElement> source,destination;
	List<WebElement> rows,colums;
	String price;
	int total_rows, total_columns;

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
		// First get all rows and columns count
		rows = driver.findElements(By.xpath("//tbody/tr"));
		
		total_rows = driver.findElements(By.xpath("//tbody/tr")).size();
		total_columns = driver.findElements(By.xpath("//tbody/tr/td/input")).size();
		
		System.out.println("Total rows - "+total_rows+", "+"Total columns - "+total_columns);
		//System.out.println(rows.toArray().toString());
		
		try{
			for(int j=1;j<=total_columns;j++) {
				price = driver.findElement(By.xpath("//tbody/tr["+j+"]/td[6]")).getText();
				System.out.println(price.replace("$", ""));
			}
		}
		catch(Exception ex) {
			System.out.println("Thrown : "+ex.getMessage());
		}
		
		
		System.out.println(Arrays.sort(price));
		/*for(int i = 0;i<price.length();i++) {
			System.out.println(price.toString());
		}*/
		
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
