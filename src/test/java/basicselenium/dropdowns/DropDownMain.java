package basicselenium.dropdowns;

public class DropDownMain {
	
	void test() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicDropDown bdd = new BasicDropDown();
		bdd.setupWebDriver();
		bdd.locateDropDown();
		bdd.getItemsInDropDown();
		bdd.driver.quit();
	}

}
