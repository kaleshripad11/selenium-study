package testngdemos.tannotations.testann;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeAndAfterSuite_Annotation {
	/*
	 * BeforeSuite & AfterSuite annotation will be executed only once before starting the suite & after completing the suite
	 * 
	 */

	@BeforeSuite
	void executeBeforeSuite() {
		System.out.println("Before Suite");
	}
	
	@AfterSuite
	void executeAfterSuite() {
		System.out.println("After Suite");
	}
	
	@BeforeTest
	void login() {
		System.out.println("Logging in...");
		System.out.println("Logged in successfully!!!\n");
	}
	
	@AfterTest
	void logout() {
		System.out.println("Logging out...");
		System.out.println("Logged out successfully!!!\n");
	}
	

	@Test(priority=1)
	void performProductSearch() {
		System.out.println("Searching for mobile...\n");
	}
	
	@Test(priority=2)
	void openProductDetails() {
		System.out.println("Loading mobile details...\n");
	}
	
	@Test(priority=3)
	void placeProductOrder() {
		System.out.println("Order placed successfully\n");
	}
}
