package testngdemos.tannotations;
import org.testng.annotations.*;

public class BeforeAndAfterClass_Annotation2 {
	/*
	 * BeforeClass & AfterClass Annotations:
	 * There are some prerequisite methods which are required to be executed before starting the test methods & after ending the test methods
	 * In this case BeforeClass & AfterClass will be used
	 * No repetition of prerequisite methods
	 * Order is does not matters
	 * Example : Login & Logout methods are prerequisite to executed other methods
	 */

	@BeforeClass
	void printMessage() {
		System.out.println("This is a simple method executed before starting the class execution...");
		System.out.println();
	}
	
	@Test(priority=1)
	void printSum() {
		System.out.println("Sum = "+(10+20));
		System.out.println();
	}
	
	@Test(priority=2)
	void printDiff() {
		System.out.println("Diff = "+(20-05));
		System.out.println();
	} 
	
	@AfterClass
	void printEndMessage() {
		System.out.println("This is a simple method executed after ending the class execution...");
		System.out.println();
	}
}
