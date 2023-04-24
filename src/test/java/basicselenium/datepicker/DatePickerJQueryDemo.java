package basicselenium.datepicker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;

public class DatePickerJQueryDemo {
	
	/*
	* Approaches
	* 1. Put date using sendkeys directly(not applicable always)
	* 2. Selecting date dynamically at runtime
	* a. Locate date picker and click
	* b. Get month, year and date in a variable and compare it with month, yr and date present in calendar
	* For this comparison, start a while loop and in it store  values for month and year on each iteration
	* inside loop at one if block and keep comparing date and month. 
	* After comparing the date and month, keep clicking next button for next month
	*/
	
	WebDriver driver;
	WebElement datePicker;
	List<WebElement> allDays;

	public DatePickerJQueryDemo(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.driver.manage().window().maximize();
		this.driver.get("https://jqueryui.com/datepicker/");
	}
	
	public void locateDatePicker() {
		driver.switchTo().frame(0);
		datePicker = driver.findElement(By.cssSelector("input#datepicker[class='hasDatepicker']"));
	}
	
	// Direct(static) approach to put date in JQuery Date picker
	public void putDateDirectlyInDatePicker() {
		// Locate date picker
		// locateDatePicker();
		datePicker.sendKeys("05/24/2023");
		
		// In order to execute next method - selectFutureDateDynamicallyInDatePicker() successfully, reset the frame
		driver.switchTo().defaultContent();
	}
	
	// Get all days in a month
	/*public void getAllDatesInAMonth() {
		locateDatePicker();
		/*for(WebElement day:allDays) {
			System.out.println(day.getText());
		}
		driver.switchTo().defaultContent();
	}*/
	
	// Dynamic approach
	public void selectFutureDateDynamicallyInDatePicker() {
		// First locate the datePicker
		locateDatePicker();
		datePicker.click();
		String month = "July";
		String year = "2024";
		String day = "2";
		
		//System.out.println(allDays.size());
		
		/*
		 * Logic :
		 * First get month and year and store it a local variable
		 * Next using if statement, compare that local month and year variable with the actual variable defined outside loop
		 * If month and year matched then break the loop if not matched then keep clicking on Next/Forward button until condition gets satisfied
		 */
		while(true) {
			String temp_year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			String temp_month =  driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			if(temp_year.equals(year) && temp_month.equals(month)) {
				break;
			}
			driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/a[2]/span")).click();
		}
		
		allDays = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
		for(WebElement dt: allDays) {
			if(dt.getText().equals(day)) {
				dt.click();
				//System.out.println("Your selected future date is : "+datePicker.getText());
			}
		}
		
		// Reseting to default content
		driver.switchTo().defaultContent();
	}
	
	public void selectPastDateDynamicallyInDatePicker() {
		locateDatePicker();
		datePicker.click();
		String month = "January";
		String year = "2020";
		String day = "22";
		
		while(true) {
			String temp_year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			String temp_month =  driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			if(temp_year.equals(year) && temp_month.equals(month)) {
				break;
			}
			driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/a[1]/span")).click();
		}
		allDays = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
		for(WebElement dt: allDays) {
			if(dt.getText().equals(day)) {
				dt.click();
				//System.out.println("Your selected future date is : "+datePicker.getText());
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		DatePickerJQueryDemo jqueryDemo = new DatePickerJQueryDemo(new FirefoxDriver());
		jqueryDemo.locateDatePicker();
		
		jqueryDemo.putDateDirectlyInDatePicker();
		Thread.sleep(500);
		
		jqueryDemo.selectFutureDateDynamicallyInDatePicker();
		Thread.sleep(500);
		
		jqueryDemo.selectPastDateDynamicallyInDatePicker();
		Thread.sleep(500);
		
		jqueryDemo.driver.quit();
	}

}
