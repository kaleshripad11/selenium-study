package testngdemos.tannotations;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNgAnnotations {
	/*
	 * TestNG Hierarchy => Suite -> Test -> Class -> Test
	 * TestNg provide below annotations : 
	 * 1. @BeforeSuite
	 * 2. @AfterSuite
	 * 3. @BeforeTest
	 * 4. @AfterTest
	 * 5. @BeforeClass
	 * 6. @AfterClass
	 * 7. @BeforeMethod
	 * 8. @AfterMethod
	 * 9. @Test
	 */
	
	@BeforeSuite
	void printMessage() {
		System.out.println("This is the beginning of suite...");
	}
	
	@BeforeMethod
	int performSum(int a, int b) {
		return (a+b);
	}
	
	@Test
	void testPerformSum() {
		AssertJUnit.assertEquals(performSum(10, 5), 15);
	}
	
	@AfterTest
	void printTestMessage() {
		System.out.println("Closing test");
	}
	
	@Test
	@AfterSuite
	void test() {
		System.out.println("After suite");
	}
}
