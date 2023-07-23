package testngdemos;

import org.testng.annotations.Test;

public class MethodPriorities {
  @Test(priority = 1)
  public void method_A() {
	  System.out.println("A");
  }
  
  @Test(priority = 0)
  public void method_B() {
	  System.out.println("B");
  }
  
  @Test(priority = 2)
  public void method_C() {
	  System.out.println("C");
  }
  
  @Test(priority = 3)
  public void method_D() {
	  System.out.println("D");
  }
  
  @Test(priority = 4)
  public void method_E() {
	  System.out.println("E");
  }
}
