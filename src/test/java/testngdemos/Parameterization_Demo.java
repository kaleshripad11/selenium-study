package testngdemos;

public class Parameterization_Demo {
	
	/*
	 * Without using any looping statements we can repeat data use using data providers, which is part of Parameterization concept
	 * Parameterization can be achieved using annotation "@DataProvider" which present in "org.testng.annotations" package
	 * The annotation "@DataProvider" will use parameter called as "name" in order to set the name for dataprovider and this name can be called in @Test parameter "dataprovider"
	 * Any method with the annotation "@DataProvider" will be treated as data provider
	 * And also these methods can get entire data from excel or spreadsheets and pass it in our test methods without using any loops
	 * 
	 * dataprovider method always returns two dimensional array
	 * For dataprovider method, we can return array as well,
	 * example :
	 * String[][] testData(){
	 * 		String data[][] = {};
	 * 		return data;
	 * }
	 * 
	 * If array contains multiple type of data we have to use "object" type for array
	 * While executing the test method, have to pass "dataprovider" parameter to the "@Test" annotation
	 * Ex : @Test(dataprovider="data")
	 * 
	 * indices parameter can be used to use specific element for the given index as parameter to test method
	 */

}
