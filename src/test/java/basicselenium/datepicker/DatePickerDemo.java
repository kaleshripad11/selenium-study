package basicselenium.datepicker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class DatePickerDemo {
	/*
	 * Basic jQuery date picker automation using Selenium
	 * 1. Navigate to url - https://jqueryui.com/datepicker/
	 * 2. Locate and click on date picker text box 
	 * 3. First store month and year in separate string variables
	 * 4. Then extract all days available in that month and store it in a list variable
	 * 5. Compare date with date available in the list
	 * 
	 */
	
	WebDriver driver;
	protected WebElement calender_control, prev_date,next_date;
	protected List<WebElement> days;
	String day,month,year;
	
	public DatePickerDemo(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.driver.manage().window().maximize();
	}
	
	void locateDatepicker() {
		driver.get("https://jqueryui.com/datepicker/");
		
		// As date picker is located in a separate frame, first control needs to swtiched over that frame
		WebElement dateFrame = driver.findElement(By.cssSelector("iframe.demo-frame"));
		driver.switchTo().frame(dateFrame);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		calender_control = driver.findElement(By.cssSelector("input#datepicker[class='hasDatepicker']"));
		calender_control.click();
		prev_date = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']"));
		next_date = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']"));
		days = driver.findElements(By.xpath("//td[@data-handler='selectDay']"));
	}
	
	void printAllDates() {
		String current_month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		String current_year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		// Printing all dates in a month
		for (WebElement x : days) {
			System.out.println(x.getText()+"-"+current_month+"-"+current_year);
		}
	}
	
	void compareDate() {
		day = "22";
		month = "March";
		year = "2023";
		
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		DatePickerDemo dateDemo = new DatePickerDemo(new FirefoxDriver());
		dateDemo.locateDatepicker();
		dateDemo.printAllDates();
		Thread.sleep(10000);
		dateDemo.driver.quit();
	}

}
