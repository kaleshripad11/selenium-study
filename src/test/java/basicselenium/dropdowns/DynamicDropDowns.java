package basicselenium.dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;

public class DynamicDropDowns {
	/*
	 * Assignment - Search "selenium" in Microsoft Bing seach engine
	 * //li[@id='sa_5011']//span[@class='sa_tm_text']
	 * //li[@id='sa_5012']//span[@class='sa_tm_text'] #sb_form_q
	 */
	
	WebDriver driver;
	List<WebElement> bingSearch;
	
	void locateElements() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bing.com/");
		driver.findElement(By.cssSelector("textarea#sb_form_q[type='search']")).sendKeys("chatgpt");
		Thread.sleep(3000);
		bingSearch = driver.findElements(By.xpath("//li[@role='option']//span[@class='sa_tm_text']"));
	}
	
	void performSearch() {
		System.out.println("Total items in result set : "+bingSearch.size());
		System.out.println("Search result dropdown items : ");
		for(WebElement result : bingSearch) {
			System.out.print(result.getText()+", ");
		}
		System.out.println();
		
		System.out.println("Opening link from result : ");
		for(int i=0;i<bingSearch.size();i++) {
			if(bingSearch.get(i).getText().equals("chatgpt alternative")) {
				bingSearch.get(i).click();
				break;
			}
		}
		
		if(driver.getTitle().equals("chatgpt alternative - Search")) {
			System.out.println("Test successfull");
		}else {
			System.out.println("Test failed");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		DynamicDropDowns dynamic = new DynamicDropDowns();
		dynamic.locateElements();
		dynamic.performSearch();
		dynamic.driver.quit();
	}

}
