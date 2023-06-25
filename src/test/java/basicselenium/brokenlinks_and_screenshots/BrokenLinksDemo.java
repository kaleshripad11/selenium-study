package basicselenium.brokenlinks_and_screenshots;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.List;
import org.openqa.selenium.WebElement;

public class BrokenLinksDemo {

	WebDriver d;
	public BrokenLinksDemo(WebDriver driver) {
		// TODO Auto-generated constructor stub
		d = driver;
		d.get("http://www.deadlinkcity.com/");
		d.manage().window().maximize();
	}
	
	void handleBrokenLinks() throws IOException, MalformedURLException, UnknownHostException {
		// Get all the links in a list variable
		List<WebElement> allLinks = d.findElements(By.tagName("a"));
		
		// Get count of all the links
		System.out.println(allLinks.size());
		
		int brokenLinks = 0;		// Counter for storing count of broken links on the page
		
		// Traverse through all the links using enhanced loop
		for(WebElement url : allLinks) {
			// Now get the 'href' attribute value for anchor(a) tag
			String attrib = url.getAttribute("href");
			
			// Check if attribute is having any url or if it is blank
			if(attrib.isEmpty() || attrib == null) {
				System.out.println("Value for 'href' attribute is empty in anchor(a) tag!");
				continue;
			}
			
			// Now convert url string into URL format using 'URL' class
			URL converted_url = new URL(attrib);
			
			// Open connection to the URL
			/*
			 * Type casting 'converted_url' to HttpURLConnection type as URL class does not have connect() method in it
			 */
			HttpURLConnection hconn = (HttpURLConnection)converted_url.openConnection();
			hconn.connect();
			
			// Now validate response
			if(hconn.getResponseCode() >= 400) {
				// Get text present on link
				// System.out.println("'"+url.getText()+"' "+"==> is a broken link");
				System.out.println("'"+attrib+"' "+"==> is a broken link");
				
				// Update the counter by +1
				brokenLinks++;
			}
			else {
				// System.out.println("'"+url.getText()+"' "+"==> is not a broken link");
				System.out.println("'"+attrib+"' "+"==> is not a broken link");
			}
		}
		System.out.println("Total broken links : "+brokenLinks);
	}
	
	public static void main(String[] args) throws IOException, MalformedURLException, UnknownHostException {
		BrokenLinksDemo bld = new BrokenLinksDemo(new FirefoxDriver());
		bld.handleBrokenLinks();
		bld.d.quit();
	}
	
}
