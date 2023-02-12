package basicselenium.dropdowns;

public class DropDownMain {
	
	void test() {
		
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		BasicDropDown bdd = new BasicDropDown();
		bdd.setupWebDriver();
		bdd.locateDropDown();
		bdd.getItemsInDropDown();
		Thread.sleep(2000);
		bdd.dropDownMethods();
		bdd.driver.quit();
	}

}
