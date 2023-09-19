package testngdemos;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.*;

public class TestNg_Groups {
	/*
	 * We can group test methods in testng 
	 * To do this, add parameter "groups" to the "test" annotation
	 * Syntax : @Test(groups={"Groupname1", "Groupname2",...})
	 * Also to run the methods in group, it needs to be added in the suite xml file
	 * In XML file <groups> tag will be used inside test
	 * Inside <groups> it will contain <run> tag
	 * Inside <run> it will contain <include> tag with attribute "name"
	 * Value for the "name" attribute will be the group name which we provided in the code
	 */
	
	@BeforeClass
	void printMsg() {
		System.out.println("Beginning the tests!!!");
	}
	
	//@BeforeTest
	@Test(priority=0, groups= {"Sanity","BVT"})
	void loginTest() {
		System.out.println("This is login functionality test case");
	}
	
	//@AfterTest
	@Test(priority=1, groups= {"Sanity","BVT"})
	void logoutTest() {
		System.out.println("This is logout functionality test case");
	}
	
	@Test(priority=2, groups= {"Sanity"})
	void performSearch() {
		System.out.println("This is search functionality test case");
	}
	
	@Test(priority=3, groups = {"BVT"})
	void putOrder() {
		System.out.println("This is put order functionality test case");
	}
}
