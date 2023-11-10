package testngdemos.listenersdemo;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;


public class TestItestListener {
  @Test(priority=1)
  void validateSum() {
	  AssertJUnit.assertEquals(true, false);
  }
  
  @Test(priority=2)
  void validateDiff() {
	  AssertJUnit.assertEquals(true, true);
  }
  
  @Test(priority=3)
  void validateMulti() {
	  AssertJUnit.assertEquals(true, true);
  }
  
  @Test(priority=4, dependsOnMethods = {"validateSum"})
  void validateDiv() {
	  AssertJUnit.assertEquals(true, true);
  }
}
