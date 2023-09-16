package testngdemos.tannotations.testann;
import org.testng.annotations.*;

public class BeforeAndAfterTest_Annotation {
	/*
	 * BeforeTest & AfterTest annotations works on multiple classes
	 * Will be executed every time before starting tests & after ending the tests
	 */

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
