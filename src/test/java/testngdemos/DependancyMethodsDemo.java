package testngdemos;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.*;

public class DependancyMethodsDemo {
	/*
	 * In testng methods dependancy can be set using parameter 'dependsOnMethods'
	 * It's syntax is 'dependsOnMethods={Sequence of dependent methods}'
	 */
	
	@Test(priority=1)
	void openBrowser() {
		assertEquals(false, true);
	}
	
	@Test(priority=2,dependsOnMethods = {"openBrowser"})
	void openApp() {
		/*
		 * This method is dependent on "openBrowser()". If "openBrowser()" assert fails, all the remaining methods will be skipped,
		 * As all remaining methods dependent on their previous methods
		 */
		System.out.println("Loading the application...");
		assertEquals(false, true);
	}
	
	@Test(priority=3,dependsOnMethods = {"openBrowser","openApp"})
	void loginApp() {
		System.out.println("Login page...");
		assertEquals(true, true);
	}
	
	@Test(priority=4,dependsOnMethods= {"loginApp"})
	void performSearch() {
		System.out.println("Searching item : Mobiles");
		System.out.println("Result found : ");
		assertEquals(true, true);
	}
	
}
