package basicselenium.mouseactions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Point;

public class SliderHandlingDemo {
	/*
	 * Slider practice page URL => https://www.globalsqa.com/demoSite/practice/slider/range.html
	 */
	
	WebDriver driver;
	
	public SliderHandlingDemo(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.driver.manage().window().maximize();
		this.driver.get("https://www.globalsqa.com/demoSite/practice/slider/range.html");
	}

	void sliderDemo() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement slider_left = driver.findElement(By.xpath("//*[@id='slider-range']/span[1]"));
		WebElement slider_right = driver.findElement(By.xpath("//*[@id='slider-range']/span[2]"));
		
		// Get location of left slider
		System.out.println("Slider current location from left : "+slider_left.getLocation());
		System.out.println("Slider current location from right : "+slider_right.getLocation());
		
		// Set window size using Point class
		Point p = new Point(100, 700);
		driver.manage().window().setPosition(p);
		
		Actions act = new Actions(driver);
		act.dragAndDropBy(slider_left, 260, 46).build().perform();
		// act.dragAndDropBy(slider_right, 996-20, 46).build().perform();
		// Location after dragging
		System.out.println("Slider current location from left : "+slider_left.getLocation());
		System.out.println("Slider current location from right : "+slider_right.getLocation());
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		SliderHandlingDemo sliderDemo = new SliderHandlingDemo(new FirefoxDriver());
		sliderDemo.sliderDemo();
		Thread.sleep(1000);
		sliderDemo.driver.quit();
	}

}
