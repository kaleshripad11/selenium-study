package basicselenium.mouseactions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

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
		
		/* 
		 * // Set window size using Point class
		 * Point p = new Point(0, 0); driver.manage().window().setPosition(p);
		 * System.out.println(driver.manage().window().getPosition());
		 */
		
		// Get location of left slider
		WebElement slider_left = driver.findElement(By.xpath("//*[@id='slider-range']/span[1]"));
		System.out.println("Slider current location from left : "+slider_left.getLocation());
		
		Actions act = new Actions(driver);
		
		// Drag left slider
		act.dragAndDropBy(slider_left, 260, 46).build().perform();
		
		// Get location of right slider
		WebElement slider_right = driver.findElement(By.xpath("//*[@id='slider-range']/span[2]"));
		System.out.println("Slider current location from right : "+slider_right.getLocation());
		
		// Drag right slider
		act.dragAndDropBy(slider_right, -100, 46).build().perform();
		
		
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
