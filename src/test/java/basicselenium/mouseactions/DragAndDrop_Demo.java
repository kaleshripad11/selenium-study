package basicselenium.mouseactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;


public class DragAndDrop_Demo {
	/*
	 * Drag and drop using Selenium
	 */
	WebDriver driver;
	
	public DragAndDrop_Demo(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.driver.manage().window().maximize();
		this.driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
	}
	
	void dragAndDropDemo() throws InterruptedException{
		// Locate source and destination
		WebElement src_stockholm = driver.findElement(By.cssSelector("div#box2[dragableelement='1']"));
		WebElement dest_sweden = driver.findElement(By.cssSelector("div.dragableBoxRight[id='box102']"));
		
		// Create 'Actions' class object
		Actions drag = new Actions(driver);
		Thread.sleep(1000);
		
		// Use method dragAndDrop(src,dest) to perform drag and drop operations
		drag.dragAndDrop(src_stockholm, dest_sweden).build().perform();
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		DragAndDrop_Demo dragDrop = new DragAndDrop_Demo(new FirefoxDriver());
		dragDrop.dragAndDropDemo();
		Thread.sleep(1000);
		dragDrop.driver.quit();
	}

}
