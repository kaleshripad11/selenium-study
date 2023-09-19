package testngdemos.assertionss;
import org.testng.annotations.*;

public class NormalAssertionUsingIfCondition {
	/*
	 * Assertions can be applied using the if else conditions
	 * In this println text will not be printed in testng report
	 */
	
	@Test
	void hardAssertDemo() {
		int x = 10, y = 100;
		
		if(x==y) {
			System.out.println("TestCase Passed");
		}
		else {
			System.out.println("TestCase Failed");
		}
	}

}
