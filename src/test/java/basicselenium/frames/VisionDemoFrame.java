package basicselenium.frames;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VisionDemoFrame {
	
	WebDriver driver;
	List<WebElement> frames;
	WebElement f1,f2,f3,f4,f5;
	
	//Create constructor
	public VisionDemoFrame(WebDriver driver) {
		this.driver = driver;
		this.driver.manage().window().maximize();
		this.driver.get("https://ui.vision/demo/webtest/frames/");
	}
	
	void getFrames() {
		frames = driver.findElements(By.tagName("frame"));
		System.out.println(frames.size());
		for(WebElement framelist : frames) {
			//System.out.println(framelist.getAttribute("src"));
			System.out.println(framelist.getDomAttribute("src"));
		}
	}
	
	void fillUpForm(){
		driver.findElement(By.xpath("//span[text()='Hi, I am the UI.Vision IDE']")).click();
	}
	
	void frameOperations() throws InterruptedException  {
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='frame_1.html']")));
		driver.findElement(By.xpath("//div/input[@name='mytext1']")).sendKeys("First Frame");
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='frame_2.html']")));
		driver.findElement(By.xpath("//div/input[@name='mytext2']")).sendKeys("First Frame");
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='frame_3.html']")));
		driver.findElement(By.xpath("//div/input[@name='mytext3']")).sendKeys("Third Frame");
		driver.switchTo().frame(0);
		fillUpForm();
		Thread.sleep(10);
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='frame_4.html']")));
		driver.findElement(By.xpath("//div/input[@name='mytext4']")).sendKeys("Fourth Frame");
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='frame_5.html']")));
		driver.findElement(By.xpath("//div/input[@name='mytext5']")).sendKeys("Fifth Frame");
		driver.switchTo().defaultContent();
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		VisionDemoFrame vision = new VisionDemoFrame(new FirefoxDriver());
		vision.getFrames();
		vision.frameOperations();
		Thread.sleep(2000);
		vision.driver.quit();
	}

}
