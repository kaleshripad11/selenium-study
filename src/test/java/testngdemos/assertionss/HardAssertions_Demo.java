package testngdemos.assertionss;
import org.testng.Assert;
import org.testng.annotations.*;

public class HardAssertions_Demo {
	/*
	 * TestNg provide Assert class, containing different assertion methods
	 * Also assert result will be reflected in testng report
	 * AssertEquals supports all kind of validations
	 * These are also called as Hard Assertions
	 * Accessed through Assert class
	 * All methods in Assert class are static
	 * If assertion fails no further methods will not be executed
	 * Example : In below example method "validateNumbersWithBooleanParameters()" will not be executed and marked as failed 
	 * because, assertion in "validateNumbers()" is failed
	 */

	@Test
	void validateNumbers() {
		int x=101,y=100;
		Assert.assertEquals(x, y);
	}
	
	@Test
	void validateNumbersWithBooleanParameters() {
		int x=100,y=100;
		Assert.assertEquals((x<y),true,"100 is not greater than 101");
		System.out.println("This will be printed only if, above assertion is passed");
	}
}
