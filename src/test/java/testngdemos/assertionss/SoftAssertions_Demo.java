package testngdemos.assertionss;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.*;

public class SoftAssertions_Demo {
	
	/*
	 * TestNg provide SoftAssert class, containing different assertion methods
	 * Also assert result will be reflected in testng report
	 * AssertEquals supports all kind of validations
	 * These are also called as Soft Assertions
	 * Object of SoftAssert is required
	 * If assertion fails no further methods will not be executed
	 * Example : In below example method "validateNumbersWithBooleanParameters()" will not be executed and marked as failed 
	 * because, assertion in "validateNumbers()" is failed
	 */
	SoftAssert softAssert = new SoftAssert();

	@Test(priority=1)
	void validateNumbers() {
		int x=10,y=5;
		AssertJUnit.assertTrue(true);
		AssertJUnit.assertEquals((x>y), false);;
	}
	
	@Test(priority=2)
	void validateNumbersWithBooleanParameters() {
		AssertJUnit.assertEquals(true, true);
		AssertJUnit.assertEquals('X', 'Y');
		AssertJUnit.assertEquals(10, 100);
		AssertJUnit.assertEquals(100.01, 100.01);
		softAssert.assertAll();
		System.out.println("Ptint MSG");
	}

	@Test(priority=3)
	void validateFloats() {
		AssertJUnit.assertEquals(100.01, 100.01);
		System.out.println("Ptint MSG");
	}
}
