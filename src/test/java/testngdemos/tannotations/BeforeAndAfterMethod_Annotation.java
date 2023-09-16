package testngdemos.tannotations;

import org.testng.annotations.Test;
import org.testng.annotations.*;

public class BeforeAndAfterMethod_Annotation {
	/*
	 * BeforeMethod & AfterMethod Annotations:
	 * There are some prerequisite methods which are required to be executed before any other method is being executed
	 * In this case BeforeMethod & BeforeMethod will be used. It works at method level
	 * Prerequisite methods will be repeated
	 * Example : Login & Logout methods are prerequisite to executed other methods
	 */

	@BeforeMethod
	void printBeginningMessage() {
		System.out.println("This is the method under '@BeforeMethod' annotation");
		System.out.println("Beginning of the execution...");
	}
	
	@Test
	void performAddition() {
		System.out.println("Sum of 10 & 20 will be : "+(110+20));
	}
	@Test
	void performMultiplication() {
		System.out.println("Product of 10 & 20 will be : "+(110*20));
	}
	
	@AfterMethod
	void printEndingMessage() {
		System.out.println("This is the method under '@AfterMethod' annotation");
		System.out.println("Ending of the execution...");
	}
}
